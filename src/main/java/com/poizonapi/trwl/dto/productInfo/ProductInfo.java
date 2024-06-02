
package com.poizonapi.trwl.dto.productInfo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "msg",
    "data",
    "status"
})
@Generated("jsonschema2pojo")
public class ProductInfo {

    @JsonProperty("code")
    public Long code;
    @JsonProperty("msg")
    public String msg;
    @JsonProperty("data")
    public Data data;
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
