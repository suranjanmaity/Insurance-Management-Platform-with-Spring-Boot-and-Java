package com.api.insurance_management_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.insurance_management_platform.dao.ClientDao;
import com.api.insurance_management_platform.dto.Client;

@Service
public class ClientService {
    @Autowired
    ClientDao dao;
    public Client insertClient(Client client) {
        return dao.insertClient(client);
    }
    public Client updateClient(int id, Client client) {
        return dao.updateClient(id, client);
    }
    public void deleteClient(int id){
        dao.deleteClient(id);
    }
    public List<Client> getAllClients(){
        return dao.getAllClients();
    }
    public Client getClient(int id){
        return dao.getClient(id);
    }
}
