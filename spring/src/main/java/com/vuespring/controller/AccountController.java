package com.vuespring.controller;

import com.vuespring.model.Account;
import com.vuespring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PatchMapping("/{id}/branding-color")
    public ResponseEntity<Account> updateBrandingColor(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String brandingColorCode = request.get("brandingColorCode");
        Account account = accountService.updateBrandingColor(id, brandingColorCode);
        return ResponseEntity.ok(account);
    }
}
