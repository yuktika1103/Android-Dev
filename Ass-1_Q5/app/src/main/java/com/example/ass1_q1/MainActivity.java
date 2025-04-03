package com.example.ass1_q1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import com.example.ass1_q1.R;

public class MainActivity extends AppCompatActivity {

    private Spinner subjectSpinner;
    private TextView selectedSubjectText, syllabusLink;
    private Map<String, String> syllabusUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectSpinner = findViewById(R.id.subjectSpinner);
        selectedSubjectText = findViewById(R.id.selectedSubjectText);
        syllabusLink = findViewById(R.id.syllabusLink);

        syllabusUrls = new HashMap<>();
        syllabusUrls.put("Mathematics", "https://www.geeksforgeeks.org/maths/");
        syllabusUrls.put("Physics", "https://www.geeksforgeeks.org/physics/");
        syllabusUrls.put("Chemistry", "https://www.geeksforgeeks.org/chemistry/");
        syllabusUrls.put("Computer Networks", "https://www.geeksforgeeks.org/computer-network-tutorials/");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, syllabusUrls.keySet().toArray(new String[0]));
        subjectSpinner.setAdapter(adapter);

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSubject = parent.getItemAtPosition(position).toString();
                selectedSubjectText.setText("Selected Subject: " + selectedSubject);

                syllabusLink.setVisibility(View.VISIBLE);
                syllabusLink.setTag(syllabusUrls.get(selectedSubject));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                syllabusLink.setVisibility(View.GONE);
            }
        });

        syllabusLink.setOnClickListener(v -> {
            String url = (String) syllabusLink.getTag();
            if (url != null) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }
}
