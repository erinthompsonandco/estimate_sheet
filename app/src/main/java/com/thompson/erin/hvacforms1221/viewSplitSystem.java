package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by Erin on 12/17/2015.
 */

    public class viewSplitSystem extends AppCompatActivity {

        private WebView mWebview ;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            mWebview  = new WebView(this);

            mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

            final Activity activity = this;

            mWebview.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                }
            });

            mWebview .loadUrl("https://docs.google.com/spreadsheets/d/1LkCg-tN_S-tIAYegtchD5mbwt6oWd6Xp7jWtmWpGlY8/pubhtml");
            setContentView(mWebview);

        }

    }