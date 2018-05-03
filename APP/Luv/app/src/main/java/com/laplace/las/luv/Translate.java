package com.laplace.las.luv;

/**
 * Created by Las on 2018-05-03.
 */
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translate extends Thread{

    String a;
    TextView t;
    Translate(String s, TextView t_){
        a=s;
        t= t_;
    };

    public void run() {
        String clientId = "p0uJcP0XWh3ZRRrDH1sv";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "skIPyQnDR1";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(a, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/language/translate";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            t.setText(response.toString());
        } catch (Exception e) {
            System.out.println();
            System.exit(0);
            t.setText(e.toString());
        }
    }
}