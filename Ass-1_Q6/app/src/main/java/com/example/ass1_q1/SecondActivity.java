package com.example.ass1_q1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewGreeting = findViewById(R.id.textViewGreeting);

        // Get the name passed from MainActivity
        String name = getIntent().getStringExtra("userName");

        // Set the greeting message
        textViewGreeting.setText("Hello, " + name + "!");
    }
}
