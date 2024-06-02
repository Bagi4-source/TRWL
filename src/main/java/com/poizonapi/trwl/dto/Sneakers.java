package com.poizonapi.trwl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sneakers {
    Long id;
    String title;
    String description;
    String article;
    Long category_id;
    Long brand_id;
    Long dewu_id;
    Long poizon_id;
    Integer fitId;
}
