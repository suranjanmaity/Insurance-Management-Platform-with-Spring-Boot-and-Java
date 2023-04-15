package com.api.insurance_management_platform.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.api.insurance_management_platform.dto.Client;
import com.api.insurance_management_platform.repository.ClientRepository;

@Repository
public class ClientDao {
    @Autowired
    ClientRepository clientRepository;

    // insert client
    public Client insertClient(Client client) {
        clientRepository.save(client);
        return client;
    }
    // update client
    public Client updateClient(int id, Client client) {
        if (clientRepository.findById(id).isPresent()) {
            Client dbClient = clientRepository.findById(id).get();
            if (dbClient.getClientId()==client.getClientId()) {
                if((client.getClientName()!=dbClient.getClientName())&&(client.getClientName()!=null)) {
                    dbClient.setClientName(client.getClientName());
                }
                if((client.getClientDOB()!=dbClient.getClientDOB())&&(client.getClientDOB()!=null)){
                    dbClient.setClientDOB(client.getClientDOB());
                }
                if((client.getClientAddress()!=dbClient.getClientAddress())&&(client.getClientAddress()!=null)){
                    dbClient.setClientAddress(client.getClientAddress());
                }
                if((client.getClientContact()!=dbClient.getClientContact())&&(client.getClientContact()!=0)){
                    dbClient.setClientContact(client.getClientContact());
                }
            }
            clientRepository.save(dbClient);
            return dbClient;
        }
        return null;
    }
    // delete a client
    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }
    // display all
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    // display by id
    public Client getClient(int id){
        if (clientRepository.findById(id).isPresent()) {
            return clientRepository.findById(id).get();
        }
        return null;
    }
}
