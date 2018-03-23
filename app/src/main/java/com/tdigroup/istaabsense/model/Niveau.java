package com.tdigroup.istaabsense.model;

/**
 * Created by Youssef on 3/22/2018.
 */

public class Niveau {
    //Fields
    private String niveau;
    private String intituleNiveau;

    //Constructors
    public Niveau() {
    }

    public Niveau(String niveau, String intituleNiveau) {
        this.niveau = niveau;
        this.intituleNiveau = intituleNiveau;
    }

    //Getters & Setters
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getIntituleNiveau() {
        return intituleNiveau;
    }

    public void setIntituleNiveau(String intituleNiveau) {
        this.intituleNiveau = intituleNiveau;
    }
}
