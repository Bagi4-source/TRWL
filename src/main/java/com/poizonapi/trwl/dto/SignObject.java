package com.poizonapi.trwl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignObject {
    Map<String, Object> data;
    String aesString;
    String newSign;
}
