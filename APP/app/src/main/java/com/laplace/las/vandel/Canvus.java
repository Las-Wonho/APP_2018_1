package com.laplace.las.vandel;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Canvus extends AppCompatActivity {

    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvus_layout);
        layout = findViewById(R.id.canvus_pa);

    }
}
