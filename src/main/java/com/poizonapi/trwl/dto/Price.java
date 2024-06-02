package com.poizonapi.trwl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    Long id;
    Long sku_id;
    Long sneaker_id;
    Long size_id;
    Integer price;
    Boolean is_stock;
    Boolean from_dewu;
}
