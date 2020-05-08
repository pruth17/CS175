package edu.sjsu.android.exercise4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyBrowser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);
        TextView textView = findViewById(R.id.textView);
        Intent i = getIntent();
        String url = i.getExtras().getString("url");
        textView.setText(url);
    }
}
