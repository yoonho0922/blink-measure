package com.example.blinkmeasure.blink;

import android.util.Log;

public class BlinkDetection {

    private static int WINDOW_SIZE = 30;
    private static double EAR_THRESH = 0.2;
    private static int EAR_CONSEC_FRAMES = 3;

    private int counter;
    private int blinkNumber;

    public BlinkDetection(){
        counter = 0;
        blinkNumber = 0;
    }

    public int detect(double EAR) {

        if(EAR < EAR_THRESH) {
            counter++;
            Log.i("BlinkDetection", "eye close - " + EAR + ", " + counter);
        } else {
            if(counter > EAR_CONSEC_FRAMES){
                blinkNumber++;
                Log.i("BlinkDetection", "Blink - " + blinkNumber);
            }

            counter = 0;
        }

        return blinkNumber;
    }

}
