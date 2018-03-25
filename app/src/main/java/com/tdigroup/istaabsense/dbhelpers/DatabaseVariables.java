package com.tdigroup.istaabsense.dbhelpers;

/**
 * Created by ayoub on 3/22/18.
 */

public class DatabaseVariables {
    public static final String DB_NAME = "data.db"; // the name of DB located in assets/database folder

    /** declare tables and tables rows names.  NAMING FORMAT: TBL_TABLE_NAME */
    public static final String TBL_ABSENCE = "Absence";
    public static final String TBL_FILIERES = "Filieres";
    public static final String TBL_FORMATEURS = "Formateurs";
    public static final String TBL_GROUPES = "Groupes";
    public static final String TBL_INSCRIPTION = "Inscription";
    public static final String TBL_JUSTIF = "Justif";
    public static final String TBL_NIVEAUX = "Niveaux";
    public static final String TBL_SECTEURS = "Secteurs";
    public static final String TBL_STAGIAIRES = "Stagiaires";
    public static final String TBL_TABLEAUSERVICE = "TableauxService";

    /** declare Columns of each table.  NAMING FORMAT: COL_TABLENAME_COLUMNNAME */
    //Columns of  table TableauService
    public static final String COL_TableauxService_Id = "Id";
    public static final String COL_TableauxService_IdGroupe = "IdGroupe";
    public static final String COL_TableauxService_Matricule = "Matricule";
    public static final String COL_TableauxService_MassHoraireAffecter = "MassHoraireAffecter";
    public static final String COL_TableauxService_Theorie = "Theorie";
    public static final String COL_TableauxService_Pratique = "Pratique";
    public static final String COL_TableauxService_IdModule = "IdModule";

    //Columns of  table Absense
    public static final String COL_Absense_Id = "Id";
    public static final String COL_Absense_MatriculeEtudiant = "MatriculeEtudiant";
    public static final String COL_Absense_Seance = "Seance";
    public static final String COL_Absense_DateSeance = "DateSeance";
    public static final String COL_Absense_Justifie = "Justifie";
    public static final String COL_Absense_Type = "Type";

    //Columns of  Table Filiere
    public static final String COL_Filieres_IdFiliere = "IdFiliere";
    public static final String COL_Filieres_CodeFiliere = "CodeFiliere";
    public static final String COL_Filieres_Filiere = "Filiere";
    public static final String COL_Filieres_CodeSecteur = "CodeSecteur";
    public static final String COL_Filieres_Niveau = "Niveau";
    public static final String COL_Filieres_Mode = "Mode";

    //Columns of Table Formateur
    public static final String COL_Formateurs_Matricule = "Matricule";
    public static final String COL_Formateurs_NomComplet = "NomComplet";
    public static final String COL_Formateurs_Genie = "Genie";
    public static final String COL_Formateurs_TypeFormateur = "TypeFormateur";

    //Columns of Table Groupes
    public static final String COL_Groupes_IdGroupe = "IdGroupe";
    public static final String COL_Groupes_CodeGroupe = "CodeGroupe";
    public static final String COL_Groupes_Annee = "Annee";
    public static final String COL_Groupes_IdFiliere = "IdFiliere";
    public static final String COL_Groupes_TypeGroupe = "TypeGroupe";
    public static final String COL_Groupes_Statut = "Statut";

    //Columns of Table Inscription
    public static final String COL_Inscription_MatriculeStagiaire = "MatriculeStagiaire";
    public static final String COL_Inscription_IdGroupe = "IdGroupe";
    public static final String COL_Inscription_DateInscription = "DateInscription";

    //Columns of Table Justif
    public static final String COL_Justif_Id = "Id";
    public static final String COL_Justif_DateDepart = "DateDepart";
    public static final String COL_Justif_DateDebut = "DateDebut";
    public static final String COL_Justif_DateFin = "DateFin";
    public static final String COL_Justif_Nature = "Nature";
    public static final String COL_Justif_Observation = "Observation";

    //Columns of Table Niveaux
    public static final String COL_Niveaux_Niveau = "Niveau";
    public static final String COL_Niveaux_IntituleNiveau = "IntituleNiveau";

    //Columns of Table Secteurs
    public static final String COL_Secteurs_CodeSecteur = "CodeSecteur";
    public static final String COL_Secteurs_Secteur = "Secteur";

    //Columns of Table Stagiaires
    public static final String COL_Stagiaires_MatriculeStagiaire = "MatriculeStagiaire";
    public static final String COL_Stagiaires_Nom = "Nom";
    public static final String COL_Stagiaires_Prenom = "Prenom";
    public static final String COL_Stagiaires_Sexe = "Sexe";
    public static final String COL_Stagiaires_CIN = "CIN";
    public static final String COL_Stagiaires_Adresse = "Adresse";
    public static final String COL_Stagiaires_Tel = "Tel";
    public static final String COL_Stagiaires_DateNaiss = "DateNaiss";





}
