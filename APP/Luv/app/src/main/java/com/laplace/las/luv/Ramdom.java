package com.laplace.las.luv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class Ramdom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramdom);

        Button b = findViewById(R.id.button_random);
        b.setOnClickListener(v->{
            java.util.Random a = new Random();
            int ran =a.nextInt(100);
            Toast.makeText(getApplicationContext(),"NumBER : "+ran,Toast.LENGTH_LONG).show();
        });

        b.setOnLongClickListener(v->{
            finish();
            return false;
        });
    }
}
