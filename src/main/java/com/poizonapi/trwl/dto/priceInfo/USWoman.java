
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
    "propertyId",
    "name",
    "value",
    "propertyValueId",
    "level",
    "sort",
    "definitionId"
})
@Generated("jsonschema2pojo")
public class USWoman {

    @JsonProperty("propertyId")
    public Long propertyId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("value")
    public String value;
    @JsonProperty("propertyValueId")
    public Long propertyValueId;
    @JsonProperty("level")
    public Long level;
    @JsonProperty("sort")
    public Long sort;
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
