
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
    "name",
    "level",
    "definitionId",
    "showGuide",
    "guideTip",
    "deviationCodePrompt",
    "defaultShow",
    "propertyMap",
    "displayStyle"
})
@Generated("jsonschema2pojo")
public class SaleProperty {

    @JsonProperty("name")
    public String name;
    @JsonProperty("level")
    public Long level;
    @JsonProperty("definitionId")
    public Long definitionId;
    @JsonProperty("showGuide")
    public Long showGuide;
    @JsonProperty("guideTip")
    public String guideTip;
    @JsonProperty("deviationCodePrompt")
    public String deviationCodePrompt;
    @JsonProperty("defaultShow")
    public String defaultShow;
    @JsonProperty("propertyMap")
    public Map<String, List<PropertyValue>> propertyMap;
    @JsonProperty("displayStyle")
    public Long displayStyle;
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
