package com.example.filerw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.et1);
        e2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fout;
                try {
                    fout = openFileOutput(e1.getText().toString(),0);
                    OutputStreamWriter osw = new OutputStreamWriter(fout);
                    osw.write(e2.getText().toString());
                    Toast.makeText(MainActivity.this, "Written to file", Toast.LENGTH_SHORT).show();
                    osw.flush();
                    osw.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fin;
                try {
                    fin = openFileInput(e1.getText().toString());
                    InputStreamReader isr = new InputStreamReader(fin);
                    char[] b = new char[10];
                    int n = isr.read(b,0,10);
                    String str = new String(b,0,n);
                    e2.setText(str);
                    Toast.makeText(MainActivity.this, "Read from file.", Toast.LENGTH_SHORT).show();
                    isr.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}