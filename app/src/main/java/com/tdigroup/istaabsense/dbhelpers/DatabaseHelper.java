package com.tdigroup.istaabsense.dbhelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tdigroup.istaabsense.model.FiliereModel;
import com.tdigroup.istaabsense.model.GroupeModel;
import com.tdigroup.istaabsense.model.SecteurModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ayoub on 23/03/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mContext;
    private SQLiteDatabase mDatabase;



    public DatabaseHelper(Context context) {
        super(context, DatabaseVariables.DB_NAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DatabaseVariables.DB_NAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<SecteurModel> getAllSecteur() {
        SecteurModel secteur = null;
        List<SecteurModel> secteurList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + DatabaseVariables.TBL_SECTEURS, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            secteur = new SecteurModel(cursor.getString(0), cursor.getString(1));
            secteurList.add(secteur);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return secteurList;
    }

    public String getSecteurCodeBySecteur(String secteurName) {
        String secteurCode = null;
        openDatabase();
        String commandQuery = "SELECT CodeSecteur FROM " + DatabaseVariables.TBL_SECTEURS + " WHERE Secteur =?";
        Cursor cursor = mDatabase.rawQuery(commandQuery, new String[] {secteurName});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            secteurCode = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return secteurCode;
    }

    public List<FiliereModel> getFiliereBySecteurCode(String CodeSecteur) {
        FiliereModel filiere = null;
        List<FiliereModel> filiereList = new ArrayList<>();
        openDatabase();
        String commandQuery = "SELECT * FROM " + DatabaseVariables.TBL_FILIERES + " WHERE CodeSecteur =?";
        Cursor cursor = mDatabase.rawQuery(commandQuery, new String[] {CodeSecteur});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // int idFiliere, String codeFiliere, String filiere, String codeSecteur, String niveau, String mode
            filiere = new FiliereModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4),  cursor.getString(5));
            filiereList.add(filiere);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return filiereList;
    }


    public List<FiliereModel> getAllFilieres() {
        FiliereModel filiere = null;
        List<FiliereModel> filiereList = new ArrayList<>();
        openDatabase();
        String commandQuery = "SELECT * FROM " + DatabaseVariables.TBL_FILIERES;
        Cursor cursor = mDatabase.rawQuery(commandQuery,null);
        if (cursor != null) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                // int idFiliere, String codeFiliere, String filiere, String codeSecteur, String niveau, String mode
                filiere = new FiliereModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5));
                filiereList.add(filiere);
                cursor.moveToNext();
            }

            cursor.close();
        }
        closeDatabase();
        return filiereList;
    }

    public int getIdFiliereByFiliereName(String filiereName) {
        int idFiliere = -1;
        openDatabase();
        String commandQuery = "SELECT IdFiliere FROM " + DatabaseVariables.TBL_FILIERES + " WHERE Filiere =?";
        Cursor cursor = mDatabase.rawQuery(commandQuery, new String[] {filiereName});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            idFiliere = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return idFiliere;
    }

    public List<GroupeModel> getGroupeByIdFiliere(int idFiliere) {
        GroupeModel groupe = null;
        List<GroupeModel> filiereList = new ArrayList<>();
        openDatabase();
        String commandQuery = "SELECT * FROM " + DatabaseVariables.TBL_GROUPES + " WHERE idFiliere =?";
        Cursor cursor = mDatabase.rawQuery(commandQuery, new String[] {String.valueOf(idFiliere)});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // int idGroupe, int idFiliere, String codeGroupe, String annee, String typeGroupe, String statut
            groupe = new GroupeModel(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4),  cursor.getString(5));
            filiereList.add(groupe);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return filiereList;
    }


}
