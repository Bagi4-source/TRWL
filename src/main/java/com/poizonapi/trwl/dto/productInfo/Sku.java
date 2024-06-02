
package com.poizonapi.trwl.dto.productInfo;

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
    "spuId",
    "skuId",
    "authPrice",
    "properties",
    "status"
})
@Generated("jsonschema2pojo")
public class Sku {

    @JsonProperty("spuId")
    public Long spuId;
    @JsonProperty("skuId")
    public Long skuId;
    @JsonProperty("authPrice")
    public Long authPrice;
    @JsonProperty("properties")
    public List<Property> properties;
    @JsonProperty("status")
    public Long status;
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
