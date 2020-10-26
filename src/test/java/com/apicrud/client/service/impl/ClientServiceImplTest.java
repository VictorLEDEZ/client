package com.apicrud.client.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.apicrud.client.model.Client;
import com.apicrud.client.model.Entreprise;
import com.apicrud.client.model.Humain;
import com.apicrud.client.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ClientServiceImplTest {

    @Autowired
    private ClientRepository clientRepository;

    // Ici on test la methode deleteClientById pour Humain et Entreprise
    @Test
    @Rollback(false)
    public void testDeleteHumainById() {
        Humain humain = new Humain();
        clientRepository.save(humain);
        Long id = 1L;
        boolean isExistingBeforeDelete = clientRepository.findById(id).isPresent();
        clientRepository.deleteById(id);
        boolean notExistingAfterDelete = clientRepository.findById(id).isPresent();

        assertTrue(isExistingBeforeDelete);
        assertFalse(notExistingAfterDelete);
    }

    @Test
    @Rollback(false)
    public void testDeleteEntrepriseById() {
        Entreprise entreprise = new Entreprise();
        clientRepository.save(entreprise);
        Long id = 1L;
        boolean isExistingBeforeDelete = clientRepository.findById(id).isPresent();
        clientRepository.deleteById(id);
        boolean notExistingAfterDelete = clientRepository.findById(id).isPresent();

        assertTrue(isExistingBeforeDelete);
        assertFalse(notExistingAfterDelete);
    }

    // Ici on test la methode saveClient pour Humain et Entreprise
    @Test
    @Rollback(false)
    final void testSaveHumain() {
        Humain humain = new Humain(null, "adresse", "12345678", null, null, null, null, null);
        Humain savedHumain = clientRepository.save(humain);

        assertNotNull(savedHumain);
    }

    @Test
    @Rollback(false)
    final void testSaveEntreprise() {
        Entreprise entreprise = new Entreprise(null, "adresse", "telephone", null, "nomEntreprise", 123223452352L,
                "typeEntreprise");
        Entreprise savedEntreprise = clientRepository.save(entreprise);

        assertNotNull(savedEntreprise);
    }

    // Ici on test la methode findById pour Humain et Entreprise
    @Test
    public void testGetHumainById() {
        Humain humain = new Humain();
        Humain savedHumain = clientRepository.save(humain);

        assertEquals(1L, savedHumain.getClientId());
    }

    @Test
    public void testGetEntrepriseById() {
        Entreprise entreprise = new Entreprise();
        Entreprise savedEntreprise = clientRepository.save(entreprise);

        assertEquals(1L, savedEntreprise.getClientId());
    }

    // Ici on test la methode getAllClients pour Humain et Entreprise
    @Test
    public void testGetAllClients() {
        Humain humain1 = new Humain();
        Humain humain2 = new Humain();
        Humain humain3 = new Humain();
        Entreprise entreprise1 = new Entreprise();
        Entreprise entreprise2 = new Entreprise();
        Entreprise entreprise3 = new Entreprise();
        List<Client> humains = (List<Client>) clientRepository.findAll();
        List<Client> entreprises = (List<Client>) clientRepository.findAll();
        assertNotEquals(0, humains.size());
        assertNotEquals(0, entreprises.size());
    }
}
