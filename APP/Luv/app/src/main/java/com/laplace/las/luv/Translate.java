package com.laplace.las.luv;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;

public class Translate extends AppCompatActivity {
    Button button;
    EditText get_t;
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        button = findViewById(R.id.button);
        get_t = findViewById(R.id.gettext);
        view = findViewById(R.id.text_view);

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
            view.setText(s.split("\"translatedText\":\"")[1]);
        }
    }
}
