package com.laplace.las.luv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Random extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        button = findViewById(R.id.randbutton);
        button.setOnClickListener(v->{
            java.util.Random radomer = new java.util.Random();
            int rand = radomer.nextInt(100);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("Random",rand);
            startActivity(intent);
        });
    }
}
