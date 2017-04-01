package com.example.prakashreddy45.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    SharedPreferences sharedpreferences_flag;
    public static final String mypreference_flag = "mypref";
    public static final String flag_status = "flag_status";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView textView=(TextView)findViewById(R.id.textView2);
       final Button button=(Button)findViewById(R.id.button_settings);


        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        sharedpreferences_flag = getSharedPreferences(mypreference_flag,
                Context.MODE_PRIVATE);

        if(sharedpreferences_flag.getString(flag_status,"").equals(""))
            button.setText("Sounds are ON");
        else
        button.setText("Sounds are OFF");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(sharedpreferences_flag.getString(flag_status,"").toString().equals(""))
               {
SharedPreferences.Editor editor=sharedpreferences_flag.edit();
                   editor.putString(flag_status,"1");
                   editor.commit();
                   button.setText("Sounds are OFF");
               }
                else
               {
                   SharedPreferences.Editor editor=sharedpreferences_flag.edit();
                   editor.putString(flag_status,"");
                   editor.commit();
                   button.setText("Sounds are ON");
               }
            }
        });
    }


}