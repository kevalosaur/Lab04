package com.daviskevin.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TimerTask timerTask;
    int[] layouts = {R.layout.activity_main, R.layout.activity_2, R.layout.activity_3, R.layout.activity_4, R.layout.activity_5, R.layout.activity_6, R.layout.activity_7};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        setContentView(layouts[(i++) % layouts.length]);
                    }
                });
            }
        };
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 1, 3000);
    }
}