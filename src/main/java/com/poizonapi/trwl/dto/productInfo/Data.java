
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
    "sellButton",
    "shareInfo",
    "skus",
    "deviationCodePrompt",
    "records",
    "saleProperties",
    "imageAndText",
    "loginFlag",
    "authenticatedInfo",
    "commodityArModel",
    "favoriteList",
    "price",
    "baseProperties",
    "paymentMethods",
    "whyPoizon",
    "categoryUiOptimization",
    "intlProductRankingInfo",
    "deliveryInfo",
    "commodity3DModel",
    "brandItemsModel",
    "styleMode",
    "saleCount",
    "returnAndBack",
    "imageModelList",
    "isAdd",
    "easyReturnInfo",
    "shipProtectionInfo",
    "showSizeGuide",
    "imageModels",
    "priceForSell",
    "detail",
    "newUserActivity",
    "shoppingAtEase"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("skus")
    public List<Sku> skus;
    @JsonProperty("deviationCodePrompt")
    public String deviationCodePrompt;
    @JsonProperty("saleProperties")
    public List<SaleProperty> saleProperties;
    @JsonProperty("imageAndText")
    public List<Object> imageAndText;
    @JsonProperty("favoriteList")
    public List<Object> favoriteList;
    @JsonProperty("price")
    public Price price;
    @JsonProperty("baseProperties")
    public List<BaseProperty> baseProperties;
    @JsonProperty("paymentMethods")
    public List<String> paymentMethods;
    @JsonProperty("categoryUiOptimization")
    public Boolean categoryUiOptimization;
    @JsonProperty("brandItemsModel")
    public BrandItemsModel brandItemsModel;
    @JsonProperty("styleMode")
    public Long styleMode;
    @JsonProperty("saleCount")
    public String saleCount;
    @JsonProperty("imageModelList")
    public List<Object> imageModelList;
    @JsonProperty("isAdd")
    public Boolean isAdd;
    @JsonProperty("showSizeGuide")
    public Long showSizeGuide;
    @JsonProperty("imageModels")
    public List<ImageModel> imageModels;
    @JsonProperty("priceForSell")
    public PriceForSell priceForSell;
    @JsonProperty("detail")
    public Detail detail;
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
