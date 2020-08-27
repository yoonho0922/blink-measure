package com.example.blinkmeasure.blink;

import android.util.Log;

import java.util.Date;

public class BlinkStatics {

    private static int UNIT;

    int time;               // 시작부터 지금까지 시간
    private Date initDate;  // 시작 시간
    private Date preDate;   // 10초 전 시간
    private Date nowDate;   // 현재 시간
    private int[] blinkData;
    private int i;
    public float nowBPU; // 현재 BPU

    public BlinkStatics(){
        UNIT = 60;
        blinkData = new int[100];
        blinkData[UNIT-1] = -1;
        i = 0;
        nowBPU = -1;
    }

    public BlinkStatics(int unit){
        UNIT = unit;
        blinkData = new int[100];
        blinkData[UNIT-1] = -1;
        i = 0;
        nowBPU = -1;
    }

    public void setData(int blinkNumber, Date mDate){
        if(preDate == null){    // init
            initDate = mDate;
            preDate = mDate;
            return;
        }
        nowDate = mDate;
        time = (int)(nowDate.getTime() - initDate.getTime())/1000;



        if(nowDate.getTime() - preDate.getTime() >= 1000){    // 1초 마다 갱신
            if(time < UNIT){
                initData(blinkNumber);
                return;
            }
            slide(blinkNumber);
            nowBPU = blinkData[UNIT-1] - blinkData[0];

            preDate = nowDate;
            Log.d("blinkStatics", "time : " + time + " blink : " + blinkNumber);
            Log.d("blinkStatics", "BPU : "+nowBPU);
        }
    }

    void initData(int blinkNumber){
        if(blinkData[UNIT-1] == -1) {
            blinkData[i] = blinkNumber;
            Log.d("blinkStatics", "init arr " + i + " " + blinkData[i]);
            i++;
            preDate = nowDate;
        }
        return;
    }

    void slide(int blinkNumber){
        int tmp;
        for(int j = 1; j<UNIT; j++){
            blinkData[j-1] = blinkData[j];
        }
        blinkData[UNIT-1] = blinkNumber;
    }

}
