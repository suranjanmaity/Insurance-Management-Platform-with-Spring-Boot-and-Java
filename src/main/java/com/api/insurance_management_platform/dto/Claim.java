package com.api.insurance_management_platform.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {
    @Id
    private int claimNumber;
    private String description;
    private String claimDate;
    private String claimStatus;
    @ManyToOne(cascade= CascadeType.ALL)
    private InsurancePolicy insurancePolicy;


    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }
    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
    public int getClaimNumber() {
        return claimNumber;
    }
    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getClaimDate() {
        return claimDate;
    }
    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }
    public String getClaimStatus() {
        return claimStatus;
    }
    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
    
}
