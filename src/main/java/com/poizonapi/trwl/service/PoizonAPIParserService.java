package com.poizonapi.trwl.service;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.ProductApi;
import org.openapitools.client.api.SearchApi;
import org.openapitools.client.model.DetailResponseType;
import org.openapitools.client.model.ProductSearchResponse;
import org.openapitools.client.model.SkusInfoMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class PoizonAPIParserService {
    ProductApi productApi = new ProductApi();
    SearchApi searchApi = new SearchApi();

    public PoizonAPIParserService(@Value("${poizonAPI.apiKey}") String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.addDefaultHeader("apiKey", apiKey);
        productApi.setApiClient(apiClient);
        searchApi.setApiClient(apiClient);
    }

    public DetailResponseType getProductInfo(long spuId) {
        try {
            return productApi.dewuControllerGetProductDetail(String.valueOf(spuId));
        } catch (ApiException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", e);
        }
    }

    public SkusInfoMap getSkusInfo(long spuId) {
        try {
            return productApi.dewuControllerGetSkuInfoBySpuId(BigDecimal.valueOf(spuId));
        } catch (ApiException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", e);
        }
    }

    public ProductSearchResponse searchProducts(String keyword, long limit, long page) {
        try {
            return searchApi.dewuControllerSearchProducts(keyword, BigDecimal.valueOf(limit), BigDecimal.valueOf(page));
        } catch (ApiException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", e);
        }
    }
}
