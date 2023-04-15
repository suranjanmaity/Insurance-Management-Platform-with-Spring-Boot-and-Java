package com.api.insurance_management_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.insurance_management_platform.dto.Client;
import com.api.insurance_management_platform.service.ClientService;
@RestController
public class ClientController {
    @Autowired
    ClientService service;
    @PostMapping("/api/clients")
    public Client insertClient(@RequestBody Client client) {
        return service.insertClient(client);
    }
    @PutMapping("/api/clients/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client client) {
        return service.updateClient(id, client);
    }
    @DeleteMapping("/api/clients/{id}")
    public void deleteClient(@PathVariable int id){
        service.deleteClient(id);
    }
    @RequestMapping(value = "/api/clients", method = RequestMethod.GET)
    public List<Client> getAllClients(){
        return service.getAllClients();
    }
    @GetMapping("/api/clients/{id}")
    public Client getClient(@PathVariable int id){
        return service.getClient(id);
    }
}
