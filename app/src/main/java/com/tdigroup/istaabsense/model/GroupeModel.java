package com.tdigroup.istaabsense.model;

/**
 * Created by ayoub on 3/24/18.
 */

public class GroupeModel {

    public String CodeGroupe, Annee, TypeGroupe, Statut;
    public int idGroupe, idFiliere;

    public GroupeModel(int idGroupe, int idFiliere, String codeGroupe, String annee, String typeGroupe, String statut) {
        this.idGroupe = idGroupe;
        this.idFiliere = idFiliere;
        CodeGroupe = codeGroupe;
        Annee = annee;
        TypeGroupe = typeGroupe;
        Statut = statut;
    }



    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getCodeGroupe() {
        return CodeGroupe;
    }

    public void setCodeGroupe(String codeGroupe) {
        CodeGroupe = codeGroupe;
    }

    public String getAnnee() {
        return Annee;
    }

    public void setAnnee(String annee) {
        Annee = annee;
    }

    public String getTypeGroupe() {
        return TypeGroupe;
    }

    public void setTypeGroupe(String typeGroupe) {
        TypeGroupe = typeGroupe;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String statut) {
        Statut = statut;
    }


}
