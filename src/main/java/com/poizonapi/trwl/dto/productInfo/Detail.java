
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
    "googleProductCategory",
    "ageRange",
    "fitId",
    "chineseMade",
    "gender",
    "language",
    "title",
    "frontCategoryId",
    "seriesIds",
    "frontCategoryName",
    "relationBrandIds",
    "areaName",
    "level1CategoryId",
    "brandName",
    "sizeSystem",
    "logoUrl",
    "contentCategory",
    "labelList",
    "createdBy",
    "brandId",
    "spuId",
    "level2CategoryId",
    "sourceName",
    "globalSpuId",
    "categoryId",
    "status"
})
@Generated("jsonschema2pojo")
public class Detail {

    @JsonProperty("googleProductCategory")
    public String googleProductCategory;
    @JsonProperty("ageRange")
    public String ageRange;
    @JsonProperty("fitId")
    public Long fitId;
    @JsonProperty("chineseMade")
    public Boolean chineseMade;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("language")
    public String language;
    @JsonProperty("title")
    public String title;
    @JsonProperty("frontCategoryId")
    public Long frontCategoryId;
    @JsonProperty("seriesIds")
    public List<Long> seriesIds;
    @JsonProperty("frontCategoryName")
    public String frontCategoryName;
    @JsonProperty("relationBrandIds")
    public List<Object> relationBrandIds;
    @JsonProperty("areaName")
    public String areaName;
    @JsonProperty("level1CategoryId")
    public Long level1CategoryId;
    @JsonProperty("brandName")
    public String brandName;
    @JsonProperty("sizeSystem")
    public String sizeSystem;
    @JsonProperty("logoUrl")
    public String logoUrl;
    @JsonProperty("contentCategory")
    public Long contentCategory;
    @JsonProperty("createdBy")
    public String createdBy;
    @JsonProperty("brandId")
    public Long brandId;
    @JsonProperty("spuId")
    public Long spuId;
    @JsonProperty("level2CategoryId")
    public Long level2CategoryId;
    @JsonProperty("sourceName")
    public String sourceName;
    @JsonProperty("globalSpuId")
    public Long globalSpuId;
    @JsonProperty("categoryId")
    public Long categoryId;
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
