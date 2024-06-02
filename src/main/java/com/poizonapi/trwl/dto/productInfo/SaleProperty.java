
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
import com.poizonapi.trwl.dto.priceInfo.PropertyValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "guideTip",
    "displayStyle",
    "showGuide",
    "deviationCodePrompt",
    "level",
    "name",
    "defaultShow",
    "propertyMap",
    "list",
    "propertyKeys",
    "definitionId"
})
@Generated("jsonschema2pojo")
public class SaleProperty {

    @JsonProperty("guideTip")
    public String guideTip;
    @JsonProperty("displayStyle")
    public Long displayStyle;
    @JsonProperty("showGuide")
    public Long showGuide;
    @JsonProperty("deviationCodePrompt")
    public String deviationCodePrompt;
    @JsonProperty("level")
    public Long level;
    @JsonProperty("name")
    public String name;
    @JsonProperty("defaultShow")
    public String defaultShow;
    @JsonProperty("propertyMap")
    public Map<String, List<PropertyValue>> propertyMap;
    @JsonProperty("propertyKeys")
    public java.util.List<String> propertyKeys;
    @JsonProperty("definitionId")
    public Long definitionId;
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
