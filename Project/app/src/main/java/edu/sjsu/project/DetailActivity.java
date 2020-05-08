package edu.sjsu.project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView name;
    TextView x;
    String city[];
    int res;
    int cityImage[] ;
    ListView mListView;
    MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImageView = (ImageView) findViewById(R.id.imageView2);
        mListView = findViewById(R.id.listview3);
        name = findViewById(R.id.textView12);


        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            name.setText(mBundle.getString("countryName"));
            mImageView.setImageResource(mBundle.getInt("countryFlag"));
            res = mBundle.getInt("countryFlag");
            city = mBundle.getStringArray("Cities");
            cityImage = mBundle.getIntArray("cityImage");
            String y = "";
        }
//        for(int i = 0; i < cityImage.length; i++){
//            cityImage[i] = res;
//        }
        mAdapter = new MyAdapter(DetailActivity.this, city, cityImage);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(DetailActivity.this, Tour.class);
                mIntent.putExtra("CityName", city[i]);
                mIntent.putExtra("CityFlag", cityImage[i]);
                startActivity(mIntent);

            }
        });

    }
}