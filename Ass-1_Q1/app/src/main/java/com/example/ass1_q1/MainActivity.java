package com.example.ass1_q1;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display Good Morning Message using Toast
        Toast.makeText(this, "Good Morning!", Toast.LENGTH_SHORT).show();
    }
}
