package com.example.mac.infolab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Archita on 10-07-2016.
 */
public class Main13Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        String frameVideo = "<iframe width=\"854\" height=\"480\" src=\"https://www.youtube.com/embed/EmeTZGr_R5Q\" frameborder=\"0\" allowfullscreen></iframe>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webView5);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        displayYoutubeVideo.getSettings().setLoadWithOverviewMode(true);
        displayYoutubeVideo.getSettings().setUseWideViewPort(true);
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo,"text/html","utf-8");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
