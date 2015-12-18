package com.thompson.erin.hvacforms1221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class FormView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_view_layout);
        Button btnpacageview, btnsplitview;
        btnpacageview = (Button) findViewById(R.id.btnpacageview);
        btnsplitview = (Button) findViewById(R.id.btnsplitview);

        btnpacageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormView.this, viewPackageSystem.class);
                startActivity(intent);
            }
        });

        btnsplitview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormView.this, viewSplitSystem.class);
                startActivity(intent);
            }
        });


    }

}


