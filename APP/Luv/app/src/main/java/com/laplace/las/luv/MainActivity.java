package com.laplace.las.luv;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView box;
    ScrollView scv;
    HorizontalScrollView gcv;
    int detect_num;

    @Override
    protected void onResume() {
        //detect_num=0;
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        detect_num=1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scv = findViewById(R.id.sc_v);
        box = findViewById(R.id.box);
        gcv = findViewById(R.id.hs_v);

        /*
         인텐트 받아서 실행하는 곳
         */


        scv.setOnTouchListener( (v, event) -> {
            TextView t = findViewById(R.id.t);
            String s = " S -> "+"X : "+Float.toString((int)event.getX()) + ", Y : "+Float.toString((int)event.getY())+": LAS: "+gcv.getScrollX()+" : "+ scv.getScrollY();
            t.setText(s);
            return false;
        });

        gcv.setOnTouchListener( (v, event) -> {
            TextView t = findViewById(R.id.t);
            String s = " H -> "+"X : "+Float.toString((int)event.getX()) + ", Y : "+Float.toString((int)event.getY())+": LAS: "+gcv.getScrollX()+" : "+ scv.getScrollY();
            if(gcv.getScrollX()>400 && detect_num==0){
                detect_num++;
                Intent intent=new Intent(MainActivity.this,TransLate_.class);
                startActivity(intent);
            }else if(gcv.getScrollX()<100&& detect_num==0){
                detect_num++;
                Intent intent=new Intent(MainActivity.this,Random.class);
                startActivity(intent);
            }else if(gcv.getScrollX()<=380&&gcv.getScrollX()>=120){
                detect_num=0;
            }
            t.setText(s);
            return false;
        });

        try{
            Intent intent_ = getIntent();
            int rand = (int) intent_.getExtras().get("Random");
            Toast.makeText(getApplicationContext(), "RANDOM : " + rand, Toast.LENGTH_LONG);
        }catch (Exception a){

        }
    }
}
