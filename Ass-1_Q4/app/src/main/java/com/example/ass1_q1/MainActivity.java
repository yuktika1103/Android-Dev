package com.example.ass1_q1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ass1_q1.R;

public class MainActivity extends AppCompatActivity {

    private Spinner subjectSpinner;
    private TextView selectedSubjectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectSpinner = findViewById(R.id.subjectSpinner);
        selectedSubjectText = findViewById(R.id.selectedSubjectText);

        // Array of subjects
        String[] subjects = {"Mathematics", "Science", "History", "English", "Computer Science"};

        // Adapter to set items in Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subjects);
        subjectSpinner.setAdapter(adapter);

        // Set item selected listener
        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSubject = parent.getItemAtPosition(position).toString();
                selectedSubjectText.setText("Selected Subject: " + selectedSubject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedSubjectText.setText("Selected Subject: None");
            }
        });
    }
}
