package com.example.malayshah.healthcareapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText username , password;
    String Username, Password;
    AlertDialog.Builder builder;
    String login_url = "http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonA = (Button) findViewById(R.id.buttonA);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        builder= new AlertDialog.Builder(MainActivity.this);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username = username.getText().toString();
                Password = password.getText().toString();
                if (Username.equals("") || Password.equals("")) {
                    builder.setTitle("Something went wrong");
                    DisplatAlert("Enter a valid username and password...");
                } else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                if (code.equals(" login failed")) {
                                    builder.setTitle("Login error");
                                    DisplatAlert(jsonObject.getString("message"));
                                } else {
                                    openhomeScreen();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT);
                            error.printStackTrace();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            Log.d(TAG, "getParams: "+Username+"'      "+Password);
                            params.put("user_name", Username);
                            params.put("password", Password);
                            return params;

                        }
                    };

                    MySingleton.getmInstance(MainActivity.this).addToRequestQueue(stringRequest);
                }
            }});




        Button buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });

    }
    public void DisplatAlert(String message){
        builder.setMessage(message);
        builder.setPositiveButton("Okay" ,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                username.setText("");
                password.setText("");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void openhomeScreen(){
        Intent intent = new Intent(this, homeScreen.class);
        intent.putExtra("username",Username);
        startActivity(intent);
    }
}
