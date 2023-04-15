package com.api.insurance_management_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.insurance_management_platform.dao.ClientDao;
import com.api.insurance_management_platform.dao.InsurancePolicyDao;
import com.api.insurance_management_platform.dto.Client;
import com.api.insurance_management_platform.dto.InsurancePolicy;

@Service
public class InsurancePolicyService {
    @Autowired
    InsurancePolicyDao dao;
    @Autowired
    ClientDao clientDao;
    public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
        
        if (insurancePolicy.getClient()!=null) {
            int insuranceClientId = insurancePolicy.getClient().getClientId();
            if(insuranceClientId!=0){
                Client insuranceClient = insurancePolicy.getClient();
                clientDao.updateClient(insuranceClientId, insuranceClient);
                insurancePolicy.setClient(clientDao.getClient(insuranceClientId));
            }
        }
        return dao.insertInsurancePolicy(insurancePolicy);
    }
    public InsurancePolicy updateInsurancePolicy(int id, InsurancePolicy insurancePolicy) {
        if (insurancePolicy.getClient()!=null) {
            Client insuranceClient = insurancePolicy.getClient();
            int insuranceClientId = insuranceClient.getClientId();
            if(insuranceClientId!=0){
                clientDao.updateClient(insuranceClientId, insuranceClient);
                insurancePolicy.setClient(clientDao.getClient(insuranceClientId));
            }
        }
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
