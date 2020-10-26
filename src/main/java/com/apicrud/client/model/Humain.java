package com.apicrud.client.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// Un humain est une class qui herite de la class abstraite client
// le type de cette class et HU pour pouvoir differencier entreprises et humains
@Entity
@DiscriminatorValue("HU")
public class Humain extends Client {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Un humain possede les attributs de client plus un nom, un
    // prenom, un age et un sexe (H/F)

    // Un humain ne possede pas d'ID puisqu'il se trouve dans le meme tableau
    // que client!
    // Un client = un humain

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "age")
    private Byte age;

    @Column(name = "sexe")
    private String sexe;

    // Getters and Setters

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Byte getAge() {
        return this.age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getSexe() {
        return this.sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    // end of Getters and Setters

    // Constructors

    public Humain() {
        super();
    }

    public Humain(Long clientId, String adresse, String telephone, Date dateCreation, String nom, String prenom,
            Byte age, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
    }

    // end of Constructors
}
