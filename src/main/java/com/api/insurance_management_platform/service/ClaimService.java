package com.api.insurance_management_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.insurance_management_platform.dao.ClaimDao;
import com.api.insurance_management_platform.dao.InsurancePolicyDao;
import com.api.insurance_management_platform.dto.Claim;
import com.api.insurance_management_platform.dto.InsurancePolicy;
@Service
public class ClaimService {

    @Autowired
    ClaimDao dao;
    @Autowired
    InsurancePolicyDao policyDao;
    public Claim insertClaim(Claim claim) { // policy id db exist    fetch db data of policy  set in passed claim
        if (claim.getInsurancePolicy()!=null) {
            int claimPolicyId = claim.getInsurancePolicy().getPolicyNumber();
            if (policyDao.getInsurancePolicy(claimPolicyId)!=null) {
                InsurancePolicy claimPolicy = claim.getInsurancePolicy();
                policyDao.updateInsurancePolicy(claimPolicyId, claimPolicy);
                claim.setInsurancePolicy(policyDao.getInsurancePolicy(claimPolicyId));
            }
        }
        if (claim.getInsurancePolicy().getPolicyNumber()>0) {
            return dao.insertClaim(claim);
        }
        return null;
    }
    public Claim updateClaim(int id, Claim claim) {
        if (claim.getInsurancePolicy()!=null) {
            int claimPolicyId = claim.getInsurancePolicy().getPolicyNumber();
            if (policyDao.getInsurancePolicy(claimPolicyId)!=null) {
                InsurancePolicy claimPolicy = claim.getInsurancePolicy();
                policyDao.updateInsurancePolicy(claimPolicyId, claimPolicy);
                claim.setInsurancePolicy(policyDao.getInsurancePolicy(claimPolicyId));
            }
        }
        return dao.updateClaim(id, claim);
    }
    public void deleteClaim(int id){
        dao.deleteClaim(id);
    }
    public List<Claim> getAllClaims(){
        return dao.getAllClaims();
    }
    public Claim getClaim(int id){
        return dao.getClaim(id);
    }
}
