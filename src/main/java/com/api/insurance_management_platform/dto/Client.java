package com.api.insurance_management_platform.dto;

import java.text.DateFormat;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Client {
    @Id
    private int clientId;
    private String clientName;
    private DateFormat clientDOB;
    private String clientAddress;
    private long clientContact;
    @ManyToMany
    private List<InsurancePolicy> insurancePolicies;
    public List<InsurancePolicy> getInsurancePolicies() {
        return insurancePolicies;
    }
    public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) {
        this.insurancePolicies = insurancePolicies;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public DateFormat getClientDOB() {
        return clientDOB;
    }
    public void setClientDOB(DateFormat clientDOB) {
        this.clientDOB = clientDOB;
    }
    public String getClientAddress() {
        return clientAddress;
    }
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
    public long getClientContact() {
        return clientContact;
    }
    public void setClientContact(long clientContact) {
        this.clientContact = clientContact;
    }
    
}
