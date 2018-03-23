package com.tdigroup.istaabsense.model;

/**
 * Created by Youssef on 3/23/2018.
 */

public class Groupe {
    //Fields
    private int idGroupe;
    private String codeGroupe;
    private String annee;
    private Filiere filiere;
    private String typeGroupe;
    private String statut;

    //Constructors
    public Groupe() {
    }

    public Groupe(int idGroupe, String codeGroupe, String annee, Filiere filiere,
                  String typeGroupe, String statut) {
        this.idGroupe = idGroupe;
        this.codeGroupe = codeGroupe;
        this.annee = annee;
        this.filiere = filiere;
        this.typeGroupe = typeGroupe;
        this.statut = statut;
    }

    //Getters & Setters
    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getCodeGroupe() {
        return codeGroupe;
    }

    public void setCodeGroupe(String codeGroupe) {
        this.codeGroupe = codeGroupe;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public String getTypeGroupe() {
        return typeGroupe;
    }

    public void setTypeGroupe(String typeGroupe) {
        this.typeGroupe = typeGroupe;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
