package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormOptions extends AppCompatActivity {
    EditText etPassword;
    Button btnSave;
    TextView tvContent;

    public static final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "AOP_PREFS_String";
    public String text;
    Activity context = this;
    private SharedPreference sharedPreference;
    ////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_options_layout);
        btnSave = (Button) findViewById(R.id.btnSave);
        tvContent = (TextView) findViewById(R.id.tvContent);
        etPassword = (EditText) findViewById(R.id.etPassword);
        sharedPreference = new SharedPreference();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                text = etPassword.getText().toString();
                sharedPreference.save(context, text);
            }

        });
    }
    public void save(Context context, String text) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //Get SharedPreferences instance
        editor = settings.edit(); //Get SharedPreferences.Editor instance by calling edit() method in SharedPreferences instance.

        editor.putString(PREFS_KEY, text); //3Store values by calling one of the putXXXX() methods.
        editor.commit(); //4Commit the editor object.
    }
}
