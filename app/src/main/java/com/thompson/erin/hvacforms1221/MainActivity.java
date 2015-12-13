package com.thompson.erin.hvacforms1221;
//Json https://spreadsheets.google.com/feeds/list/1NsLyf2hMBLTNd3FYeSieKh0c9swbcecVY_Zt8PIrGKk/1/public/basic?alt=json-in-script&callback=JSON_CALLBACK
//https://spreadsheets.google.com/feeds/list/1NsLyf2hMBLTNd3FYeSieKh0c9swbcecVY_Zt8PIrGKk/1/public/basic?alt=json
//eh... https://script.googleusercontent.com/macros/echo?user_content_key=v3yZrgMAtB0GLJx8M3A736XQqVkdqqTNBGKKzqk3WO82GPim6amB_Nz_kTzjrptvc509rfdUMOczSL5uNhUlj47UmR0xEK5HOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUfITFEal7vlYLCKKFIXKdGJ2fncv87P0TrthvdHv12d9Ejiz3MT4-nlhQpCAXCpBZ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnOptions = (Button) findViewById(R.id.btnOptions);
        Button btnSend = (Button) findViewById(R.id.btnSend);
        Button btnView = (Button) findViewById(R.id.btnView);

        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormOptions.class);
                startActivity(intent);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, package_selecter.class);
                startActivity(intent);
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
