package com.example.intentapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class Result extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 EdgeToEdge.enable(this);
 setContentView(R.layout.activity_result);
 ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -
> {
 Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
 v.setPadding(systemBars.left, systemBars.top, systemBars.right,
systemBars.bottom);
 return insets;
 });
 TextView user = findViewById(R.id.user);
 Intent intent = getIntent();
 String s = intent.getStringExtra("Result");
 user.setText(s);
 }
 public void back(View view){
 Intent iNext = new Intent(Result.this, MainActivity.class);
 startActivity(iNext);
 }
}