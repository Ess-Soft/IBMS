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
    public static final String COL_TABLEAUSERVICE_ID = "Id";
    public static final String COL_TABLEAUSERVICE_IDGROUPE = "IdGroupe";
    public static final String COL_TABLEAUSERVICE_MATRICULE = "Matricule";
    public static final String COL_TABLEAUSERVICE_MASSHORAIREAFFECTER = "MassHoraireAffecter";
    public static final String COL_TABLEAUSERVICE_THEORIE = "Theorie";
    public static final String COL_TABLEAUSERVICE_PRATIQUE = "Pratique";
    public static final String COL_TABLEAUSERVICE_IDMODULE = "IdModule";

    //Columns of  table Absence
    public static final String COL_ABSENCE_ID= "Id";
    public static final String COL_ABSENCE_MATRICULEETUDIANT = "MatriculeEtudiant";
    public static final String COL_ABSENCE_SEANCE = "Seance";
    public static final String COL_ABSENCE_DATESEANCE = "DateSeance";
    public static final String COL_ABSENCE_JUSTIFIE = "Justifie";
    public static final String COL_ABSENCE_TYPE = "Type";

    //Columns of  Table Filiere
    public static final String COL_FILIERE_IDFILIERE = "IdFiliere";
    public static final String COL_FILIERE_CODEFILIERE = "CodeFiliere";
    public static final String COL_FILIERE_FILIERE = "Filiere";
    public static final String COL_FILIERE_CODESECTEUR = "CodeSecteur";
    public static final String COL_FILIERE_NIVEAU = "Niveau";
    public static final String COL_FILIERE_MODE = "Mode";

    //Columns of Table Formateur
    public static final String COL_FORMATEUR_MATRICULE = "Matricule";
    public static final String COL_FORMATEUR_NOMCOMPLET = "NomComplet";
    public static final String COL_FORMATEUR_GENIE = "Genie";
    public static final String COL_FORMATEUR_TYPEFORMATEUR = "TypeFormateur";

    //Columns of Table Groupes
    public static final String COL_GROUPES_IDGROUPE = "IdGroupe";
    public static final String COL_GROUPES_CODEGROUPE = "CodeGroupe";
    public static final String COL_GROUPES_ANNEE = "Annee";
    public static final String COL_GROUPES_IDFILIERE = "IdFiliere";
    public static final String COL_GROUPES_TYPEGORUPE = "TypeGroupe";
    public static final String COL_GROUPES_STATUT = "Statut";

    //Columns of Table Inscription
    public static final String COL_INSCRIPTION_MATRICULESTAGIARE = "MatriculeStagiaire";
    public static final String COL_INSCRIPTION_IDGROUPE = "IdGroupe";
    public static final String COL_INSCRIPTION_DATEINSCRIPTION = "DateInscription";

    //Columns of Table Justif
    public static final String COL_JUSTIF_ID = "Id";
    public static final String COL_JUSTIF_DATEDEPART = "DateDepart";
    public static final String COL_JUSTIF_DATEDEPUT = "DateDebut";
    public static final String COL_JUSTIF_DATEFIN = "DateFin";
    public static final String COL_JUSTIF_NATURE = "Nature";
    public static final String COL_JUSTIF_OBSERVATION = "Observation";

    //Columns of Table Niveaux
    public static final String COL_NIVEAU_NIVEAU = "Niveau";
    public static final String COL_NIVEAU_INTITULENIVEAU = "IntituleNiveau";

    //Columns of Table Secteurs
    public static final String COL_SECTEURES_CODESECTEUR = "CodeSecteur";
    public static final String COL_SECTEURES_SECTEUR = "Secteur";

    //Columns of Table Stagiaires
    public static final String COL_STAGIAIRES_MATRICULESTAGIARE = "MatriculeStagiaire";
    public static final String COL_STAGIAIRES_NOM = "Nom";
    public static final String COL_STAGIAIRES_PRENOM = "Prenom";
    public static final String COL_STAGIAIRES_SEXE = "Sexe";
    public static final String COL_STAGIAIRES_CIN = "CIN";
    public static final String COL_STAGIAIRES_ADRESSE = "Adresse";
    public static final String COL_STAGIAIRES_TEL = "Tel";
    public static final String COL_STAGIAIRES_DATENAISS = "DateNaiss";





}
