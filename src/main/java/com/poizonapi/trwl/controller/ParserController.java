package com.poizonapi.trwl.controller;

import com.poizonapi.trwl.dto.Parser;
import com.poizonapi.trwl.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Parser")
@CrossOrigin
@RestController
@RequestMapping("/parser")
class ParserController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Обновление цены товара")
    @GetMapping("/updatePriceByProductId")
    public void updatePriceByProductId(long productId, Parser parser) {
        productService.updatePriceByProductId(productId, parser);
    }

    @Operation(summary = "Обновление цены товара по id варианта")
    @GetMapping("/updatePriceByVariantId")
    public void updatePriceByVariantId(long variantId, Parser parser) {
        productService.updatePriceByVariantId(variantId, parser);
    }


    @Operation(summary = "Получение всех id товаров")
    @GetMapping("/getAllProductIds")
    public List<Long> getAllProductIds() {
        return productService.getAllProductIds();
    }
}