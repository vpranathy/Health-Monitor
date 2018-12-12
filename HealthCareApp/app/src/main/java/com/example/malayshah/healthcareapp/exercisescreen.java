package com.example.malayshah.healthcareapp;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class exercisescreen extends AppCompatActivity {
    private static final String TAG = "exercisescreen";
    private Button exercise;
    private Button button3;
    private Button button2;
    private Button connect;
    private Button pause;
    private Button play;
    private Button stop;
    public Boolean runner;
    ArrayList<String> workout = new ArrayList<>();
    ArrayList<String> sleep = new ArrayList<>();
    ArrayList<String> study = new ArrayList<>();
    String randData, username;
    MediaPlayer player, player2;
    TextView liveData, textView7, textView8;
    String upload_url = "http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_heartrate.php";
    int mode;
    int random;
    Double lat, lon;
    private final String DEVICE_ADDRESS="98:D3:81:F5:B4:00";
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");//Serial Port Service ID
    private BluetoothDevice device;
    private BluetoothSocket socket;
    boolean deviceConnected=false;
    private OutputStream outputStream;
    private InputStream inputStream;
    boolean stopThread;
    int playerNumberWorkout =0;
    int getPlayerNumberSleep = 0;
    byte buffer[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisescreen);

        workout.add("https://firebasestorage.googleapis.com/v0/b/healthcareapp-eb82e.appspot.com/o/Alan%20Walker%20-%20Fade%20%5BNCS%20Release%5D.mp3?alt=media&token=66c37657-3e47-4b4f-b064-8f358f9fa833");
        workout.add("https://firebasestorage.googleapis.com/v0/b/healthcareapp-eb82e.appspot.com/o/David%20Guetta%20-%20Shot%20Me%20Down%20ft.%20Skylar%20Grey%20(Lyric%20Video).mp3?alt=media&token=d40621a4-ac93-48a4-972e-cb95c6386a0e");
        workout.add("https://firebasestorage.googleapis.com/v0/b/healthcareapp-eb82e.appspot.com/o/Dawn%20Wall%20-%20Rain%20God.mp3?alt=media&token=6f2c0e43-fb11-407a-8eac-034b7b332add");
        workout.add("https://firebasestorage.googleapis.com/v0/b/healthcareapp-eb82e.appspot.com/o/Major%20Lazer%20Light%20it%20Up%20(feat.%20Nyla%20%26%20Fuse%20ODG)%20(Music%20Video%20Remix)%20by%20Method%20Studios.mp3?alt=media&token=e4e24ee9-1ff2-4fcb-b302-5c3d1f3c6fc1");


        sleep.add("https://firebasestorage.googleapis.com/v0/b/healthcareapp-eb82e.appspot.com/o/portugal.mp3?alt=media&token=43e53bc3-9b09-4bd4-84ce-0571a2e591d4");
        sleep.add("https://firebasestorage.googleapis.com/v0/b/healthcareapp-eb82e.appspot.com/o/Marconi%20Union%20-%20Weightless.mp3?alt=media&token=74beefdf-2ea2-4340-8336-1755c94523a9");



        Intent intent= getIntent();
        username=intent.getStringExtra("username");
        lat = intent.getDoubleExtra("latitude",0);
        lon=intent.getDoubleExtra("longitude",0);
        play = findViewById(R.id.Play);
        play.setVisibility(View.INVISIBLE);
        pause = findViewById(R.id.Pause);
        stop = findViewById(R.id.Stop);
        stop.setVisibility(View.INVISIBLE);

        stop.setVisibility(View.INVISIBLE);
        connect= findViewById(R.id.connect);
        liveData = findViewById(R.id.liveData);
        exercise = findViewById(R.id.button1);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        player = new MediaPlayer();
        player2 =  new MediaPlayer();
        try {
            player.setDataSource(workout.get(0));
            player.prepare();
            player2.setDataSource(sleep.get(0));
            player2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pause.setVisibility(View.INVISIBLE);
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//        Log.d(TAG, "onCreate: testing");

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BTinit())
                {
                    if(BTconnect())
                    {

                        deviceConnected=true;
                        beginListenForData();
                    }

                }
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: testing click");
                //send an some data to start receiving (use onclickSend)

                try {
                    Log.d(TAG, "onClick: trying to trigger");
                    outputStream.write("a\n".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onClick: bluetooth triggered");
                stop.setVisibility(View.VISIBLE);
                mode= 1;
                runner = true;
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);

                try {
                    player.setDataSource(workout.get(0));
                    player.prepare();
                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            player =mp;
                            mp.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

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
                                            params.put("username","test0");
                                            params.put("heartrate",randData);
                                            params.put("date",formattedDate);
                                            params.put("time",formattedTime);
                                            params.put("music","RossiniWilliam");
                                            params.put("latitude","40.521300");
                                            params.put("longitude","-74.461144)");
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


//        button3 = (Button) findViewById(R.id.button3);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openinfoscreenc();
//            }
//        });
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
                try {
                    player2.setDataSource(sleep.get(0));
                    player2.prepare();
                    player2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            player2=mp;
                            mp.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                                            params.put("username","test0");
                                            params.put("heartrate",randData);
                                            params.put("date",formattedDate);
                                            params.put("time",formattedTime);
                                            params.put("music","Dance");
                                            params.put("latitude",lat.toString());
                                            params.put("longitude",lon.toString());
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
                try {
                    onClickStop(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //stop the bluetooth connection
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
                try {
                    onClickStop(v);
                } catch (IOException e) {
                    e.printStackTrace();
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

    public void onClickStop(View view) throws IOException {
        stopThread = true;
        outputStream.close();
        inputStream.close();
        socket.close();
        deviceConnected=false;
    }
        public void openinfoscreenc() {
            Intent intent6 = new Intent(this, informationscreenC.class);
            startActivity(intent6);
        }
        public void callGeneratedValues(){
            Log.d(TAG, "callGeneratedValues: called");


        }


    void beginListenForData()
    {
        final Handler handler = new Handler();
        stopThread = false;
        buffer = new byte[1024];
        Thread thread  = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopThread)
                {
                    try
                    {
                        int byteCount = inputStream.available();
                        if(byteCount > 0)
                        {
                            byte[] rawBytes = new byte[byteCount];
                            inputStream.read(rawBytes);
                            final String string=new String(rawBytes,"UTF-8");
                            Log.d(TAG, "run: the received string is "+string);
                            handler.post(new Runnable() {
                                public void run()
                                {
                                   // liveData.setText(string);
                                }
                            });

                        }
                    }
                    catch (IOException ex)
                    {
                        stopThread = true;
                    }
                }
            }
        });

        thread.start();
    }
    private void updateLiveData(final String randData) {
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            @Override
            public void run() {
                liveData.setText(randData);
                Log.d(TAG, "run: random number is "+randData);
            }
        });
    }



    public boolean BTinit()
    {
        boolean found=false;
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"Device doesnt Support Bluetooth",Toast.LENGTH_SHORT).show();
        }
        if(!bluetoothAdapter.isEnabled())
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter, 0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if(bondedDevices.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Pair the Device first",Toast.LENGTH_SHORT).show();
        }
        else
        {
            for (BluetoothDevice iterator : bondedDevices)
            {
                if(iterator.getAddress().equals(DEVICE_ADDRESS))
                {
                    device=iterator;
                    found=true;
                    break;
                }
            }
        }
        return found;
    }


    public boolean BTconnect() {
        boolean connected = true;
        try {
            socket = device.createRfcommSocketToServiceRecord(PORT_UUID);
            socket.connect();
        } catch (IOException e) {
            e.printStackTrace();
            connected = false;
        }
        if (connected) {
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return connected;
    }


    public int generateRandomValues(){
        Random rand= new Random();
        int max = 145;
        int min =155;
        return (max + rand.nextInt((-max+min)+1));
    }

    public void next(View view) {
        if (mode ==1) {
            Log.d(TAG, "next: calling play");
            player.stop();
            player.release();
            player = new MediaPlayer();

            if (playerNumberWorkout < workout.size()) {
                Log.d(TAG, "next: entered");
                playerNumberWorkout++;
            }
            try {
                player.setDataSource(workout.get(playerNumberWorkout));
                player.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player = mp;
                    mp.start();
                }
            });
        }else if (mode ==2){
            Log.d(TAG, "next: calling play");
            player2.stop();
            player2.release();
            player2 = new MediaPlayer();

            if (getPlayerNumberSleep < sleep.size()) {
                Log.d(TAG, "next: entered");
                getPlayerNumberSleep++;
            }
            try {
                player2.setDataSource(sleep.get(getPlayerNumberSleep));
                player2.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            player2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player2 = mp;
                    mp.start();
                }
            });
        }
    }

    public void previous(View view) {
        if (mode ==1) {
            Log.d(TAG, "previous: calling play");
            player.stop();
            player.release();
            player = new MediaPlayer();

            if (playerNumberWorkout > 0) {
                Log.d(TAG, "next: entered");
                playerNumberWorkout--;
            } else {
                playerNumberWorkout = workout.size() - 1;
            }
            try {
                player.setDataSource(workout.get(playerNumberWorkout));
                player.prepare();
                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        player = mp;
                        mp.start();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (mode ==2){
            Log.d(TAG, "previous: calling play");
            player2.stop();
            player2.release();
            player2 = new MediaPlayer();

            if (getPlayerNumberSleep > 0) {
                Log.d(TAG, "next: entered");
                getPlayerNumberSleep--;
            }
            else{
                getPlayerNumberSleep = workout.size()-1;
            }
            try {
                player2.setDataSource(sleep.get(getPlayerNumberSleep));
                player2.prepare();
                player2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        player = mp;
                        mp.start();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


