package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExecutorService tasklist = Executors.newFixedThreadPool(50);
        tasklist.execute(this);
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<20;i++){
                String threadName = Thread.currentThread().getName();
                Toast.makeText(this, "Thread name :"+threadName, Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e2){
            Toast.makeText(this, e2.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}