package com.anhttvn.customrecyclerview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class InformationActivity extends AppCompatActivity {

    private Button callButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        callButton = (Button) findViewById(R.id.button1);
        backButton = findViewById(R.id.backbutton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String number = (String) callButton.getText();
               Intent callActivity = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:4081231234"));
               startActivity(callActivity);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(returnActivity);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(getBaseContext(), InformationActivity.class);
            startActivity(myIntent);
            return true;
        }
        else if (id == R.id.action_help){
            Uri packageURI = Uri.parse("package:com.anhttvn.customrecyclerview");
            Intent intent = new Intent(Intent.ACTION_DELETE,packageURI);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}

