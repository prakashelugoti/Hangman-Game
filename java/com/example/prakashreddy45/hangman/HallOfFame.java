package com.example.prakashreddy45.hangman;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HallOfFame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);
        SharedPreferences preferences=getSharedPreferences("MYPREFERENCES",MODE_PRIVATE);
        String scores=preferences.getString("SCORES","NO SCORES");
        TextView textView=(TextView)findViewById(R.id.textinscroll);
        textView.setText(scores);
    }
}
