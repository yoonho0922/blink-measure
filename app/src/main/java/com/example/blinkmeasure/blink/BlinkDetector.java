package com.example.blinkmeasure.blink;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlinkDetector {

    private static double EAR_THRESH = 0.18;
    private static int EAR_CONSEC_FRAMES = 1;

    private int counter;
    private int blinkNumber;

    public BlinkDetector(){
        counter = 0;
        blinkNumber = 0;
    }

    public int detect(double EAR) {
        Log.i("get_EAR", "" + EAR);

        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH-mm-ss.SSS");
        String getTime = simpleDate.format(mDate);
        Log.i("detect_time", getTime);

        if(EAR < EAR_THRESH) {
            counter++;
            Log.i("eye_close", counter + ", " + EAR);
        } else {
            if(counter > EAR_CONSEC_FRAMES){
                blinkNumber++;
                Log.i("blink_number", "" + blinkNumber);
            }

            counter = 0;
        }

        return blinkNumber;
    }

}
