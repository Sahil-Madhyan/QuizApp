package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Objects.requireNonNull(getSupportActionBar()).hide();
        String user = getIntent().getStringExtra("keyname");
        CardView java = findViewById(R.id.javaCard);
        TextView dashBoardUsername = findViewById(R.id.dashUser);
        dashBoardUsername.setText(user);
        java.setOnClickListener(v -> new Handler().postDelayed(() -> startActivity(new Intent(DashboardActivity.this, JavaQuiz.class)), 200));

    }
}