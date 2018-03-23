package com.tdigroup.istaabsense.model;

/**
 * Created by Youssef on 3/22/2018.
 */

public class Formateur {
    //Fields
    private String matricule;
    private String nomComplet;
    private String genie;
    private String typeFormateur;

    //Constructors
    public Formateur() {
    }

    public Formateur(String matricule, String nomComplet, String genie, String typeFormateur) {
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.genie = genie;
        this.typeFormateur = typeFormateur;
    }

    //Getters & Setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGenie() {
        return genie;
    }

    public void setGenie(String genie) {
        this.genie = genie;
    }

    public String getTypeFormateur() {
        return typeFormateur;
    }

    public void setTypeFormateur(String typeFormateur) {
        this.typeFormateur = typeFormateur;
    }
}
