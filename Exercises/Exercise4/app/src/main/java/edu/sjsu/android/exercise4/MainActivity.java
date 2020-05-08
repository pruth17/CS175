package edu.sjsu.android.exercise4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button callButton = findViewById(R.id.call);
        Button browser = findViewById(R.id.browser);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callActivity = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+194912344444"));
                startActivity(callActivity);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.google.com";
                Intent baseIntent = new Intent(Intent.ACTION_VIEW);
                baseIntent.setData(Uri.parse(url));
                baseIntent.putExtra("url",url);
                Intent chooserIntent = Intent.createChooser(baseIntent, "Choose App");
                // Verify the intent will resolve to at least one activity
                if (baseIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooserIntent);
                }
            }
        });
    }
}
