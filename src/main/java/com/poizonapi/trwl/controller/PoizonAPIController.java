package com.poizonapi.trwl.controller;

import com.poizonapi.trwl.service.PoizonAPIParserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.openapitools.client.model.GetProductDetail200Response;


@Tag(name = "Dewu")
@CrossOrigin
@RestController
@RequestMapping("/dewu")
class PoizonAPIController {
    @Autowired
    private PoizonAPIParserService poizonAPIParserService;

    @GetMapping("/getProductInfo")
    long getNewSign(long spuId) {
//        return poizonAPIParserService.getProductInfo(spuId);
        return spuId;
    }

}