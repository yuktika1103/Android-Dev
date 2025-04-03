package com.example.ass1_q1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    private TextView tvWelcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvWelcomeMsg = findViewById(R.id.tvWelcomeMsg);

        // Get Name from Intent
        String name = getIntent().getStringExtra("USER_NAME");

        // Set Welcome Message
        tvWelcomeMsg.setText("Hello, " + name + "!");
    }
}
