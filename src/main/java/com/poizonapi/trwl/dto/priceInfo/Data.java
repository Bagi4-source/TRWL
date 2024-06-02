
package com.poizonapi.trwl.dto.priceInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "detail",
    "saleProperties",
    "skus",
    "skuSpeedTitle",
    "noAvailableInvTitle",
    "floatingLayerTitle",
    "buyForTitle",
    "contentCategory",
    "googleProductCategory",
    "spuId",
    "promotionCouponInfoMap"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("detail")
    public Detail detail;
    @JsonProperty("saleProperties")
    public List<SaleProperty> saleProperties;
    @JsonProperty("skus")
    public List<Sku> skus;
    @JsonProperty("skuSpeedTitle")
    public String skuSpeedTitle;
    @JsonProperty("noAvailableInvTitle")
    public String noAvailableInvTitle;
    @JsonProperty("floatingLayerTitle")
    public String floatingLayerTitle;
    @JsonProperty("buyForTitle")
    public String buyForTitle;
    @JsonProperty("contentCategory")
    public Long contentCategory;
    @JsonProperty("googleProductCategory")
    public String googleProductCategory;
    @JsonProperty("spuId")
    public Long spuId;
    @JsonProperty("promotionCouponInfoMap")
    public PromotionCouponInfoMap promotionCouponInfoMap;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
