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
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class homeScreen extends AppCompatActivity {
    private static final String TAG = "homeScreen";
    private final String DEVICE_ADDRESS="98:D3:81:F5:B4:00";
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");//Serial Port Service ID
    private BluetoothDevice device;
    private BluetoothSocket socket;
    public OutputStream outputStream;
    private InputStream inputStream;
    private Button buttonC;
    private Button button5;
    private Button connect;
    TextView textView4 ;
    boolean deviceConnected=false;
    String Username;
    boolean stopThread;
    byte buffer[];
    double lat,lon;
    LocationManager locationManager;
    LocationListener locationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent intent = getIntent();
        Button exerciseInfo = findViewById(R.id.exerciseInfo);
        Button sleepInfo=findViewById(R.id.sleepInfo);
        exerciseInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), informationscreen.class));
            }
        });
        sleepInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),informationscreenC.class));
            }
        });
        Username= intent.getStringExtra("username");
        textView4 = findViewById(R.id.textView4);
        buttonC = (Button) findViewById(R.id.buttonC);
//        button5= findViewById(R.id.button5);
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                opensettings();
//            }
//        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openexerciseScreen();
            }
        });
//        connect= findViewById(R.id.buttonD);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(TAG, "onLocationChanged: getting location");
                lat = location.getLatitude();
                lon = location.getLongitude();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 0, 0, locationListener);


//        connect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(BTinit())
//                {
//                    if(BTconnect())
//                    {
//
//                        deviceConnected=true;
//                        beginListenForData();
//                    }
//
//                }
//            }
//        });
//        //connect button should execute the onClickStart function

    }

//    void beginListenForData()
//    {
//        final Handler handler = new Handler();
//        stopThread = false;
//        buffer = new byte[1024];
//        Thread thread  = new Thread(new Runnable()
//        {
//            public void run()
//            {
//                while(!Thread.currentThread().isInterrupted() && !stopThread)
//                {
//                    try
//                    {
//                        int byteCount = inputStream.available();
//                        if(byteCount > 0)
//                        {
//                            byte[] rawBytes = new byte[byteCount];
//                            inputStream.read(rawBytes);
//                            final String string=new String(rawBytes,"UTF-8");
//                            handler.post(new Runnable() {
//                                public void run()
//                                {
//                                   //the text view to display the live rate
//                                }
//                            });
//
//                        }
//                    }
//                    catch (IOException ex)
//                    {
//                        stopThread = true;
//                    }
//                }
//            }
//        });
//
//        thread.start();
//    }
//
//    public boolean BTinit()
//    {
//        boolean found=false;
//        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
//        if (bluetoothAdapter == null) {
//            Toast.makeText(getApplicationContext(),"Device doesnt Support Bluetooth",Toast.LENGTH_SHORT).show();
//        }
//        if(!bluetoothAdapter.isEnabled())
//        {
//            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enableAdapter, 0);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
//        if(bondedDevices.isEmpty())
//        {
//            Toast.makeText(getApplicationContext(),"Please Pair the Device first",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            for (BluetoothDevice iterator : bondedDevices)
//            {
//                if(iterator.getAddress().equals(DEVICE_ADDRESS))
//                {
//                    device=iterator;
//                    found=true;
//                    break;
//                }
//            }
//        }
//        return found;
//    }
//
//
//    public boolean BTconnect() {
//        boolean connected = true;
//        try {
//            socket = device.createRfcommSocketToServiceRecord(PORT_UUID);
//            socket.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//            connected = false;
//        }
//        if (connected) {
//            try {
//                outputStream = socket.getOutputStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                inputStream = socket.getInputStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return connected;
//    }
//


    public void openexerciseScreen(){
        Intent intent2 = new Intent(this, exercisescreen.class);
        locationManager.removeUpdates(locationListener);
        intent2.putExtra("username",Username);
        intent2.putExtra("latitude",lat);
        intent2.putExtra("longitude",lon);
        startActivity(intent2);
    }

    public void opensettings(){
        Intent intent6= new Intent(this, settings.class);
        startActivity(intent6);
    }
}
