
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
    "skuId",
    "spuId",
    "authPrice",
    "status",
    "properties",
    "minPrice",
    "skuSpeedInfo",
    "couponInfo"
})
@Generated("jsonschema2pojo")
public class Sku {

    @JsonProperty("skuId")
    public Long skuId;
    @JsonProperty("spuId")
    public Long spuId;
    @JsonProperty("authPrice")
    public Long authPrice;
    @JsonProperty("status")
    public Long status;
    @JsonProperty("properties")
    public List<Property> properties;
    @JsonProperty("minPrice")
    public MinPrice minPrice;
    @JsonProperty("skuSpeedInfo")
    public List<SkuSpeedInfo> skuSpeedInfo;
    @JsonProperty("couponInfo")
    public CouponInfo couponInfo;
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
