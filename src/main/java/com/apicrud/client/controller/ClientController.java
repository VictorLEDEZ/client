package com.apicrud.client.controller;

import java.util.List;

import com.apicrud.client.model.Client;
import com.apicrud.client.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Je cree une API REST -> RestController
@RestController
// methodes http (POST, GET, DELETE) dans le sous repertoir clients
@RequestMapping("/clients")
public class ClientController {

    // chaques methodes retourne un status qui nous servira de verification

    @Autowired
    private ClientService clientService;

    // methode GET dans "/" pour avoir la liste des clients
    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clientList = clientService.getAllClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    // methode GET dans /{clientId} en specifiant l'ID pour avoir le resultat
    // souhaite
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable("clientId") final Long clientId) {
        Client savedClient = clientService.getClientById(clientId);
        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }

    // methode POST pour enregistrer le client dans "/"
    @PostMapping()
    public ResponseEntity<Client> saveClient(@RequestBody final Client client) {
        Client savedClient = clientService.saveClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    // methode DELETE dans "/{clientId}" pour supprimer le client en fonction de
    // l'ID
    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable("clientId") final Long clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
