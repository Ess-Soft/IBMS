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

    /** declare rows of each table.  NAMING FORMAT: RW_COLUMN_NAME_TABLENAME */
    // table TableauService
    public static final String RW_Id_TableauxService = "Id";
    public static final String RW_IdGroupe_TableauxService = "IdGroupe";
    public static final String RW_Matricule_TableauxService = "Matricule";
    public static final String RW_MassHoraireAffecter_TableauxService = "MassHoraireAffecter";
    public static final String RW_Theorie_TableauxService = "Theorie";
    public static final String RW_Pratique_TableauxService = "Pratique";
    public static final String RW_IdModule_TableauxService = "IdModule";

    // table Absense
    public static final String RW_Id_Absense = "Id";
    public static final String RW_MatriculeEtudiant_Absense = "MatriculeEtudiant";
    public static final String RW_Seance_Absense = "Seance";
    public static final String RW_DateSeance_Absense = "DateSeance";
    public static final String RW_Justifie_Absense = "Justifie";
    public static final String RW_Type_Absense = "Type";











}
