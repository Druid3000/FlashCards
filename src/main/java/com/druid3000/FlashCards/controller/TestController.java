package com.druid3000.FlashCards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public ResponseEntity test(){
        return ResponseEntity.status(HttpStatus.OK).body(new Object());
    }
}
