package com.poizonapi.trwl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size {
    Long id;
    String us;
    String eu;
    String uk;
    String ru;
    String cm;
}
