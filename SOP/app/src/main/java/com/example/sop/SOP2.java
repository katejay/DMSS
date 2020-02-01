package com.example.sop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class SOP2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sop2);

        WebView webView=findViewById(R.id.webView);
        final ProgressBar progressBar=findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        String url="https://firebasestorage.googleapis.com/v0/b/dmss-3090b.appspot.com/o/Testing.pdf?alt=media&token=9246d003-d75e-41b8-87f9-a819e513b6bb";
        //String url="url";
        String finalURL="https://drive.google.com/viewerng/viewer?embedded=true&print=true&url="+url;


        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                getSupportActionBar().setTitle("Loading");
                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                    getSupportActionBar().setTitle(R.string.app_name);
                }
            }
        });

        webView.loadUrl(finalURL);
        //webView.loadUrl("https://drive.google.com/file/d/1A77-7-pInTaTgTq8reBeTpZ0BWxmGPKG/view");
    }
}
