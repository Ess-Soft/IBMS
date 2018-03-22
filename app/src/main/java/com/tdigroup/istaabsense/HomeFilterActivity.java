package com.tdigroup.istaabsense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tdigroup.istaabsense.globarVariables.VariablesData;
import com.tdigroup.istaabsense.model.StagiaireModel;

import java.util.ArrayList;

import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import butterknife.BindView;

public class HomeFilterActivity extends AppCompatActivity {

    @BindView(R.id.niveau_switch)
    ToggleSwitch niveauSwitch;

    @BindView(R.id.level_year_switch)
    ToggleSwitch levelYearSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_filter);

        /** check for selected niveau: T.S or T */
        if (niveauSwitch.getCheckedTogglePosition() == 0){
            VariablesData.TYPE_TECHNECIEN_SPECIALISE = true;
        } else if (niveauSwitch.getCheckedTogglePosition() == 1){
            VariablesData.TYPE_TECHNECIEN_SPECIALISE = true;
        }

        /** check for year : 1er anne or 2eme anne */
        if (levelYearSwitch.getCheckedTogglePosition() == 0){
            VariablesData.TYPE_1erAnne =true;
        } else if (levelYearSwitch.getCheckedTogglePosition() == 1){
            VariablesData.TYPE_2emeAnne = true;
        }




    }


}
