package com.poizonapi.trwl.service;

import com.poizonapi.trwl.dto.SignObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PoizonAsiaEastParserService {
    @Autowired
    private SignService signService;

    private final RestTemplate restTemplate;

    public PoizonAsiaEastParserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<Map<String, Object>> productInfo(long spuId) {
        HttpHeaders headers = getDefaultHeaders();
        Map<String, Object> data = new HashMap<>();
        data.put("uuid", "813d91d1dd27edf9");
        data.put("loginToken", "");
        data.put("platform", "android");
        data.put("spuId", spuId);
        data.put("timestamp", "1709102939889");
        data.put("v", "5.36.000");

        SignObject dataSigned = signService.getNewSign(data);
        data = dataSigned.getData();
        data.put("sign", data.get("newSign"));
        data.remove("uuid");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(dataSigned.getData(), headers);

        String url = "https://asia-east-public.poizon.com/api/v1/app/bigger/intl/commodity/app/get-index-spu-detail";

        return makeDewuResponse(request, url);
    }

    public ResponseEntity<Map<String, Object>> sizeTable(long spuId) {
        HttpHeaders headers = getDefaultHeaders();
        Map<String, Object> data = new HashMap<>();
        data.put("uuid", "813d91d1dd27edf9");
        data.put("loginToken", "");
        data.put("platform", "android");
        data.put("spuId", spuId);
        data.put("timestamp", "1709102939889");
        data.put("v", "5.36.000");

        SignObject dataSigned = signService.getNewSign(data);
        data = dataSigned.getData();
        data.put("sign", data.get("newSign"));
        data.remove("uuid");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(dataSigned.getData(), headers);

        String url = "https://asia-east-public.poizon.com/api/v1/app/bigger/intl/commodity/v1/get-size-tab";
        return makeDewuResponse(request, url);
    }

    public ResponseEntity<Map<String, Object>> similarProducts(long spuId) {
        HttpHeaders headers = getDefaultHeaders();
        Map<String, Object> data = new HashMap<>();
        data.put("uuid", "813d91d1dd27edf9");
        data.put("loginToken", "");
        data.put("platform", "android");
        data.put("spuId", spuId);
        data.put("timestamp", "1709102939889");
        data.put("v", "5.36.000");

        SignObject dataSigned = signService.getNewSign(data);
        data = dataSigned.getData();
        data.put("sign", data.get("newSign"));
        data.remove("uuid");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(dataSigned.getData(), headers);

        String url = "https://asia-east-public.poizon.com/api/v1/app/bigger/intl/commodity/queryDetailWaterfallFlow";
        return makeDewuResponse(request, url);
    }

    public ResponseEntity<Map<String, Object>> priceInfo(long spuId) {
        HttpHeaders headers = getDefaultHeaders();
        Map<String, Object> data = new HashMap<>();
        data.put("uuid", "813d91d1dd27edf9");
        data.put("loginToken", "");
        data.put("platform", "android");
        data.put("spuId", spuId);
        data.put("timestamp", "1709102939889");
        data.put("v", "5.36.000");

        SignObject dataSigned = signService.getNewSign(data);
        data = dataSigned.getData();
        data.put("sign", data.get("newSign"));
        data.remove("uuid");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(dataSigned.getData(), headers);

        String url = "https://asia-east-public.poizon.com/api/v1/app/bigger/intl/commodity/queryPurchaseFloatingLayer";
        return makeDewuResponse(request, url);
    }

    public ResponseEntity<Map<String, Object>> getItems(String keyword, int page, int pageSize) {
        HttpHeaders headers = getDefaultHeaders();
        Map<String, Object> data = new HashMap<>();
        data.put("uuid", "813d91d1dd27edf9");
        data.put("acm", "");
        data.put("brandId", "");
        data.put("brandIdList", new String[]{});
        data.put("filterFacets", new String[]{});
        data.put("frontCategoryIds", new String[]{});
        data.put("keywords", keyword);
        data.put("level1CategoryId", "");
        data.put("level2CategoryId", "");
        data.put("loginToken", "");
        data.put("pageNum", page);
        data.put("pageSize", pageSize);
        data.put("platform", "android");
        data.put("scene", 1);
        data.put("sortMode", 1);
        data.put("sortType", 0);
        data.put("spuTagIds", new String[]{});
        data.put("timestamp", "1709102939889");
        data.put("topSpuIds", new String[]{});
        data.put("v", "5.36.000");

        SignObject dataSigned = signService.getNewSign(data);
        data = dataSigned.getData();
        data.put("sign", data.get("newSign"));
        data.remove("uuid");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(dataSigned.getData(), headers);

        String url = "https://asia-east-public.poizon.com/api/v1/app/bigger/intl/spu-search/app/spu/list";
        return makeDewuResponse(request, url);
    }

    private ResponseEntity<Map<String, Object>> makeDewuResponse(HttpEntity<Map<String, Object>> request, String url) {
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> result = response.getBody();
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(null);
        }
    }

    private HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("province", "");
        headers.set("city", "");
        headers.set("zipCode", "");
        headers.set("duimei", "");
        headers.set("duplatform", "android");
        headers.set("duchannel", "google");
        headers.set("duv", "5.36.000");
        headers.set("duBuildNum", "5.36.000.1000");
        headers.set("duloginToken", "");
        headers.set("dudeviceTrait", "M2004J19C");
        headers.set("timestamp", "1709102939889");
        headers.set("User-Agent", "Poizon/5.36.000(android;11)");
        headers.set("timeZone", "GMT+04:00");
        headers.set("language", "en");
        headers.set("region", "US");
        headers.set("cookieToken", "");
        headers.set("isRoot", "0");
        headers.set("emu", "0");
        headers.set("isProxy", "0");
        headers.set("sysVersion", "11");
        headers.set("apptum", "google");
        headers.set("swidth", "1080");
        headers.set("sheight", "2134");
        headers.set("resolution", "1080*2134");
        headers.set("SK", "9Ol3MmFUcwmj9P81JlNfaZ5Hm37TNb0ciYuZZDqncbhL8YWDCYBdOLxNUMc11c5V6JvbvJtgGul3CZHugzL2S7n0r91t");
        headers.set("duproductid", "4D6996999C590B21AC1A30EB04BE11DABDFE24914A4EEF24D4D5C25559243BDD");
        headers.set("sks", "0,adw2");
        return headers;
    }

}
