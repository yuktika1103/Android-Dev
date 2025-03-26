package com.example.ass1_q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();

                if (!name.isEmpty()) {
                    // Create an intent to navigate to SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // Pass the name to the second activity
                    intent.putExtra("userName", name);
                    startActivity(intent);
                } else {
                    editTextName.setError("Please enter your name");
                }
            }
        });
    }
}
