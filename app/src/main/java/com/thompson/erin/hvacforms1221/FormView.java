package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FormView extends AppCompatActivity {

    TextView myTextView;
    Button btnAdd;
    private String text;
    private SharedPreference sharedPreference;
    Activity context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_view_layout);
        myTextView = (TextView) findViewById(R.id.tvContent);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        sharedPreference = new SharedPreference();
        text = sharedPreference.getValue(context);
        myTextView.setText(text);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
