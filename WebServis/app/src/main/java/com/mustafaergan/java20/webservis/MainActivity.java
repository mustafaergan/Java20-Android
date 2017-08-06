package com.mustafaergan.java20.webservis;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.idtext);
        String url = "http://services.groupkt.com/country/get/all";
        //String url2 ="http://www.mynet.com/";
        Servis servis = new Servis();
        servis.execute(url);
    }
    private class Servis extends AsyncTask<String,Integer,String>{
        @Override
        protected String doInBackground(String... params) {
            String veri = null;
            try {
                veri = sendGet(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return veri;
        }
        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONObject jsonObject2 =
                (JSONObject) jsonObject.get("RestResponse");
                textView.setText(jsonObject2.get("messages").toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // HTTP GET request
        private String sendGet(String param) throws Exception {
            String url = param;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }


    }
}
