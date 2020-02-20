package fr.isima.tp_squelette_spacex.activity;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.Launch;

public class LaunchActivity extends Activity {

    WebView webview;
    Launch l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        l = (Launch) getIntent().getSerializableExtra("Launch");
        webview = findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(l.links.article_link);
    }
}
