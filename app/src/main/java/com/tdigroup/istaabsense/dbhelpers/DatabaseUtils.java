package com.tdigroup.istaabsense.dbhelpers;

import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ayoub on 3/22/18.
 */

public class DatabaseUtils {


    /**
     * this function will copy data.db located in assets folder to app's local database folder /data/data/<packagename_here>/database/data.db
     * @param context
     * @return boolean if it's successfully copied or not
     *  NOTICE: every android app that uses Sqlite db has it's DB located in this folder inside phone: /data/data/<packagename_here>/database/
     */
    public static boolean copyDatabase(Context context) {
        try {
            String DBLocation = context.getDatabasePath(DatabaseVariables.DB_NAME).getPath();
            InputStream inputStream = context.getAssets().open("database/"+DatabaseVariables.DB_NAME);
            String outFileName = DBLocation + DatabaseVariables.DB_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("==> copyDatabase()","DB successfully copied");
            return true;
        }catch (Exception e) {
            Log.w("==> copyDatabase()","OPS!! Something unexpected happened :(");
            e.printStackTrace();
            return false;
        }
    }
}
