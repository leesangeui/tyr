package com.midgard.tyr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("hello")
    public List<String> Hello() {
        this.hello = "hi";
        return Arrays.asList("Hello Midgard");

    }
    private String hello;
}
