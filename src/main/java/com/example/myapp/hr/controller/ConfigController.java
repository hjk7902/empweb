package com.example.myapp.hr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;

    @GetMapping("/api-url")
    public ResponseEntity<Map<String, String>> getApiUrl() {
        Map<String, String> response = new HashMap<>();
        response.put("apiBaseUrl", apiBaseUrl);
        return ResponseEntity.ok(response);
    }
}
