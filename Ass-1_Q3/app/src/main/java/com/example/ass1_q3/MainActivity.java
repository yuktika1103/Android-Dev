package com.example.ass1_q3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Spinner conversionType;
    private TextView resultText;
    private Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        conversionType = findViewById(R.id.conversionType);
        resultText = findViewById(R.id.resultText);
        convertBtn = findViewById(R.id.convertBtn);

        // Spinner options
        String[] options = {"Kilometers to Miles", "Celsius to Fahrenheit", "Kilograms to Pounds", "Liters to Gallons"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        conversionType.setAdapter(adapter);

        convertBtn.setOnClickListener(view -> performConversion());
    }

    private void performConversion() {
        String inputStr = inputNumber.getText().toString();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue = Double.parseDouble(inputStr);
        int selectedPosition = conversionType.getSelectedItemPosition();
        double convertedValue = 0;
        String unit = "";

        switch (selectedPosition) {
            case 0: // Kilometers to Miles
                convertedValue = inputValue * 0.621371;
                unit = " Miles";
                break;
            case 1: // Celsius to Fahrenheit
                convertedValue = (inputValue * 9/5) + 32;
                unit = " °F";
                break;
            case 2: // Kilograms to Pounds
                convertedValue = inputValue * 2.20462;
                unit = " Pounds";
                break;
            case 3: // Liters to Gallons
                convertedValue = inputValue * 0.264172;
                unit = " Gallons";
                break;
        }

        resultText.setText("Converted Value: " + convertedValue + unit);
    }
}
