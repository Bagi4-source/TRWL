package com.poizonapi.trwl.service;

import org.springframework.stereotype.Service;


@Service
public class CurrencyService {
    public int convertUsdToRub(int amount) {
        return amount * 100;
    }
    public int convertCnyToRub(int amount) {
        return amount * 15;
    }
}
