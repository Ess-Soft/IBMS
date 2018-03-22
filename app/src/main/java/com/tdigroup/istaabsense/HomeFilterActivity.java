package com.tdigroup.istaabsense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.tdigroup.istaabsense.globarVariables.VariablesData;
import com.tdigroup.istaabsense.model.StagiaireModel;
import com.tdigroup.istaabsense.utils.AppUtils;
import com.tdigroup.istaabsense.utils.TimeUtils;

import java.util.ArrayList;

import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFilterActivity extends AppCompatActivity {


    @BindView(R.id.hours_seekBar)
    RangeBar hours_seekBar;

    @BindView(R.id.timeStartIndicatorTv)
    TextView timeStartIndicatorTv;

    @BindView(R.id.timeEndIndicatorTv)
    TextView timeEndIndicatorTv;

    @BindView(R.id.niveau_switch)
    ToggleSwitch niveau_switch;

    @BindView(R.id.level_year_switch)
    ToggleSwitch level_year_switch;

    @BindView(R.id.secteur_spinner)
    MaterialSpinner secteur_spinner;

    @BindView(R.id.filiere_spinner)
    MaterialSpinner filiere_spinner;

    @BindView(R.id.groupes_spinner)
    MaterialSpinner groupes_spinner;

    @BindView(R.id.profs_spinner)
    MaterialSpinner profs_spinner;

    @BindView(R.id.enterBtn)
    Button enterBtn;

    @BindView(R.id.school_timedTv)
    TextView school_timedTv;

    private AppUtils utils;

    /** event that will be executed when Enter button is clicked */
    @OnClick(R.id.enterBtn)
    public void setEnterBtn(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_filter);

        ButterKnife.bind(this);
        utils = new AppUtils(this);

        /** check for selected niveau: T.S or T */
        if (niveau_switch.getCheckedTogglePosition() == 0){
            VariablesData.TYPE_TECHNECIEN_SPECIALISE = true;
        } else if (niveau_switch.getCheckedTogglePosition() == 1){
            VariablesData.TYPE_TECHNECIEN_SPECIALISE = true;
        }

        /** check for year : 1er anne or 2eme anne */
        if (level_year_switch.getCheckedTogglePosition() == 0){
            VariablesData.TYPE_1erAnne =true;
        } else if (level_year_switch.getCheckedTogglePosition() == 1) {
            VariablesData.TYPE_2emeAnne = true;
        }

        /** empty time slider labels */
        timeStartIndicatorTv.setText("");
        timeEndIndicatorTv.setText("");

        /** check if its the Morning or Evening to show */
        if (TimeUtils.getWorkingTime() == TimeUtils.MORNING_TIME){
            hours_seekBar.setTickEnd(8.0f); // i added the "f" because the number is float
            hours_seekBar.setTickStart((float) 13.0); // another way to do same ;)
            timeStartIndicatorTv.setText("8");
            timeEndIndicatorTv.setText("13");
        } else if(TimeUtils.getWorkingTime() == TimeUtils.EVENING_TIME){
            timeStartIndicatorTv.setText("13");
            timeEndIndicatorTv.setText("19");
        } else {
            utils.hideView(enterBtn);
        }




         /**if time is not between 8-13 or 13-19*/
        if(TimeUtils.getWorkingTime() == TimeUtils.SCHOOL_OUT_TIME){
            school_timedTv.setText(R.string.school_timed_out_message);
        }









    }


}
