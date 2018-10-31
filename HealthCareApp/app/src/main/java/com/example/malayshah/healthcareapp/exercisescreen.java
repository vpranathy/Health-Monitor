package com.example.malayshah.healthcareapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class exercisescreen extends AppCompatActivity {
    private static final String TAG = "exercisescreen";
    private Button exercise;
    private Button button3;
    private Button button2;
    private Button pause;
    private Button play;
    private Button stop;
    public Boolean runner ;
    ArrayList<String> workout = new ArrayList<>();
    ArrayList<String> sleep = new ArrayList<>();
    ArrayList<String> study = new ArrayList<>();
    String randData ;
    MediaPlayer player,player2;
    TextView liveData , textView7, textView8;
    String upload_url = "http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_heartrate.php";
    int mode ;
    int random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisescreen);

//        workout.add("workout1");
//        workout.add("workout2");
//        workout.add("workout3");
//        workout.add("workout4");
//        workout.add("workout5");
//
//
//        sleep.add("sleep1");
//        sleep.add("sleep2");
//        sleep.add("sleep3");
//        sleep.add("sleep4");
//        sleep.add("sleep5");
//
//
//        study.add("study1");
//        study.add("study2");
//        study.add("study3");
//        study.add("study4");
//        study.add("study5");



        play=findViewById(R.id.Play);
        pause = findViewById(R.id.Pause);
        stop = findViewById(R.id.Stop);
        stop.setVisibility(View.INVISIBLE);
        liveData = findViewById(R.id.liveData);
        exercise = findViewById(R.id.button1);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        player=MediaPlayer.create(this,R.raw.exercise1);
        player2=MediaPlayer.create(this,R.raw.portugal);
        pause.setVisibility(View.INVISIBLE);

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.VISIBLE);
                mode= 1;
                runner = true;
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);
                player.start();
                Timer t = new Timer();
                t.scheduleAtFixedRate(
                        new TimerTask() {
                            public void run() {
                                if (runner) {
                                    random = generateRandomValues();
                                    randData = Integer.toString(random);
                                    updateLiveData(randData);
                                    Date c = Calendar.getInstance().getTime();
                                    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
                                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                    final String formattedDate = df.format(c);
                                    final String formattedTime = time.format(c);
                                    Log.d(TAG, "run: date =>" + formattedDate);
                                    Log.d(TAG, "run: time =>"+formattedTime);
                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, upload_url, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try {
                                                JSONArray jsonArray = new JSONArray(response);
                                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                                String code = jsonObject.getString("code");
                                                Log.d(TAG, "onResponse: after sending"+code);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }){
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError {
                                            Map<String,String> params = new HashMap<String, String>();
                                            params.put("username","Aniket194");
                                            params.put("heartrate",randData);
                                            params.put("date",formattedDate);
                                            params.put("time",formattedTime);
                                            params.put("music","RossiniWilliam");
                                            return params;
                                        }
                                    };
                                    MySingleton.getmInstance(exercisescreen.this).addToRequestQueue(stringRequest);


                                }else{
                                    Log.d(TAG, "run: stopping the loop");
                                }
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
                Log.d(TAG, "onClick: Sleep mode Selected");
                stop.setVisibility(View.VISIBLE);
                mode= 2;
                runner = true;
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);
                player2.start();
                Timer t = new Timer();
                t.scheduleAtFixedRate(
                        new TimerTask() {
                            public void run() {
                                if (runner) {
                                    randData = Integer.toString(generateRandomValues());
                                    updateLiveData(randData);
                                    Date c = Calendar.getInstance().getTime();
                                    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
                                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                    final String formattedDate = df.format(c);
                                    final String formattedTime = time.format(c);
                                    Log.d(TAG, "run: date =>" + formattedDate);
                                    Log.d(TAG, "run: time =>"+formattedTime);
                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, upload_url, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try {
                                                JSONArray jsonArray = new JSONArray(response);
                                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                                String code = jsonObject.getString("code");
                                                Log.d(TAG, "onResponse: after sending"+code);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }){
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError {
                                            Map<String,String> params = new HashMap<String, String>();
                                            params.put("username","Aniket194");
                                            params.put("heartrate",randData);
                                            params.put("date",formattedDate);
                                            params.put("time",formattedTime);
                                            params.put("music","Portugal (A Lift)");
                                            return params;
                                        }
                                    };
                                    MySingleton.getmInstance(exercisescreen.this).addToRequestQueue(stringRequest);


                                }else{
                                    Log.d(TAG, "run: stopping the loop");
                                }
                            }
                        }, 0, 2000
                );
                textView7.setText("110");
                textView8.setText("160");
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                if (mode ==1) {
                    player.stop();
                }else if (mode ==2){
                    player2.stop();
                }else if( mode ==3){
                    //player3.stop();
                }
                runner = false;
            }
        });



        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
                if (mode == 1) {
                    player.pause();
                } else if (mode == 2) {
                    player2.pause();
                } else if (mode == 3) {
                    //player3.pause();
                }
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
                if (mode == 1) {
                    player.start();
                } else if (mode == 2) {
                    player2.start();
                } else if (mode == 3) {
                    //player3.start();
                }
            }
        });
    }

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
