package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextView username = findViewById(R.id.userName);
        TextView password = findViewById(R.id.password);
        Button logInBtn = findViewById(R.id.logIn);

        logInBtn.setOnClickListener(view -> {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin123")) {
                Toast.makeText(LoginActivity.this, "Login Successfull !!", Toast.LENGTH_SHORT).show();
                String usrnme = username.getText().toString();
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    intent.putExtra("keyname", usrnme);
                    startActivity(intent);
                    finish();
                }, 500);
            } else {
                if (!(username.getText().toString().equals("admin"))) {
                    Toast.makeText(LoginActivity.this, "Login Failed :( Check Username !!", Toast.LENGTH_SHORT).show();
                } else if (!(password.getText().toString().equals("admin"))) {
                    Toast.makeText(LoginActivity.this, "Login Failed :( Check Password !!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}