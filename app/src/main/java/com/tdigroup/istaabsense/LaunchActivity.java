package com.tdigroup.istaabsense;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tdigroup.istaabsense.dbhelpers.DatabaseUtils;
import com.tdigroup.istaabsense.dbhelpers.DatabaseVariables;
import com.tdigroup.istaabsense.utils.AppUtils;

import java.io.File;

/**
 * This Activity will be the first launched activity so it will assure that the database has been initialized and copied to the right folder
 * so the app can work without getting any problem
 * so will check if database exist in local database folder if yes just close this and run next Activity: HomeFilterActivity
 * if not.. show an error in a Toast message an close app :(
 * so let get started :)
 */
public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        getSupportActionBar().hide(); // hide Toolbar that contains app name in top of screen

        File dbFile = this.getDatabasePath(DatabaseVariables.DB_NAME);
        if (dbFile.exists()) {
            /** DB Already exists nothing to do here... */
            // DB Already exists.. waiting just a 5 seconds then continue to next activity...
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // when 5 seconds has been finished then firing up the next activity
                    startActivity(new Intent(LaunchActivity.this, HomeFilterActivity.class)); // target activity is HomeFilterActivity
                }
            }, 1000); /** wait 5000 millisecond = 5 seconds */
        } else {
            /** db is not set yet trying to copy it to its right local path */
            if (DatabaseUtils.copyDatabase(this)) {
                // database has been successfully copied waiting just a 5 seconds then continue to next activity...
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // when 5 seconds has been finished then firing up the next activity
                        startActivity(new Intent(LaunchActivity.this, HomeFilterActivity.class)); // target activity is HomeFilterActivity
                    }
                }, 1000);
            } else {
                /** something bad happened and DB hasn't been copied :( trying to stop app */
                finish(); // finish() will just kill this activity
            }
        }
    }
}
