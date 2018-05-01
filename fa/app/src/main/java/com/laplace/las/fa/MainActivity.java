package com.laplace.las.fa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a, b, c, d, e, f;
        AlertDialog alertDialog;
        a=findViewById(R.id.b1);
        b=findViewById(R.id.b2);
        c=findViewById(R.id.b3);
        d=findViewById(R.id.b4);
        e=findViewById(R.id.b5);
        f=findViewById(R.id.b6);

        View.OnClickListener x;
         x = (v)->{
             Button va = (Button)v;
             AlertDialog.Builder bl = new AlertDialog.Builder(this);
             bl.setIcon(R.drawable.mainBox);
             bl.setTitle("las");
             bl.setMessage("qwe");

             switch (v.getId()){
                 case R.id.b1 :
             }
         };

        a.setOnClickListener(x);
        b.setOnClickListener(x);
        c.setOnClickListener(x);
        d.setOnClickListener(x);
        e.setOnClickListener(x);
        f.setOnClickListener(x);
    }
}
