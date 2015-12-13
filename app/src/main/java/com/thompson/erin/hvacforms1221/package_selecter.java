package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This is a poor title for this java class. Aside from the
 * typo- we aren't selecting a package, we're choosing between package or split.
 * But what can you do?
 */
public class package_selecter extends Activity {
    Button btnPackage, btnSplit;
    TextView myTextView;
    private String text;
    private SharedPreference sharedPreference;
    Activity context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //change content view layout
        setContentView(R.layout.system_select);
        btnPackage = (Button) findViewById(R.id.btnPackage);
        btnSplit = (Button) findViewById(R.id.btnSplit);

        btnPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(package_selecter.this, packageUnitSend.class);
                startActivity(intent);

            }
        });

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(package_selecter.this, splitSend.class);
                startActivity(intent);

            }
        });

    }

}
