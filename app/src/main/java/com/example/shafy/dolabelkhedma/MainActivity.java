package com.example.shafy.dolabelkhedma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityOptionListAdapter.OnOptionClicked{

    private RecyclerView mOptionsList;
    private MainActivityOptionListAdapter mListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.main_activity));
        mOptionsList = (RecyclerView) findViewById(R.id.rv_main_activity_options_list);
        //StaggeredGridLayoutManager layoutManager1 =new StaggeredGridLayoutManager(2,1);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        mOptionsList.setLayoutManager(layoutManager);
        mListAdapter =new MainActivityOptionListAdapter(this);
        mOptionsList.setAdapter(mListAdapter);
        mOptionsList.setHasFixedSize(true);

    }

    @Override
    public void onClickListener(int position) {
        Intent intent;
        switch(position)
        {
            case 0:
                intent=new Intent(MainActivity.this,AttendanceActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(MainActivity.this,LogActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(MainActivity.this,FridayActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(MainActivity.this,DolabActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(MainActivity.this,TripActivity.class);
                startActivity(intent);
                break;
        }
    }
}
