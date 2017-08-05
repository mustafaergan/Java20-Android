package com.mustafaergan.java20.twittersearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ara(View view){
        this.editText =  (EditText)findViewById(R.id.eTAraText);
        this.webView = (WebView)findViewById(R.id.wVTwitter);
        String URL = "https://twitter.com/hashtag/"+editText.getText();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(URL);
    }
}
