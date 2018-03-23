package com.tdigroup.istaabsense.model;

/**
 * Created by Youssef on 3/22/2018.
 */

public class Secteur {
    //Fields
    private int codeSecteur;
    private String secteur;

    //Constructors

    public Secteur() {
    }

    public Secteur(int codeSecteur, String secteur) {
        this.codeSecteur = codeSecteur;
        this.secteur = secteur;
    }

    //Getters & Setters

    public int getCodeSecteur() {
        return codeSecteur;
    }

    public void setCodeSecteur(int codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
}
