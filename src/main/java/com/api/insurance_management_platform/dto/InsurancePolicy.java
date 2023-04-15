package com.api.insurance_management_platform.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class InsurancePolicy {
    @Id
    private int policyNumber;
    private String policyType;
    private Double policyCoverageAmount;
    private Double policyPremium;
    private String policyStartDate;
    private String policyEndDate;
    @ManyToOne(cascade= {CascadeType.PERSIST,
        CascadeType.MERGE})
    private Client client;
    @OneToMany(mappedBy = "insurancePolicy")
    private List<Claim> claims;


    public List<Claim> getClaims() {
        return claims;
    }
    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
    public int getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }
    public String getPolicyType() {
        return policyType;
    }
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }
    public Double getPolicyCoverageAmount() {
        return policyCoverageAmount;
    }
    public void setPolicyCoverageAmount(Double policyCoverageAmount) {
        this.policyCoverageAmount = policyCoverageAmount;
    }
    public Double getPolicyPremium() {
        return policyPremium;
    }
    public void setPolicyPremium(Double policyPremium) {
        this.policyPremium = policyPremium;
    }
    public String getPolicyStartDate() {
        return policyStartDate;
    }
    public void setPolicyStartDate(String policyStartDate) {
        this.policyStartDate = policyStartDate;
    }
    public String getPolicyEndDate() {
        return policyEndDate;
    }
    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    
}
