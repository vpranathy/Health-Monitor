package com.example.malayshah.healthcareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class homeScreen extends AppCompatActivity {

    private Button buttonC;
    private Button button5;
    TextView textView4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        textView4 = findViewById(R.id.textView4);
        buttonC = (Button) findViewById(R.id.buttonC);
        button5= findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensettings();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openexerciseScreen();
            }
        });

//        button5 = (Button) findViewById(R.id.button5);
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                opensettings();
//            }
//        });
//
    }



    public void openexerciseScreen(){
        Intent intent2 = new Intent(this, exercisescreen.class);
        startActivity(intent2);
    }

    public void opensettings(){
        Intent intent6= new Intent(this, settings.class);
        startActivity(intent6);
    }
}
