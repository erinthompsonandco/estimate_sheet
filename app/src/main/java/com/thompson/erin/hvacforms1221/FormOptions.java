package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormOptions extends AppCompatActivity {
    EditText etPassword;
    Button btnsubmit;
    TextView tvContent;

    /*RadioGroup rgsize = (RadioGroup) findViewById(R.id.rgsize);
    RadioButton rbsmall = (RadioButton) findViewById(R.id.rbsmall);
    RadioButton rbmedium = (RadioButton) findViewById(R.id.rbmedium);
    RadioButton rblarge = (RadioButton) findViewById(R.id.rblarge);
    RadioButton rbextralarge = (RadioButton) findViewById(R.id.rbexlarge);

*/
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
        Button btnsubmit = (Button) findViewById(R.id.btnsubmit);
        sharedPreference = new SharedPreference();
        final EditText etfieldname = (EditText) findViewById(R.id.etfieldname);
        etfieldname.setText(PreferenceManager.getDefaultSharedPreferences(context).getString("MYNAME", "               "));

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                String name = etfieldname.getText().toString();
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString("MYNAME", name).commit();

                Intent intent = new Intent(FormOptions.this, MainActivity.class);
                startActivity(intent);

            }


        });
    }
}
