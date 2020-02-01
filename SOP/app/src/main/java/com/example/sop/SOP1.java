package com.example.sop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class SOP1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_sop1);

        final WebView webView=findViewById(R.id.webView);
        final ProgressBar progressBar=findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        String url="https://firebasestorage.googleapis.com/v0/b/dmss-3090b.appspot.com/o/SOP1.pdf?alt=media&token=c2fac807-561a-406a-841d-b953589544de";
        //String url="url";
        String finalURL="https://drive.google.com/viewerng/viewer?embedded=true&print=true&url="+url;


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVisibility(View.GONE);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                getSupportActionBar().setTitle("Loading");
                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                    getSupportActionBar().setTitle("SOP For Medical Record");
                }
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()");
                webView.setVisibility(View.VISIBLE);
            }


            public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
                try {
                    webView.stopLoading();
                } catch (Exception e) {
                }

                if (webView.canGoBack()) {
                    webView.goBack();
                }

                webView.loadUrl("about:blank");
                AlertDialog alertDialog = new AlertDialog.Builder(SOP1.this).create();
                alertDialog.setTitle("No internet connection was found!");
                alertDialog.setMessage("Cannot connect to the DMSS Server. Check your internet connection and try again.");
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        startActivity(getIntent());
                    }
                });

                alertDialog.show();
                super.onReceivedError(webView, errorCode, description, failingUrl);
            }

        });

        webView.loadUrl(finalURL);
        //webView.loadUrl("https://drive.google.com/file/d/1A77-7-pInTaTgTq8reBeTpZ0BWxmGPKG/view");
    }
}