package com.laplace.las.luv;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Translate extends AppCompatActivity {
    Button button;
    EditText get_t;
    ListView view;
    List<String> list;
    ArrayAdapter<String> ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        list = new ArrayList<String>();
        button = findViewById(R.id.button);
        get_t = findViewById(R.id.gettext);
        view = findViewById(R.id.list);

        list.add("LAS");
        ar = new ArrayAdapter<String>(this,R.layout.main_item,R.id.main_item_name,list);
        view.setAdapter(ar);
        button.setOnClickListener(v->{
            String objective = get_t.getText().toString();
            NetworkTask networkTask = new NetworkTask(get_t.getText().toString());
            networkTask.execute();
        });

    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;

        public NetworkTask(String url) {

            this.url = url;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            HTTPS_POST requestHttpURLConnection = new HTTPS_POST();
            result = requestHttpURLConnection.play(url); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            Toast.makeText(getApplicationContext(),s.split("\"")[19],Toast.LENGTH_SHORT);
            list.add(s.split("\"")[19]);
            ar.notifyDataSetChanged();
        }
    }
}
