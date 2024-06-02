
package com.poizonapi.trwl.dto.productInfo;

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
    "name",
    "linkUrl",
    "defaultShow",
    "value",
    "key",
    "supportCopy"
})
@Generated("jsonschema2pojo")
public class BaseProperty {

    @JsonProperty("name")
    public String name;
    @JsonProperty("linkUrl")
    public String linkUrl;
    @JsonProperty("defaultShow")
    public Long defaultShow;
    @JsonProperty("value")
    public String value;
    @JsonProperty("key")
    public String key;
    @JsonProperty("supportCopy")
    public Long supportCopy;
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
