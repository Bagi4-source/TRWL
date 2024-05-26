package com.poizonapi.trwl.controller;

import com.poizonapi.trwl.service.PoizonAPIParserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.openapitools.client.model.DetailResponseType;
import org.openapitools.client.model.GetProductDetail200Response;
import org.openapitools.client.model.ProductSearchResponse;
import org.openapitools.client.model.SkusInfoMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Dewu")
@CrossOrigin
@RestController
@RequestMapping("/dewu")
class PoizonAPIController {
    @Autowired
    private PoizonAPIParserService poizonAPIParserService;

    @Operation(summary = "Получение информации о товаре")
    @GetMapping("/getProductInfo")
    public DetailResponseType getProductInfo(long spuId) {
        return poizonAPIParserService.getProductInfo(spuId);
    }

    @Operation(summary = "Получение цен товара")
    @GetMapping("/getPriceInfo")
    public SkusInfoMap getPriceInfo(long spuId) {
        return poizonAPIParserService.getSkusInfo(spuId);
    }

    @Operation(summary = "Поиск товаров по ключевому слову")
    @GetMapping("/search")
    public ProductSearchResponse search(
            String keyword, long limit, long page
    ) {
        return poizonAPIParserService.searchProducts(keyword, limit, page);
    }

}