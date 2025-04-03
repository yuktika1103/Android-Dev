package com.example.ass1_q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etEmail, etPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Enter a valid email!", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(MainActivity.this, "Password must be at least 6 characters!", Toast.LENGTH_SHORT).show();
                } else {
                    // Move to Welcome Screen
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("USER_NAME", name);
                    startActivity(intent);
                }
            }
        });
    }
}
