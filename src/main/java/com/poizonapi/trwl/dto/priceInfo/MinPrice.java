
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
    "money",
    "symbol",
    "amountText",
    "absText",
    "sign"
})
@Generated("jsonschema2pojo")
public class MinPrice {

    @JsonProperty("money")
    public Money money;
    @JsonProperty("symbol")
    public String symbol;
    @JsonProperty("amountText")
    public String amountText;
    @JsonProperty("absText")
    public String absText;
    @JsonProperty("sign")
    public String sign;
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
