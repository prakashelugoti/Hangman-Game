package com.example.prakashreddy45.hangman;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends Activity {
Button welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome = (Button) findViewById(R.id.welcome_button);
        // Calling Application class (see application tag in AndroidManifest.xml)
         GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.sound_value=0;
    }
    public void click(View view) {


        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    }

