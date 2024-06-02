package com.poizonapi.trwl.service;

import com.poizonapi.trwl.dto.Parser;
import com.poizonapi.trwl.dto.Price;
import com.poizonapi.trwl.dto.Size;
import com.poizonapi.trwl.dto.priceInfo.PriceInfo;
import com.poizonapi.trwl.dto.Sneakers;
import com.poizonapi.trwl.dto.priceInfo.SaleProperty;
import com.poizonapi.trwl.dto.priceInfo.Sku;
import com.poizonapi.trwl.dto.priceInfo.PropertyValue;
import com.poizonapi.trwl.dto.productInfo.ProductInfo;
import org.openapitools.client.model.DetailWithPricesResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ProductService {
    @Autowired
    private PoizonAsiaEastParserService poizonAsiaEastService;

    @Autowired
    private PoizonAPIParserService poizonAPIParserService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final Map<String, Size> sizeUSMap = new HashMap<>();
    private final Map<String, Size> sizeEUMap = new HashMap<>();

    @Transactional
    public void updatePriceByProductId(long productId, Parser parser) {
        this.updateSizes();
        Sneakers sneakers = this.getSneakersById(productId);
        System.out.println(sneakers.getId());
        if (parser == Parser.DEWU) {
            updatePriceByProductIdDewu(sneakers);
            return;
        }
        updatePriceByProductIdPoizon(sneakers);
    }

    private void updateSizes(){
        for (Size size : this.getSizes()) {
            sizeUSMap.put(size.getUs(), size);
            sizeEUMap.put(size.getEu(), size);
        }
    }

    @Transactional
    public void updatePriceByVariantId(long variantId, Parser parser) {
        this.updateSizes();
        Sneakers sneakers = this.getSneakersByVariantId(variantId);
        System.out.println(sneakers.getId());
        if (parser == Parser.DEWU) {
            updatePriceByProductIdDewu(sneakers);
            return;
        }
        updatePriceByProductIdPoizon(sneakers);
    }

    @Transactional
    protected void updatePriceByProductIdDewu(Sneakers sneakers){
        long productId = sneakers.getId();
        List<Price> prices = new ArrayList<>();
        DetailWithPricesResponseType productInfoWithPrices = poizonAPIParserService.getProductInfoWithPrices(sneakers.getDewu_id());

        for (var sku : productInfoWithPrices.getSkus()) {
            String sizeValue = null;
            for (var property : sku.getProperties()) {
                if (property.getSaleProperty() != null) {
                    String propertyValue = property.getSaleProperty().getValue();
                    sizeValue = this.extractNumberFromString(propertyValue);
                    if (sizeValue != null) break;
                }
            }
            if (sizeValue == null) continue;
            Size size = this.sizeEUMap.get(sizeValue);
            if (size == null) continue;

            int priceValue = 0;

            if (!sku.getPrice().getPrices().isEmpty()) {
                priceValue = sku.getPrice().getPrices().get(0).getPrice().intValueExact() / 100;
            }

            Price price = new Price();
            price.setId(sku.getSkuId().longValueExact());
            price.setSku_id(sku.getSkuId().longValueExact());
            price.setSneaker_id(productId);
            price.setIs_stock(sku.getStatus().intValueExact() == 1 && priceValue != 0);
            price.setSize_id(size.getId());
            price.setPrice(currencyService.convertCnyToRub(priceValue));
            price.setFrom_dewu(true);

            prices.add(price);
        }
        System.out.println(prices);
        this.savePrices(productId, prices);
    }

    @Transactional
    protected void updatePriceByProductIdPoizon(Sneakers sneakers){
        long productId = sneakers.getId();
        List<Price> prices = new ArrayList<>();
        PriceInfo priceInfo = poizonAsiaEastService.priceInfo(sneakers.getPoizon_id());
        ProductInfo productInfo = poizonAsiaEastService.productInfo2(sneakers.getPoizon_id());
        sneakers.setDewu_id(priceInfo.data.detail.globalSpuId - 10000000000L);
        sneakers.setArticle(priceInfo.data.detail.articleNumber);
        sneakers.setTitle(productInfo.data.detail.title);
        sneakers.setFitId(priceInfo.data.detail.fitId);
        this.updateSneakers(sneakers);

        List<SaleProperty> saleProperties = priceInfo.data.saleProperties.stream().filter(item -> item.name.equalsIgnoreCase("size")).toList();
        SaleProperty saleProperty = saleProperties.get(0);

        if (saleProperty == null) return;

        Map<Long, String> salePropertyMap = new HashMap<>();

        for (PropertyValue property : saleProperty.propertyMap.get(saleProperty.defaultShow)) {
            salePropertyMap.put(property.propertyValueId, property.value);
        }


        for (Sku sku : priceInfo.data.skus) {
            if (sku.skuSpeedInfo == null) continue;
            String propertyValue = null;
            for (var property : sku.properties) {
                propertyValue = salePropertyMap.get(property.propertyValueId);
                if (propertyValue != null) break;
            }
            if (propertyValue == null) continue;

            String sizeValue = this.extractNumberFromString(propertyValue);
            if (sizeValue == null) continue;

            Size size = this.sizeUSMap.get(sizeValue);
            if (size == null) continue;

            int priceValue = 0;

            if (!sku.skuSpeedInfo.isEmpty()) {
                priceValue = sku.skuSpeedInfo.get(0).speedPrice.money.minUnitVal / 100;
            }

            Price price = new Price();
            price.setId(sku.skuId);
            price.setSku_id(sku.skuId);
            price.setSneaker_id(productId);
            price.setIs_stock(sku.status == 1 && priceValue != 0);
            price.setSize_id(size.getId());
            price.setPrice(currencyService.convertUsdToRub(priceValue));
            price.setFrom_dewu(false);

            prices.add(price);
        }
        System.out.println(prices);
        this.savePrices(productId, prices);
    }

    private String extractNumberFromString(String input) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null; // Or throw an exception if no number is found
    }

    public List<Long> getAllProductIds() {
        return namedParameterJdbcTemplate.queryForList("SELECT id FROM sneakers", new MapSqlParameterSource(), Long.class);
    }


    private Sneakers getSneakersById(long productId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("productId", productId);
        String fetchQuery = "SELECT * FROM sneakers WHERE id=:productId";
        try {
            return namedParameterJdbcTemplate.queryForObject(fetchQuery, parameters, new BeanPropertyRowMapper<>(Sneakers.class));
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден!");
        }
    }

    private Sneakers getSneakersByVariantId(long variantId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("variantId", variantId);
        String fetchQuery = "SELECT s.* FROM prices p JOIN sneakers s ON s.id = p.sneaker_id WHERE p.id=:variantId";
        try {
            return namedParameterJdbcTemplate.queryForObject(fetchQuery, parameters, new BeanPropertyRowMapper<>(Sneakers.class));
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден!");
        }
    }

    private void updateSneakers(Sneakers sneakers) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("productId", sneakers.getId());
        parameters.addValue("title", sneakers.getTitle());
        parameters.addValue("article", sneakers.getArticle());
        parameters.addValue("poizon_id", sneakers.getPoizon_id());
        parameters.addValue("dewu_id", sneakers.getDewu_id());
        parameters.addValue("fit_id", sneakers.getFitId());

        String fetchQuery = "UPDATE sneakers SET title=:title, article=:article, dewu_id=:dewu_id, poizon_id=:poizon_id, fit_id=:fit_id WHERE id=:productId";
        namedParameterJdbcTemplate.update(fetchQuery, parameters);
    }

    @Transactional
    protected void savePrices(long productId, List<Price> prices) {
        // Delete existing prices for the product
        namedParameterJdbcTemplate.update("UPDATE prices SET is_stock = 0, price = 0 WHERE sneaker_id=:sneaker_id",
                new MapSqlParameterSource("sneaker_id", productId));

        // Prepare query for batch insert
        String insertQuery = "INSERT INTO prices (sku_id, price, sneaker_id, size_id, is_stock, from_dewu, created_at, updated_at) " +
                "VALUES (:sku_id, :price, :sneaker_id, :size_id, :is_stock, :from_dewu, :created_at, :updated_at)" +
                "ON DUPLICATE KEY UPDATE " +
                "price=VALUES(price), sku_id=VALUES(sku_id), updated_at=VALUES(updated_at), sneaker_id=VALUES(sneaker_id), " +
                "size_id=VALUES(size_id), is_stock=VALUES(is_stock), from_dewu=VALUES(from_dewu)";

        // Create parameter sources for batch update
        MapSqlParameterSource[] batchValues = new MapSqlParameterSource[prices.size()];
        LocalDateTime currentDateTime = LocalDateTime.now();

        for (int i = 0; i < prices.size(); i++) {
            Price price = prices.get(i);
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("id", price.getId());
            parameters.addValue("sku_id", price.getSku_id());
            parameters.addValue("price", price.getPrice());
            parameters.addValue("sneaker_id", price.getSneaker_id());
            parameters.addValue("size_id", price.getSize_id());
            parameters.addValue("is_stock", price.getIs_stock());
            parameters.addValue("from_dewu", price.getFrom_dewu());
            parameters.addValue("created_at", Timestamp.valueOf(currentDateTime));
            parameters.addValue("updated_at", Timestamp.valueOf(currentDateTime));
            batchValues[i] = parameters;
        }

        // Execute batch update
        namedParameterJdbcTemplate.batchUpdate(insertQuery, batchValues);
    }

    private List<Size> getSizes() {
        try {
            return namedParameterJdbcTemplate.query("SELECT * FROM sizes", new MapSqlParameterSource(), new BeanPropertyRowMapper<>(Size.class));
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Товар не найден!");
        }
    }
}
