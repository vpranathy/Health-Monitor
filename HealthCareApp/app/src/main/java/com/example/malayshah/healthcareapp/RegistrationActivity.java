package com.example.malayshah.healthcareapp;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RegistrationActivity extends AppCompatActivity {
    Button register, dance, hipHop, heavyMetal, sportAnthem;
    EditText Name, email, username, password;
    String enteredName, enteredemail, enteredUsername, enteredPassword,MusicPreference;
    AlertDialog.Builder builder;
    String reg_url = "http://healthmonitoringsystem.us-east-2.elasticbeanstalk.com/mobile_register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        dance = findViewById(R.id.Dance);
        hipHop= findViewById(R.id.hip_hop);
        heavyMetal= findViewById(R.id.heavy_metal);
        sportAnthem= findViewById(R.id.sportAnthem);
        register = findViewById(R.id.RegisterButton);
        Name = findViewById(R.id.RegName);
        email=findViewById(R.id.email);
        username = findViewById(R.id.username);
        password=findViewById(R.id.password);
        dance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicPreference = "Dance";
            }
        });
        hipHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicPreference="HipHop";
            }
        });
        heavyMetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicPreference="HeavyMetal";
            }
        });
        sportAnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicPreference="SportAnthem";
            }
        });
        builder= new AlertDialog.Builder(RegistrationActivity.this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredName= Name.getText().toString();
                enteredUsername=username.getText().toString();
                enteredemail=email.getText().toString();

                enteredPassword= password.getText().toString();
                if (enteredName.matches("")||enteredUsername.matches("")||enteredPassword.matches("")||enteredemail.matches("")){
                    builder.setTitle("Something went wrong");
                    builder.setMessage(" please fill all the fields");
                    displayAlert("input_error");
                }
                else{
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                String message = jsonObject.getString("message");
                                builder.setTitle("server response");
                                builder.setMessage(message);
                                displayAlert(code);
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
                            params.put("name",enteredName);
                            params.put("email",enteredemail);
                            params.put("user_name",enteredUsername);
                            params.put("password",enteredPassword);
                            params.put("MusicPreference",MusicPreference);
                            return params;
                        }
                    };
                    SQLiteDatabase mydata = openOrCreateDatabase("User",MODE_PRIVATE,null);
                    mydata.execSQL("Create table if not exists MusicPref (username Varchar, Music Varchar)");
                    mydata.execSQL("insert into MusicPref(username,Music) " +
                            "Values('"+enteredUsername+"','"+MusicPreference+"')");
                    MySingleton.getmInstance(RegistrationActivity.this).addToRequestQueue(stringRequest);
                }
            }
        });
    }

    public void displayAlert(final String code){
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (code.equals("input_error")){
                    password.setText("");

                }

                else if (code.equals(" Registered Successfully")){
                    finish();
                }
                else if(code.equals("Registration failed")){
                    Toast.makeText(RegistrationActivity.this," error ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
