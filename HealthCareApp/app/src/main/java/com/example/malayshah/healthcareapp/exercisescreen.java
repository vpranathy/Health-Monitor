package com.example.malayshah.healthcareapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class exercisescreen extends AppCompatActivity {
    private static final String TAG = "exercisescreen";
    private Button button4;
    private Button button3;
    private Button button2;
    ArrayList<String> workout = new ArrayList<>();
    ArrayList<String> sleep = new ArrayList<>();
    ArrayList<String> study = new ArrayList<>();
    String randData ;
    private Button button1;
    TextView liveData , textView7, textView8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisescreen);

        workout.add("workout1");
        workout.add("workout2");
        workout.add("workout3");
        workout.add("workout4");
        workout.add("workout5");


        sleep.add("sleep1");
        sleep.add("sleep2");
        sleep.add("sleep3");
        sleep.add("sleep4");
        sleep.add("sleep5");


        study.add("study1");
        study.add("study2");
        study.add("study3");
        study.add("study4");
        study.add("study5");


        liveData = findViewById(R.id.liveData);
        button4 = findViewById(R.id.button1);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer t = new Timer();
                t.scheduleAtFixedRate(
                        new TimerTask() {
                            public void run() {
                                randData = Integer.toString(generateRandomValues());
                                updateLiveData(randData);
                            }
                        }, 0, 2000
                );
                textView7.setText("110");
                textView8.setText("160");
            }
        });


        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinfoscreenc();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinfoscreenb();
            }
        });
    }
       // button1 = (Button) findViewById(R.id.butt);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openinfoscreen();
//            }
//        });
//    }
        public void openmusicplayer() {
            Intent intent3 = new Intent(this, musicplayer.class);
            startActivity(intent3);
        }

        public void openinfoscreen() {
            Intent intent4 = new Intent(this, informationscreen.class);
            startActivity(intent4);
        }

        public void openinfoscreenb() {
            Intent intent5 = new Intent(this, informationscreenB.class);
            startActivity(intent5);
        }

        public void openinfoscreenc() {
            Intent intent6 = new Intent(this, informationscreenC.class);
            startActivity(intent6);
        }
        public void callGeneratedValues(){
            Log.d(TAG, "callGeneratedValues: called");


        }

    private void updateLiveData(final String randData) {
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            @Override
            public void run() {
                liveData.setText(randData);
            }
        });
    }




    public int generateRandomValues(){
        Random rand= new Random();
        int max = 110;
        int min =160;
        return (max + rand.nextInt((-max+min)+1));
    }

}
