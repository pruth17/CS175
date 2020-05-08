package com.anhttvn.customrecyclerview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Intent a = getIntent();
        Bundle extras = getIntent().getExtras();
        String name = a.getExtras().getString("name1");
        String information = a.getExtras().getString("info");
        int imags = a.getExtras().getInt("Image1");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(name);
        TextView text = findViewById(R.id.textView3);
        text.setText(information);
        ImageView image = findViewById(R.id.imageView1);
        Drawable drawable = getResources().getDrawable(imags);
        image.setImageDrawable(drawable);




    }
    public boolean onCreateOptionsMenu(Menu menu)
    {// Inflate the menu; this adds items to the action bar if it is present.
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
