package com.example.prakashreddy45.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class GameOver extends AppCompatActivity {
int npoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        int points_scored=getIntent().getIntExtra("POINTS_IDENTIFER",0);
        String s= Integer.toString(points_scored);
        TextView textview =(TextView)findViewById(R.id.score_dispaly);
        textview.setText("Final Score: " + s);
npoints=points_scored;
       // String response="";
       // GlobalClass globalClass=(GlobalClass) getApplicationContext();

        final MediaPlayer whiteP1 = MediaPlayer.create(GameOver.this, R.raw.gameover);
        new Thread(new Runnable() {
            public void run() {
                whiteP1.start();                         try {                Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();                         }
                whiteP1.stop();
                whiteP1.release();
            }
        }).start();
    }

    public void scoresview(View v)
    {
        Toast.makeText(GameOver.this,"Scored Saved",Toast.LENGTH_SHORT).show();
        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
        EditText editText=(EditText)findViewById(R.id.playername);
        String name=editText.getText().toString();
        if(name.length()==0)
            name="Player";
        SharedPreferences.Editor editor=preferences.edit();
        String previouscores=preferences.getString("SCORES","");
editor.putString("SCORES",name + "      " + npoints+"\n" + previouscores);
        editor.commit();
       finish();

    }
}
