package com.example.progressbarthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements Runnable {

    ProgressBar pb1,pb2;
    int pv = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = (ProgressBar) findViewById(R.id.progressBar);
        pb2 = (ProgressBar) findViewById(R.id.progressBar2);
        pb1.setMax(100);
        pb2.setMax(100);
        pb1.setProgress(0);
        pb2.setProgress(0);
        pb2.setEnabled(false);

    }
    public void onB1(View v){
        if(pv == 100){
            pv = 0;
        }
        pv = pv + 10;
        pb1.setProgress(pv);
    }
    public void onB2(View v){
        pv = 0;
        pb2.setEnabled(true);
        Thread t;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        try{
            while(pv <= 100){
                Thread.sleep(200);
                pv += 10;
                pb1.setProgress(pv);
                pb2.setProgress(pv);
            }
            pb2.setEnabled(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}