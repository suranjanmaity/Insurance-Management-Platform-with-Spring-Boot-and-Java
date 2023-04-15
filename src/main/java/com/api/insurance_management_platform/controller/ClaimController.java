package com.api.insurance_management_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.insurance_management_platform.dto.Claim;
import com.api.insurance_management_platform.service.ClaimService;

@RestController
public class ClaimController {
    @Autowired
    ClaimService service;
    @PostMapping("/api/claims")
    public Claim insertClaim(@RequestBody Claim claim) {
        return service.insertClaim(claim);
    }
    @PutMapping("/api/claims/{id}")
    public Claim updateClaim(@PathVariable int id,@RequestBody Claim claim) {
        return service.updateClaim(id, claim);
    }
    @DeleteMapping("/api/claims/{id}")
    public void deleteClaim(@PathVariable int id){
        service.deleteClaim(id);
    }
    @GetMapping("/api/claims")
    public List<Claim> getAllClaims(){
        return service.getAllClaims();
    }
    @GetMapping("/api/claims/{id}")
    public Claim getClaim(@PathVariable int id){
        return service.getClaim(id);
    }
}
