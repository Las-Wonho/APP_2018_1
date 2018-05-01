package com.laplace.las.fa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.listview_item,list);
        Spinner spinner = findViewById(R.id.sp);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                list.clear();
                list.add("qwe2");
                list.add("qwe3");
                list.add("qwe5");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
