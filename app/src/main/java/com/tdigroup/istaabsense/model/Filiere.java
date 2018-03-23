package com.tdigroup.istaabsense.model;

/**
 * Created by Youssef on 3/22/2018.
 */

public class Filiere {
    //Fields
    private int idFiliere;
    private String codeFiliere;
    private String filiere;
    private Secteur secteur;
    private Niveau niveau;
    private String mode;

    //Constructors

    public Filiere() {
    }

    public Filiere(int idFiliere, String codeFiliere, String filiere, Secteur secteur, Niveau niveau, String mode) {
        this.idFiliere = idFiliere;
        this.codeFiliere = codeFiliere;
        this.filiere = filiere;
        this.secteur = secteur;
        this.niveau = niveau;
        this.mode = mode;
    }

    //Getters & Setters

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
