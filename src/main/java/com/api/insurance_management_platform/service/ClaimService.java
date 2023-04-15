package com.api.insurance_management_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.insurance_management_platform.dao.ClaimDao;
import com.api.insurance_management_platform.dto.Claim;
@Service
public class ClaimService {

    @Autowired
    ClaimDao dao;
    public Claim insertClaim(Claim claim) {
        if (claim.getInsurancePolicy().getPolicyNumber()>0) {
            return dao.insertClaim(claim);
        }
        return null;
    }
    public Claim updateClaim(int id, Claim claim) {
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
