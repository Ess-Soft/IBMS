package com.tdigroup.istaabsense.model;

import java.util.Date;

/**
 * Created by Youssef on 3/22/2018.
 */

public class Insciption {
    //Fields
    private int matriculeStagiaire;
    private int idGroupe;
    private Date dateInscription;

    //Constructors
    public Insciption() {
    }

    public Insciption(int matriculeStagiaire, int idGroupe, Date dateInscription) {
        this.matriculeStagiaire = matriculeStagiaire;
        this.idGroupe = idGroupe;
        this.dateInscription = dateInscription;
    }

    //Getters & Setters
    public int getMatriculeStagiaire() {
        return matriculeStagiaire;
    }

    public void setMatriculeStagiaire(int matriculeStagiaire) {
        this.matriculeStagiaire = matriculeStagiaire;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
