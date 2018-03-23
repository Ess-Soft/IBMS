package com.tdigroup.istaabsense.model;

import java.util.Date;

/**
 * Created by ayoub on 3/22/18.
 */

public class Stagiaire {

    public int getMatriculeStagiaire() {
        return matriculeStagiaire;
    }

    public void setMatriculeStagiaire(int matriculeStagiaire) {
        this.matriculeStagiaire = matriculeStagiaire;
    }

    public String getNomStagiaire() {
        return nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }

    public String getPrenomStagiaire() {
        return prenomStagiaire;
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = prenomStagiaire;
    }

    public String getCinStagiaire() {
        return cinStagiaire;
    }

    public void setCinStagiaire(String cinStagiaire) {
        this.cinStagiaire = cinStagiaire;
    }

    public String getAddresseStagiaire() {
        return addresseStagiaire;
    }

    public void setAddresseStagiaire(String addresseStagiaire) {
        this.addresseStagiaire = addresseStagiaire;
    }

    public String getTelStagiaire() {
        return telStagiaire;
    }

    public void setTelStagiaire(String telStagiaire) {
        this.telStagiaire = telStagiaire;
    }

    public char getSexeStagiaire() {
        return sexeStagiaire;
    }

    public void setSexeStagiaire(char sexeStagiaire) {
        this.sexeStagiaire = sexeStagiaire;
    }

    public Date getDateNaissanceStagiaire() {
        return dateNaissanceStagiaire;
    }

    public void setDateNaissanceStagiaire(Date dateNaissanceStagiaire) {
        this.dateNaissanceStagiaire = dateNaissanceStagiaire;
    }


    public Stagiaire(int matriculeStagiaire, String nomStagiaire, String prenomStagiaire, String cinStagiaire, String addresseStagiaire, String telStagiaire, char sexeStagiaire, Date dateNaissanceStagiaire) {
        this.matriculeStagiaire = matriculeStagiaire;
        this.nomStagiaire = nomStagiaire;
        this.prenomStagiaire = prenomStagiaire;
        this.cinStagiaire = cinStagiaire;
        this.addresseStagiaire = addresseStagiaire;
        this.telStagiaire = telStagiaire;
        this.sexeStagiaire = sexeStagiaire;
        this.dateNaissanceStagiaire = dateNaissanceStagiaire;
    }

    public Stagiaire(){

    }

    private int matriculeStagiaire;
    private String nomStagiaire, prenomStagiaire, cinStagiaire, addresseStagiaire, telStagiaire;
    private char sexeStagiaire;
    private Date dateNaissanceStagiaire;
}
