package com.poizonapi.trwl.controller;

import com.poizonapi.trwl.dto.priceInfo.PriceInfo;
import com.poizonapi.trwl.dto.productInfo.ProductInfo;
import com.poizonapi.trwl.service.PoizonAsiaEastParserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Tag(name = "Poizon")
@CrossOrigin
@RestController
@RequestMapping("/poizon")
class PoizonAsiaEastController {
    @Autowired
    private PoizonAsiaEastParserService poizonAsiaEastParserService;

    @Operation(summary = "Получение информации о товаре")
    @GetMapping("/getProductInfo")
    public ResponseEntity<Map<String, Object>> getProductInfo(long spuId) {
        return poizonAsiaEastParserService.productInfo(spuId);
    }

    @Operation(summary = "Получение информации о товаре 2")
    @GetMapping("/getProductInfo2")
    public ProductInfo getProductInfo2(long spuId) {
        return poizonAsiaEastParserService.productInfo2(spuId);
    }

    @Operation(summary = "Получение цен товара")
    @GetMapping("/getPriceInfo")
    public PriceInfo getPriceInfo(long spuId) {
        return poizonAsiaEastParserService.priceInfo(spuId);
    }

    @Operation(summary = "Получение размерных сеток")
    @GetMapping("/getSizeTable")
    public ResponseEntity<Map<String, Object>> getSizeTable(long spuId) {
        return poizonAsiaEastParserService.sizeTable(spuId);
    }

    @Operation(summary = "Получение похожих товаров")
    @GetMapping("/getSimilarProducts")
    public ResponseEntity<Map<String, Object>> getSimilarProducts(long spuId) {
        return poizonAsiaEastParserService.similarProducts(spuId);
    }

    @Operation(summary = "Получение рекомендованных товаров")
    @GetMapping("/getRecommendedProducts")
    public ResponseEntity<Map<String, Object>> getRecommendedProducts(long spuId, int pageOffset, int pageSize) {
        return poizonAsiaEastParserService.recommendedProducts(spuId, pageOffset, pageSize);
    }

    @Operation(summary = "Поиск товаров по ключевому слову")
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> search(String keyword, int page, int pageSize) {
        return poizonAsiaEastParserService.getItems(keyword, page, pageSize);
    }

    @Operation(summary = "Поиск товаров по бренду")
    @GetMapping("/searchByBrandId")
    public ResponseEntity<Map<String, Object>> searchByBrandId(long brandId, int page, int pageSize) {
        return poizonAsiaEastParserService.searchByBrandId(brandId, page, pageSize);
    }

    @Operation(summary = "Получение списка брендов")
    @GetMapping("/brandList")
    public ResponseEntity<Map<String, Object>> brandList() {
        return poizonAsiaEastParserService.brandList();
    }
}