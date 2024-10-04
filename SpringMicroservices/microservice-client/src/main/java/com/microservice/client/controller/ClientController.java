package com.microservice.client.controller;

import com.microservice.client.model.Client;
import com.microservice.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Client register(@RequestBody Client client){
        return clientService.register(client);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public Client getById(@PathVariable long id){
        return clientService.getById(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ArrayList<Client> getAll(){
        return clientService.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        clientService.delete(id);
    }
}
