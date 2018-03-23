package com.tdigroup.istaabsense.model;

import java.util.Date;

/**
 * Created by Youssef on 3/22/2018.
 */

public class Absence {
    //Fields
    private int id;
    private Stagiaire stagiaire;
    private String seance;
    private Date dateSeance;
    private boolean justifie;
    private String type;

    //Constructors
    public Absence() {
    }

    public Absence(int id, Stagiaire stagiaire, String seance,
                   Date dateSeance, boolean justifie, String type) {
        this.id = id;
        this.stagiaire = stagiaire;
        this.seance = seance;
        this.dateSeance = dateSeance;
        this.justifie = justifie;
        this.type = type;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public String getSeance() {
        return seance;
    }

    public void setSeance(String seance) {
        this.seance = seance;
    }

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    public boolean isJustifie() {
        return justifie;
    }

    public void setJustifie(boolean justifie) {
        this.justifie = justifie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
