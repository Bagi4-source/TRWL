
package com.poizonapi.trwl.dto.priceInfo;

import java.util.LinkedHashMap;
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
    "sorted",
    "saleInventoryNo",
    "speedPrice",
    "minDay",
    "maxDay",
    "speedInfoTip"
})
@Generated("jsonschema2pojo")
public class SkuSpeedInfo {

    @JsonProperty("sorted")
    public Long sorted;
    @JsonProperty("saleInventoryNo")
    public String saleInventoryNo;
    @JsonProperty("speedPrice")
    public SpeedPrice speedPrice;
    @JsonProperty("minDay")
    public Long minDay;
    @JsonProperty("maxDay")
    public Long maxDay;
    @JsonProperty("speedInfoTip")
    public String speedInfoTip;
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
