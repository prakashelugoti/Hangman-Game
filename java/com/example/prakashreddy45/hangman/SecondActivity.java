package com.example.prakashreddy45.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
Button start,fame,settings,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        exit=(Button)findViewById(R.id.button_quit);
        start=(Button)findViewById(R.id.button_start);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
    public void start(View v)
    {
        Intent intent=new Intent(this,Start.class);
        startActivity(intent);
    }

    public void halloffame(View v)
    {
        Intent intent=new Intent(this,HallOfFame.class);
        startActivity(intent);
    }
    public void sounds(View v)
    {
        Intent intent=new Intent(this,Settings.class);
        startActivity(intent);
    }
}
