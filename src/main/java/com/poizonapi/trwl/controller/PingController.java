package com.poizonapi.trwl.controller;

import com.poizonapi.trwl.dto.Parser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
class PingController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}