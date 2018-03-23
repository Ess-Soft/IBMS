package com.tdigroup.istaabsense.model;

import java.util.Date;

/**
 * Created by Youssef on 3/23/2018.
 */

public class Justif {
    //Fields
    private int id;
    private Date dateDepart;
    private Date dateDebut;
    private Date dateFin;
    private String nature;
    private String observasion;

    //Constructors
    public Justif() {
    }

    public Justif(int id, Date dateDepart, Date dateDebut, Date dateFin, String nature, String observasion) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nature = nature;
        this.observasion = observasion;
    }

    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getObservasion() {
        return observasion;
    }

    public void setObservasion(String observasion) {
        this.observasion = observasion;
    }
}
