package com.tdigroup.istaabsense.model;

/**
 * Created by ayoub on 3/23/18.
 */

public class SecteurModel {

    public String getCodeSecteur() {
        return codeSecteur;
    }

    public void setCodeSecteur(String codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public SecteurModel(String codeSecteur, String secteur) {
        this.codeSecteur = codeSecteur;
        this.secteur = secteur;
    }

    public String codeSecteur, secteur;

    public SecteurModel(){

    }
}
