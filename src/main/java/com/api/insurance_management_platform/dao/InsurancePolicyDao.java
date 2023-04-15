package com.api.insurance_management_platform.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.insurance_management_platform.dto.InsurancePolicy;
import com.api.insurance_management_platform.repository.InsurancePolicyRepository;

@Repository
public class InsurancePolicyDao {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    // insert insurancePolicy
    public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
        insurancePolicyRepository.save(insurancePolicy);
        return insurancePolicy;
    }
    // update insurancePolicy
    public InsurancePolicy updateInsurancePolicy(int id, InsurancePolicy insurancePolicy) {
        if (insurancePolicyRepository.findById(id).isPresent()) {
            InsurancePolicy dbInsurancePolicy = insurancePolicyRepository.findById(id).get();
            if (dbInsurancePolicy.getPolicyNumber()==insurancePolicy.getPolicyNumber()) {
                if((insurancePolicy.getPolicyType()!=dbInsurancePolicy.getPolicyType())&&(insurancePolicy.getPolicyType()!=null)) {
                    dbInsurancePolicy.setPolicyType(insurancePolicy.getPolicyType());
                }
                if((insurancePolicy.getPolicyCoverageAmount()!=dbInsurancePolicy.getPolicyCoverageAmount())&&(insurancePolicy.getPolicyCoverageAmount()!=0)){
                    dbInsurancePolicy.setPolicyCoverageAmount(insurancePolicy.getPolicyCoverageAmount());
                }
                if((insurancePolicy.getPolicyPremium()!=dbInsurancePolicy.getPolicyPremium())&&(insurancePolicy.getPolicyPremium()!=0)){
                    dbInsurancePolicy.setPolicyPremium(insurancePolicy.getPolicyPremium());
                }
                if((insurancePolicy.getPolicyStartDate()!=dbInsurancePolicy.getPolicyStartDate())&&(insurancePolicy.getPolicyStartDate()!=null)){
                    dbInsurancePolicy.setPolicyStartDate(insurancePolicy.getPolicyStartDate());
                }
                if((insurancePolicy.getPolicyEndDate()!=dbInsurancePolicy.getPolicyEndDate())&&(insurancePolicy.getPolicyEndDate()!=null)){
                    dbInsurancePolicy.setPolicyEndDate(insurancePolicy.getPolicyEndDate());
                }
                if((insurancePolicy.getClient()!=dbInsurancePolicy.getClient())&&(insurancePolicy.getClient()!=null)){
                    dbInsurancePolicy.setClient(insurancePolicy.getClient());
                }
                
            }
            insurancePolicyRepository.save(dbInsurancePolicy);
            return dbInsurancePolicy;
        }
        return null;
    }
    // delete a insurancePolicy
    public void deleteInsurancePolicy(int id){
        insurancePolicyRepository.deleteById(id);
    }
    // display all
    public List<InsurancePolicy> getAllInsurancePolicies(){
        return insurancePolicyRepository.findAll();
    }
    // display by id
    public InsurancePolicy getInsurancePolicy(int id){
        if (insurancePolicyRepository.findById(id).isPresent()) {
            return insurancePolicyRepository.findById(id).get();
        }
        return null;
    }
}
