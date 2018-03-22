package com.tdigroup.istaabsense.utils;

import java.util.Calendar;

/**
 * Created by ayoub on 3/22/18.
 */

public class TimeUtils {
    public static final int MORNING_TIME = 0;
    public static final int EVENING_TIME = 1;
    public static final int SCHOOL_OUT_TIME = -1;

    /**
     * This Function will check the time of the day
     * @return int
     */
    public int getWorkingTime(){
        /** get Hours of the day */
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 8 && timeOfDay < 13){
            /** Return 0 if it's morning between 8 and 13 */
            return MORNING_TIME;
        }else if(timeOfDay >= 13 && timeOfDay < 18){
           return EVENING_TIME;
        }
        return SCHOOL_OUT_TIME;
    }
}
