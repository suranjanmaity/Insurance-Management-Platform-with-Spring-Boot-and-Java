package com.api.insurance_management_platform.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.insurance_management_platform.dto.Claim;
import com.api.insurance_management_platform.repository.ClaimRepository;

@Repository
public class ClaimDao {
    @Autowired
    ClaimRepository claimRepository;

    // insert claim
    public Claim insertClaim(Claim claim) {
        claimRepository.save(claim);
        return claim;
    }
    // update claim
    public Claim updateClaim(int id, Claim claim) {
        if (claimRepository.findById(id).isPresent()) {
            Claim dbClaim = claimRepository.findById(id).get();
            // to check if user passed claim no. is equal to database claim no.
            if (dbClaim.getClaimNumber()==claim.getClaimNumber()) {
                if((claim.getClaimStatus()!=null)&&(claim.getClaimStatus()!=dbClaim.getClaimStatus()) ){
                    dbClaim.setClaimStatus(claim.getClaimStatus());
                }
                if((claim.getDescription()!=null)&&(claim.getDescription()!=dbClaim.getDescription())){
                    dbClaim.setDescription(claim.getDescription());
                }
                if((claim.getClaimDate()!=null)&&(claim.getClaimDate()!=dbClaim.getClaimDate())){
                    dbClaim.setClaimDate(claim.getClaimDate());
                }
                if((claim.getInsurancePolicy()!=null)&&(claim.getInsurancePolicy()!=dbClaim.getInsurancePolicy())){
                    dbClaim.setInsurancePolicy(claim.getInsurancePolicy());
                }
            }
            claimRepository.save(dbClaim);
            return dbClaim;
        }
        return null;
    }
    // delete a claim
    public void deleteClaim(int id){
        claimRepository.deleteById(id);
    }
    // display all
    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }
    // display by id
    public Claim getClaim(int id){
        if (claimRepository.findById(id).isPresent()) {
            return claimRepository.findById(id).get();
        }
        return null;
    }

}
