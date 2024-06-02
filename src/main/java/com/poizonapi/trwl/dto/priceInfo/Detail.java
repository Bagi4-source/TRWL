
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
    "spuId",
    "globalSpuId",
    "isSelf",
    "categoryId",
    "level1CategoryId",
    "level2CategoryId",
    "brandId",
    "relationBrandIds",
    "preSellStatus",
    "logoUrl",
    "title",
    "subTitle",
    "authPrice",
    "sellDate",
    "sourceName",
    "articleNumber",
    "articleNumbers",
    "preSellDeliverTime",
    "preSellLimitPurchase",
    "isShowPreSellTag",
    "isPreSellNew",
    "isShow",
    "crossStatus",
    "isShowCrossTag",
    "fitId",
    "defaultSkuId",
    "goodsType",
    "heat",
    "soldNum",
    "limitOffer",
    "areaName",
    "language",
    "status",
    "buyStatus",
    "showSizeTableTips",
    "sizeTableTips",
    "showSpuSizeApply",
    "createdBy",
    "areaId",
    "contentCategory",
    "googleProductCategory"
})
@Generated("jsonschema2pojo")
public class Detail {

    @JsonProperty("spuId")
    public Long spuId;
    @JsonProperty("globalSpuId")
    public Long globalSpuId;
    @JsonProperty("isSelf")
    public Long isSelf;
    @JsonProperty("categoryId")
    public Long categoryId;
    @JsonProperty("level1CategoryId")
    public Long level1CategoryId;
    @JsonProperty("level2CategoryId")
    public Long level2CategoryId;
    @JsonProperty("brandId")
    public Long brandId;
    @JsonProperty("relationBrandIds")
    public List<Object> relationBrandIds;
    @JsonProperty("preSellStatus")
    public Long preSellStatus;
    @JsonProperty("logoUrl")
    public String logoUrl;
    @JsonProperty("title")
    public String title;
    @JsonProperty("subTitle")
    public String subTitle;
    @JsonProperty("authPrice")
    public Long authPrice;
    @JsonProperty("sellDate")
    public String sellDate;
    @JsonProperty("sourceName")
    public String sourceName;
    @JsonProperty("articleNumber")
    public String articleNumber;
    @JsonProperty("articleNumbers")
    public List<Object> articleNumbers;
    @JsonProperty("preSellDeliverTime")
    public Long preSellDeliverTime;
    @JsonProperty("preSellLimitPurchase")
    public Long preSellLimitPurchase;
    @JsonProperty("isShowPreSellTag")
    public Long isShowPreSellTag;
    @JsonProperty("isPreSellNew")
    public Long isPreSellNew;
    @JsonProperty("isShow")
    public Long isShow;
    @JsonProperty("crossStatus")
    public Long crossStatus;
    @JsonProperty("isShowCrossTag")
    public Long isShowCrossTag;
    @JsonProperty("fitId")
    public Integer fitId;
    @JsonProperty("defaultSkuId")
    public Long defaultSkuId;
    @JsonProperty("goodsType")
    public Long goodsType;
    @JsonProperty("heat")
    public Long heat;
    @JsonProperty("soldNum")
    public Long soldNum;
    @JsonProperty("limitOffer")
    public Long limitOffer;
    @JsonProperty("areaName")
    public String areaName;
    @JsonProperty("language")
    public String language;
    @JsonProperty("status")
    public Long status;
    @JsonProperty("buyStatus")
    public Long buyStatus;
    @JsonProperty("showSizeTableTips")
    public Long showSizeTableTips;
    @JsonProperty("sizeTableTips")
    public String sizeTableTips;
    @JsonProperty("showSpuSizeApply")
    public Long showSpuSizeApply;
    @JsonProperty("createdBy")
    public String createdBy;
    @JsonProperty("areaId")
    public Long areaId;
    @JsonProperty("contentCategory")
    public Long contentCategory;
    @JsonProperty("googleProductCategory")
    public String googleProductCategory;
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
