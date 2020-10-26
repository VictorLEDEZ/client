package com.apicrud.client.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// Une entreprise est une class qui herite de la class abstraite client
// le type de cette class et EN pour pouvoir differencier entreprises et humains
@Entity
@DiscriminatorValue("EN")
public class Entreprise extends Client {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Une entreprise possede les attributs de client plus un nom d'entreprise, un
    // SIRET et un type d'entreprise (PME, Multinationnale, etc...)

    // Une entreprise ne possede pas d'ID puisqu'elle se trouve dans le meme tableau
    // que client!
    // Un client = une entreprise

    @Column(name = "nomEntreprise")
    private String nomEntreprise;

    @Column(name = "siret")
    private Long siret;

    @Column(name = "typeEntreprise")
    private String typeEntreprise;

    // Getters and Setters

    public String getNomEntreprise() {
        return this.nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public Long getSiret() {
        return this.siret;
    }

    public void setSiret(Long siret) {
        this.siret = siret;
    }

    public String getTypeEntreprise() {
        return this.typeEntreprise;
    }

    public void setTypeEntreprise(String typeEntreprise) {
        this.typeEntreprise = typeEntreprise;
    }

    // end of Getters and Setters

    // Constructors

    public Entreprise() {
        super();
    }

    public Entreprise(Long clientId, String adresse, String telephone, Date dateCreation, String nomEntreprise,
            Long siret, String typeEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.typeEntreprise = typeEntreprise;
    }

    // end of Constructors
}
