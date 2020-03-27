package org.covid19india;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressbar;
    private WebView mWebview;
    private ImageView mLogo;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressbar = findViewById(R.id.MainAct_Progressbar);
        mWebview = findViewById(R.id.MainAct_WebView);
        mLogo = findViewById(R.id.MainAct_Logo);
        mTitle = findViewById(R.id.MainAct_Title);


        WebSettings webSettings = mWebview.getSettings();
        mWebview.loadUrl("https://www.covid19india.org");
        webSettings.setDomStorageEnabled(true);

        //  mWebview.clearSslPreferences();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);



        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                mLogo.setVisibility(View.GONE);
                mProgressbar.setVisibility(View.GONE);
                mWebview.setVisibility(View.VISIBLE);
                mTitle.setVisibility(View.GONE);

            }
        });


    }


    @Override
    public void onBackPressed(){
        if(mWebview.canGoBack()) {
            mWebview.goBack();
        } else{
            super.onBackPressed();
        }
    }
}
