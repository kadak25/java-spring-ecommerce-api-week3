package com.example.ecommerce_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    // Authenticated herkes erişebilir
    @GetMapping("/all")
    public ResponseEntity<String> allAccess() {
        return ResponseEntity.ok("Tebrikler! Token'ın çalışıyor, authenticated oldun!");
    }

    // Sadece USER role’u olanlar
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> userAccess() {
        return ResponseEntity.ok("Merhaba USER! Role kontrolü çalışıyor.");
    }

    // Sadece ADMIN role’u olanlar
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("Merhaba ADMIN! Sadece admin görebilir.");
    }
}