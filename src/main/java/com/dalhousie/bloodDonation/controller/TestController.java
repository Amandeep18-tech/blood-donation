package com.dalhousie.bloodDonation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {
    @GetMapping(value = "/test", produces = "text/plain")
    public String getBook() {
        return "Hello World";
    }
}
