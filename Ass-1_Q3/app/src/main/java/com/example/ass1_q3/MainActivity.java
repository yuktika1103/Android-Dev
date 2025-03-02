package com.example.ass1_q3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput, heightInput;
    private Button calculateBtn;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateBtn = findViewById(R.id.calculateBtn);
        resultText = findViewById(R.id.resultText);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            resultText.setText("Please enter both weight and height.");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // Convert cm to meters

        if (weight <= 0 || height <= 0) {
            resultText.setText("Invalid input. Enter positive values.");
            return;
        }

        float bmi = weight / (height * height);
        String category = getBMICategory(bmi);

        resultText.setText(String.format("Your BMI: %.2f\n%s", bmi, category));
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }
}
