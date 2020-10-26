package com.apicrud.client.service;

import java.util.List;

import com.apicrud.client.model.Client;

// Creation de l'interface client avec toutes les fonctionnalites CRUD

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long clientId);

    Client saveClient(Client client);

    void deleteClientById(Long clientId);
}
