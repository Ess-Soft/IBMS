package com.tdigroup.istaabsense.model;

/**
 * Created by ayoub on 3/24/18.
 */

public class FiliereModel {

    public FiliereModel(int idFiliere, String codeFiliere, String filiere, String codeSecteur, String niveau, String mode) {
        this.idFiliere = idFiliere;
        CodeFiliere = codeFiliere;
        Filiere = filiere;
        CodeSecteur = codeSecteur;
        Niveau = niveau;
        Mode = mode;
    }

    public int idFiliere;
    public String CodeFiliere, Filiere, CodeSecteur, Niveau, Mode;

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getCodeFiliere() {
        return CodeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        CodeFiliere = codeFiliere;
    }

    public String getFiliere() {
        return Filiere;
    }

    public void setFiliere(String filiere) {
        Filiere = filiere;
    }

    public String getCodeSecteur() {
        return CodeSecteur;
    }

    public void setCodeSecteur(String codeSecteur) {
        CodeSecteur = codeSecteur;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }


}
