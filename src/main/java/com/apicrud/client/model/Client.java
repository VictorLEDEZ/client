package com.apicrud.client.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import org.hibernate.annotations.CreationTimestamp;

// Client est une entitee abstraite serealisable incluant les entreprises et les hunmains
// Les valeurs discriminatoires permettent de determiner les humains "HU" et les entreprises "EN" dans une colone type
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CLT", discriminatorType = DiscriminatorType.STRING, length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "EN", value = Entreprise.class), @Type(name = "HU", value = Humain.class) })
public abstract class Client implements Serializable {

    /**
     *
     */

    // un client possede un Identifiant, une adresse, un telephone et une date de
    // creation

    private static final long serialVersionUID = 1L;

    // attributs du compte
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @CreationTimestamp
    private Date dateCreation;
    // fin des attributs du compte

    // Getters and Setters

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    // end of Getters and Setters

    // Constructors
    public Client() {
        super();
    }

    public Client(Long clientId, String adresse, String telephone, Date dateCreation) {
        this.clientId = clientId;
        this.adresse = adresse;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
    }
    // fin des Constructors
}
