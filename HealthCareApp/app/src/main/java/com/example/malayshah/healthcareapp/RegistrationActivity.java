package com.example.malayshah.healthcareapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    Button register;
    EditText Name, email, username, password;
    String enteredName, enteredemail, enteredUsername, enteredPassword;
    AlertDialog.Builder builder;
    String reg_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register = findViewById(R.id.RegisterButton);
        Name = findViewById(R.id.RegName);

    }
}
