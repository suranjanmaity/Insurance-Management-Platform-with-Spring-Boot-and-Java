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

import com.api.insurance_management_platform.dto.InsurancePolicy;
import com.api.insurance_management_platform.service.InsurancePolicyService;
@RestController
public class InsurancePolicyController {
    @Autowired
    InsurancePolicyService service;
    @PostMapping("/api/policies")
    public InsurancePolicy insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
        return service.insertInsurancePolicy(insurancePolicy);
    }
    @PutMapping("/api/policies/{id}")
    public InsurancePolicy updateInsurancePolicy(@PathVariable int id, @RequestBody InsurancePolicy insurancePolicy) {
        return service.updateInsurancePolicy(id, insurancePolicy);
    }
    @DeleteMapping("/api/policies/{id}")
    public void deleteInsurancePolicy(@PathVariable int id){
        service.deleteInsurancePolicy(id);
    }
    @GetMapping("/api/policies")
    public List<InsurancePolicy> getAllInsurancePolicies(){
        return service.getAllInsurancePolicies();
    }
    @GetMapping("/api/policies/{id}")
    public InsurancePolicy getInsurancePolicy(@PathVariable int id){
        return service.getInsurancePolicy(id);
    }
}
