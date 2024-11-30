package com.example.javamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;jhhh
    private WebView mWebView;

    private String urlToload =nnnnnikkkk "https://www.google.lk/webhp?hl=en&sa=X&ved=0ahUKEwiZwtiMpsSJAxWEzjgGHavjD5QQPAgI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assiging view by id
        mProgressBar = findViewById(R.id.loading_progressbar);
        mWebView = findViewById(R.id.webview);

        mWebView.loadUrl(urlToload);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);

        //for progress  bar
        mWebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }
        });




    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack())
        {
mWebView.goBack();
        }
        else {
            super.onBackPressed();
        }

    }
}