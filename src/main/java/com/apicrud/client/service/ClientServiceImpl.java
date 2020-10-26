package com.apicrud.client.service;

import java.util.List;

import com.apicrud.client.model.Client;
import com.apicrud.client.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Implementation de ClientService

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    // necessite un identifiant pour recuperer un client
    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).get();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // necessite un identifiant pour supprimer un client
    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
