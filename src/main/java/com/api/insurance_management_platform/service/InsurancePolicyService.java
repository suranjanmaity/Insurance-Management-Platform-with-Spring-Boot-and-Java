package com.api.insurance_management_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.insurance_management_platform.dao.InsurancePolicyDao;
import com.api.insurance_management_platform.dto.InsurancePolicy;

@Service
public class InsurancePolicyService {
    @Autowired
    InsurancePolicyDao dao;
    public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
        return dao.insertInsurancePolicy(insurancePolicy);
    }
    public InsurancePolicy updateInsurancePolicy(int id, InsurancePolicy insurancePolicy) {
        return dao.updateInsurancePolicy(id, insurancePolicy);
    }
    public void deleteInsurancePolicy(int id){
        dao.deleteInsurancePolicy(id);
    }
    public List<InsurancePolicy> getAllInsurancePolicies(){
        return dao.getAllInsurancePolicies();
    }
    public InsurancePolicy getInsurancePolicy(int id){
        return dao.getInsurancePolicy(id);
    }
}
