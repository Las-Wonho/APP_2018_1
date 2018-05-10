package com.laplace.las.luv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ScrollView Y;
    HorizontalScrollView X;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        X = findViewById(R.id.x);
        Y = findViewById(R.id.y);

        a=1;

        X.setOnTouchListener((view, event)->{

            if(X.getScrollX()<200&&a==0){
                Intent intent = new Intent(MainActivity.this,Ramdom.class);
                a=2;
                startActivity(intent);
            }else if(X.getScrollX()>400&&a==0){
                Intent intent = new Intent(MainActivity.this,Translate.class);
                a=3;
                startActivity(intent);
            }else if(X.getScrollX()<395&&X.getScrollX()>205){
                a=0;
            }
            return  false;
    });
    }
}
