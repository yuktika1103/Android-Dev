package com.example.ass1_q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    private Button addBtn, subBtn, mulBtn, divBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        addBtn.setOnClickListener(view -> performOperation('+'));
        subBtn.setOnClickListener(view -> performOperation('-'));
        mulBtn.setOnClickListener(view -> performOperation('*'));
        divBtn.setOnClickListener(view -> performOperation('/'));
    }

    private void performOperation(char operator) {
        String strNum1 = num1.getText().toString();
        String strNum2 = num2.getText().toString();

        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double number1 = Double.parseDouble(strNum1);
        double number2 = Double.parseDouble(strNum2);
        double output = 0;

        switch (operator) {
            case '+': output = number1 + number2; break;
            case '-': output = number1 - number2; break;
            case '*': output = number1 * number2; break;
            case '/':
                if (number2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                output = number1 / number2;
                break;
        }

        result.setText("Result: " + output);
    }
}
