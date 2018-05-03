package com.laplace.las.luv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TransLate_ extends AppCompatActivity {

    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_late_);

        listView = findViewById(R.id.list);
        List<String> stringList = new ArrayList<>();
        //String[] strings = new String[500];
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,R.layout.main_item,R.id.main_item_name, stringList);
        listView.setAdapter(arrayAdapter);

        button = findViewById(R.id.button1);
        button.setOnClickListener(v->{
            stringList.add("LAS");
            arrayAdapter.notifyDataSetChanged();
        });
        button.setOnLongClickListener(v->{
            finish();
            return false;
        });
    }

}
