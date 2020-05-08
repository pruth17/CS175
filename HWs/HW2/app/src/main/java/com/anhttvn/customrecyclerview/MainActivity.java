package com.anhttvn.customrecyclerview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import com.anhttvn.customrecyclerview.adapter.ListAdapter;
import com.anhttvn.customrecyclerview.model.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleview;
    private List<ItemAdapter> mList = new ArrayList<>();
    private ListAdapter mAdapter;
    private Menu x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addList();
        adapter();


    }
    @Override
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
    private void init(){

        mRecycleview = findViewById(R.id.listView);
    }
    private void addList(){
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.lion);
        itemAdapter.setText("Lion");
        mList.add(itemAdapter);

        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.elephant);
        itemAdapter.setText("Elephant");
        mList.add(itemAdapter);

        itemAdapter = new ItemAdapter();
        itemAdapter.setText("Cheetah");
        itemAdapter.setImage(R.drawable.cheetah);
        mList.add(itemAdapter);

        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.giraffe);
        itemAdapter.setText("Giraffe");
        mList.add(itemAdapter);

        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.tiger);
        itemAdapter.setText("Tiger");
        mList.add(itemAdapter);

    }

    private void adapter(){

        mAdapter = new ListAdapter(mList, this);
        mRecycleview.setAdapter(mAdapter);
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.notifyDataSetChanged();

    }

}
