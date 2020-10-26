package com.apicrud.client.repository;

import com.apicrud.client.model.Client;

import org.springframework.data.repository.CrudRepository;

// Creation d'un repertoire CRUD

public interface ClientRepository extends CrudRepository<Client, Long> {

}
