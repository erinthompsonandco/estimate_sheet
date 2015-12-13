/*
package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

*/
/**
 * This should get data from out text fields and send it to our online database.
 *//*

public class packageSend extends AppCompatActivity {

    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static final String URL = "https://docs.google.com/forms/d/1zTLmqzLJMEURoN_HmtWy2x5dKE3xGfJNOIZnV43DJQI/formResponse";

    String myID;

    //lets setup the entry keys for all of our values to be inserted, shall we?
    public static final String name_key = "entry.578338806";
    public static final String address_key = "entry.25428138";
    public static final String number_key = "entry.1738177653";
    public static final String system_type_key = "entry.2086786052";
    public static final String multiple_system_key = "entry.234860996";
    public static final String airhandler_furnace_key = "entry.854500379";
    public static final String airhandler_furnace_btu_key = "entry.944744111";
    public static final String airhandler_furnace_furnace_diemension_key = "entry.1693525419";
    public static final String airhandler_furnace_Closet_dimesniosn_key = "entry.459971642";
    public static final String airhandler_furnace_Door_width_key = "entry.343583400";
    public static final String airhandler_furnace_platform_reutrn_air_key = "entry.29011687";
    public static final String airhandler_furnace_flu_pipe_type_and_size_key = "entry.1662628583";
    public static final String airhandler_furnace_coombustion_vents_key = "entry.525343522";
    public static final String airhandler_furnace_floor_condition_key = "entry.453033931";
    public static final String airhandler_furnace_condenstate_drain_key = "entry.829053444";
    public static final String airhandler_furnace_tonnage_key = "entry.1362706703";

    public static final String Existing_Condenser_pad_size_key = "entry.1250143046";
    public static final String Existing_Condenser_breaker_key = "entry.1324047795";
    public static final String Existing_Condenser_diconnect_ok_or_replace_key = "entry.224624073";
    public static final String Existing_Condenser_line_set_size_key = "entry.448721530";
    public static final String Existing_Condenser_apporx_length_key = "entry.69469737";


    public static final String duct_system_type_key = "entry.871306297";
    public static final String duct_system_size_of_return_duct_key = "entry.212486439";
    public static final String duct_system_size_of_return_grill_key = "entry.1004114173";
    public static final String duct_system_location_of_filter_key = "entry.171196451";
    public static final String duct_system_num_of_supply_vent_key = "entry.652733726";
    public static final String duct_system_Interested_in_test_and_seal_key = "entry.406053406";
    public static final String duct_system_Load_Calcs_Needed_key = "entry.2126434697";
    public static final String duct_system_total_meausered_return_air_key = "entry.1128862371";

    public static final String system_performance_problem_rooms_key = "entry.1856615127";
    public static final String system_performance_maintains_temp_key = "entry.721342041";
    public static final String system_performance_high_bills_key = "entry.952875645";
    public static final String system_performance_noisy_key = "entry.1745715904";
    public static final String system_performance_cycles_freq_key = "entry.2119540874";
    public static final String system_performance_change_thermostat_key = "entry.1721614779";

    public static final String other_problems_or_notes_key = "entry.270238685";
    public static final String sheets_validation_key = "entry.348458398";

    //   private Context context;
    private EditText nameEditText;
    private EditText numberEditText;
    private EditText adressEditText;
    private RadioGroup rgPlatformAir;
    private RadioButton rbPlatformAir;

    private RadioGroup rggaselect, rggas;
    private RadioButton rbnatural, rbpropane, rbgas, rbelect;
    private TextView tvgas;

    private RadioGroup rgCombustionVent;
    private RadioButton rbCombustionVent;

    private RadioGroup rgFluPipe;
    private RadioButton rbFluPipe;

    private RadioGroup rgFloorCondition;
    private RadioButton rbFloorCondition;

    private RadioGroup rgCondensateDrainCondition;
    private RadioButton rbCondensateDrainCondition;

    private RadioGroup rgExistingCondenserTonnage;
    private RadioButton rbExistingCondenserTonnage;

    private RadioGroup rgDisconent;
    private RadioButton rbDisconent;

    private RadioGroup rgDuctType;
    private RadioButton rbDuctType;

    private RadioGroup rgFilterLocation;
    private RadioButton rbFilterLocation;

    private RadioGroup rgTestSealInterest;
    private RadioButton rbTestSealInterest;

    private RadioGroup rgLoadCalcs;
    private RadioButton rbLoadCalcs;

    //system type
    private EditText etMultipleSystem;
    //air handler /furnace
    //btus
    private EditText airhandler_furnace_btu;
    private EditText airhandler_furnace_furnace_diemension;
    private EditText airhandler_furnace_Closet_dimesniosn;
    private EditText airhandler_furnace_Door_width;
    //platrofrm return air
    //flu pipe type and size
    // combustion_vents;
    //floor condition
    //condensate drain
    //exisitng condenser tonnage
    private EditText Existing_Condenser_pad_size;
    private EditText Existing_Condenser_breaker;
    //conderser disconnect
    private EditText Existing_Condenser_line_set_size;
    private EditText Existing_Condenser_apporx_length;
    //duct type
    private EditText duct_system_size_of_return_duct;
    private EditText duct_system_size_of_return_grill;
    //duct location of filter
    private EditText duct_system_num_of_supply_vent;
    //interested in test & seal
    //Load calculaions needed
    private EditText duct_system_total_meausered_return_air;
    // system performace - problem rooms
    //maintains temp
    //high bills
    //nolise
    //cycles freq
    //change thermostat
    private EditText other_problems_or_notes;
    String gas = "";


    public Button sendButton;
    //private RadioGroup rgMultiple;
    private CheckBox SystemType1, SystemType2, SystemType3;
    private CheckBox cbTemp, cbBills, cbNoisy, cbCycles, cbTherm, cbProblemRooms;
    private String user_id;
    private SharedPreference sharedPreference;
    Activity context = this;

    private RadioButton rbNoMultiple, rbYesMultiple;
    final String no_data = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //  dbHandler = new MyDBHandler(this, null, null, 1);
        setContentView(R.layout.package_unit_layout);
        sharedPreference = new SharedPreference();
        user_id = sharedPreference.getValue(context);

        //save the activity in a context variable to be used afterwards
        context = this;

        //Get references to UI elements in the layout
        sendButton = (Button) findViewById(R.id.btnSubmit);

        nameEditText = (EditText) findViewById(R.id.etName);
        numberEditText = (EditText) findViewById(R.id.etNumber);
        adressEditText = (EditText) findViewById(R.id.etAddress);

        airhandler_furnace_btu = (EditText) findViewById(R.id.etBTU);
        airhandler_furnace_furnace_diemension = (EditText) findViewById(R.id.etfurnaceDimen);
        airhandler_furnace_Closet_dimesniosn = (EditText) findViewById(R.id.etclosetDimen);
        airhandler_furnace_Door_width = (EditText) findViewById(R.id.etdoorWidth);
        Existing_Condenser_pad_size = (EditText) findViewById(R.id.etPadSize);
        Existing_Condenser_breaker = (EditText) findViewById(R.id.etBreaker);
        Existing_Condenser_line_set_size = (EditText) findViewById(R.id.etLineSetSize);
        Existing_Condenser_apporx_length = (EditText) findViewById(R.id.etApproxLength);
        duct_system_size_of_return_duct = (EditText) findViewById(R.id.etReturnDuctSize);
        duct_system_size_of_return_grill = (EditText) findViewById(R.id.etReturnGrillSize);
        duct_system_num_of_supply_vent = (EditText) findViewById(R.id.etSupplyVentNo);
        duct_system_total_meausered_return_air = (EditText) findViewById(R.id.etToatlMeasuredReturnAir);
        other_problems_or_notes = (EditText) findViewById(R.id.etOther);

        rggaselect = (RadioGroup) findViewById(R.id.rggaselect);
        rggas = (RadioGroup) findViewById(R.id.rggas);
        rbnatural = (RadioButton) findViewById(R.id.rbnatural);
        rbpropane = (RadioButton) findViewById(R.id.rbpropane);
        rbgas = (RadioButton) findViewById(R.id.rbgas);
        rbelect = (RadioButton) findViewById(R.id.rbelect);
        tvgas = (TextView) findViewById(R.id.tvgas);

        etMultipleSystem = (EditText) findViewById(R.id.etMultipleSystems);
        //set edittext to be invisible until the radio button is clicked & sets it visible.
        etMultipleSystem.setVisibility(View.GONE);
        rbpropane.setVisibility(View.GONE);
        rbnatural.setVisibility(View.GONE);
        tvgas.setVisibility(View.GONE);

        rbgas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                if (rbgas.isPressed()) {
                    gas += " Gas ";
                    tvgas.setVisibility(View.VISIBLE);
                    rbpropane.setVisibility(View.VISIBLE);
                    rbnatural.setVisibility(View.VISIBLE);
                }
            }
        });

        rbelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                if (rbgas.isPressed()) {
                    gas += " Electric ";
                    tvgas.setVisibility(View.GONE);
                    rbpropane.setVisibility(View.GONE);
                    rbnatural.setVisibility(View.GONE);
                }
            }
        });


        cbTemp = (CheckBox) findViewById(R.id.cbTemp);
        cbBills = (CheckBox) findViewById(R.id.cbBills);
        cbNoisy = (CheckBox) findViewById(R.id.cbNoisy);
        cbCycles = (CheckBox) findViewById(R.id.cbCycles);
        cbTherm = (CheckBox) findViewById(R.id.cbTherm);
        cbProblemRooms = (CheckBox) findViewById(R.id.cbProblemRooms);


        //rgMultiple = (RadioGroup) findViewById(R.id.rgMultiple);
        rbNoMultiple = (RadioButton) findViewById(R.id.rbNoMultiple);
        rbYesMultiple = (RadioButton) findViewById(R.id.rbYesMultiple);
        */
/*

        I really don't think we need multiple listeners, but I dunno.
         *//*

        rbYesMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rbYesMultiple.isPressed()) {
                    etMultipleSystem.setVisibility(View.VISIBLE);
                }

            }
        });
        rbNoMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbNoMultiple.isPressed()) {
                    etMultipleSystem.setVisibility(View.GONE);
                }

            }
        });


//TO update what you pass to the database, you have to add the xml entity, then get the string
        // from the user's input, then update the arraylist, then encode the string with its key
        // corresponspdonging to the correct box in the http form.
        //what a giant onclick-mess. :[


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                //Here we dismiss our keyboard after the user has clicked "submit."
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                //Setup required values here and set toast to let user know if they have not
                //filled out required value.
                */
/*
                if (TextUtils.isEmpty(emailEditText.getText().toString()) ||
                        TextUtils.isEmpty(subjectEditText.getText().toString()) ||
                        TextUtils.isEmpty(messageEditText.getText().toString())) {
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

                    return;
                }*//*

                */
/*
                //Veryify any data/strings that you want to verify
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.getText().toString()).matches()) {
                    Toast.makeText(context, "Please enter a valid email.", Toast.LENGTH_LONG).show();
                    return;
                }

int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
View radioButton = radioButtonGroup.findViewById(radioButtonID);
int idx = radioButtonGroup.indexOfChild(radioButton);

*//*


                //The below text is pivital for your radiogroups.
                rgPlatformAir = (RadioGroup) findViewById(R.id.rgPlatformAir);
                String platformAir = "";
                int selectedIdAirType = rgPlatformAir.getCheckedRadioButtonId();
                if (selectedIdAirType != -1) {
                    rbPlatformAir = (RadioButton) findViewById(selectedIdAirType);
                    String platformAir1 = rbPlatformAir.getText().toString();
                    platformAir += platformAir1;
                } else {

                    platformAir += "";
                }


                */
/*
                *
                *
                *
                *
                *
                * *//*

                int gasType = rggas.getCheckedRadioButtonId();
                if (gasType != -1) {
                    rbnatural = (RadioButton) findViewById(gasType);
                    String gastype = rbnatural.getText().toString();
                    gas += gastype;
                }


                */
/*
                *
                *
                *
                * *//*

                rgFluPipe = (RadioGroup) findViewById(R.id.rgFluPipe);
                String fluSize = "";
                int selectedIdFluSize = rgFluPipe.getCheckedRadioButtonId();
                if (selectedIdAirType != -1) {
                    rbFluPipe = (RadioButton) findViewById(selectedIdFluSize);
                    String fluSize1 = rbFluPipe.getText().toString();
                    fluSize += fluSize1;
                } else {

                    fluSize += "";
                }
                rgCombustionVent = (RadioGroup) findViewById(R.id.rgComubstionVent);
                String combustionVent = "";
                int selectedcombustionVent = rgCombustionVent.getCheckedRadioButtonId();
                if (selectedIdAirType != -1) {
                    rbCombustionVent = (RadioButton) findViewById(selectedcombustionVent);
                    String combustionVent1 = rbCombustionVent.getText().toString();
                    combustionVent += combustionVent1;
                } else {

                    combustionVent += "";
                }
                rgFloorCondition = (RadioGroup) findViewById(R.id.rgFloorCondition);
                String FloorCondition = "";
                int selectedIdFloorCond = rgFloorCondition.getCheckedRadioButtonId();
                if (selectedIdFloorCond != -1) {
                    rbFloorCondition = (RadioButton) findViewById(selectedIdFloorCond);
                    String FloorCondition1 = rbFloorCondition.getText().toString();
                    FloorCondition += FloorCondition1;
                } else {

                    FloorCondition += "";
                }

                rgCondensateDrainCondition = (RadioGroup) findViewById(R.id.rgCondensateDrainCondition);
                String CondensateDrainCondition = "";
                int selectedIdDrainCond = rgCondensateDrainCondition.getCheckedRadioButtonId();
                if (selectedIdDrainCond != -1) {
                    rbCondensateDrainCondition = (RadioButton) findViewById(selectedIdDrainCond);
                    String CondensateDrainCondition1 = rbCondensateDrainCondition.getText().toString();
                    CondensateDrainCondition += CondensateDrainCondition1;
                } else {

                    CondensateDrainCondition += "";
                }
                rgExistingCondenserTonnage = (RadioGroup) findViewById(R.id.rgExistingCondenserTonnage);
                String ExistingCondenserTonnage = "";
                int selectedIdCondenTonn = rgExistingCondenserTonnage.getCheckedRadioButtonId();
                if (selectedIdCondenTonn != -1) {
                    rbExistingCondenserTonnage = (RadioButton) findViewById(selectedIdCondenTonn);
                    String ExistingCondenserTonnage1 = rbExistingCondenserTonnage.getText().toString();
                    ExistingCondenserTonnage += ExistingCondenserTonnage1;
                } else {

                    ExistingCondenserTonnage += "";
                }

                rgDisconent = (RadioGroup) findViewById(R.id.rgDisconent);
                String Disconent = "";
                int selectedIdDiscon = rgDisconent.getCheckedRadioButtonId();
                if (selectedIdDiscon != -1) {
                    rbDisconent = (RadioButton) findViewById(selectedIdDiscon);
                    String Disconent1 = rbDisconent.getText().toString();
                    Disconent += Disconent1;
                } else {

                    Disconent += "";
                }


                rgDuctType = (RadioGroup) findViewById(R.id.rgDuctType);
                String DuctType = "";
                int selectedIdDuctType = rgDuctType.getCheckedRadioButtonId();
                if (selectedIdDuctType != -1) {
                    rbDuctType = (RadioButton) findViewById(selectedIdDuctType);
                    String DuctType1 = rbDuctType.getText().toString();
                    DuctType += DuctType1;
                } else {

                    DuctType += "";
                }
                rgFilterLocation = (RadioGroup) findViewById(R.id.rgFilterLocation);
                String FilterLocation = "";
                int selectedIdFilterLoc = rgFilterLocation.getCheckedRadioButtonId();
                if (selectedIdFilterLoc != -1) {
                    rbFilterLocation = (RadioButton) findViewById(selectedIdFilterLoc);
                    String FilterLocation1 = rbFilterLocation.getText().toString();
                    FilterLocation += FilterLocation1;
                } else {

                    FilterLocation += "";
                }

                rgTestSealInterest = (RadioGroup) findViewById(R.id.rgTestSealInterest);
                String TestSealInterest = "";
                int selectedIdTestSealInterest = rgTestSealInterest.getCheckedRadioButtonId();
                if (selectedIdTestSealInterest != -1) {
                    rbTestSealInterest = (RadioButton) findViewById(selectedIdTestSealInterest);
                    String TestSealInterest1 = rbTestSealInterest.getText().toString();
                    TestSealInterest += TestSealInterest1;
                } else {

                    TestSealInterest += "";
                }


                rgLoadCalcs = (RadioGroup) findViewById(R.id.rgLoadCalcs);
                String LoadCalcs = "";
                int selectedIdLoadCalcs = rgLoadCalcs.getCheckedRadioButtonId();
                if (selectedIdLoadCalcs != -1) {
                    rbLoadCalcs = (RadioButton) findViewById(selectedIdLoadCalcs);
                    String LoadCalcs1 = rbLoadCalcs.getText().toString();
                    LoadCalcs += LoadCalcs1;
                } else {

                    LoadCalcs += "";
                }


          */
/*      String whatType = "";
                if (SystemType1.isChecked()) {
                    whatType += "Type1";
                }
                if (SystemType2.isChecked()) {
                    whatType += "Type2";
                }
                if (SystemType3.isChecked()) {
                    whatType += "Type3";
                }*//*

                String perfTemp = "";
                String perfBills = "";
                String perfNoise = "";
                String perfCycles = "";
                String perfTherm = "";
                String perfRooms = "";


                if (cbTemp.isChecked()) {
                    perfTemp += "Maintains Temp ";
                }
                if (cbBills.isChecked()) {
                    perfBills += "High Bills ";
                }
                if (cbNoisy.isChecked()) {
                    perfNoise += "Noisy ";
                }
                if (cbCycles.isChecked()) {
                    perfCycles += "Cycles Frequently ";
                }
                if (cbTherm.isChecked()) {
                    perfTherm += "Change Thermostat ";
                }
                if (cbProblemRooms.isChecked()) {
                    perfRooms += "Problem rooms ";
                }
                //// TODO: 11/24/2015 get this id from other code/other activity and make sure
                //that it can stay saved inside app long-term.
                PostDataTask postDataTask = new PostDataTask();


                postDataTask.execute(URL,
                        nameEditText.getText().toString(),
                        numberEditText.getText().toString(),
                        adressEditText.getText().toString(),
                        no_data,
                        etMultipleSystem.getText().toString(),
                        no_data,
                        airhandler_furnace_btu.getText().toString(),
                        airhandler_furnace_furnace_diemension.getText().toString(),
                        airhandler_furnace_Closet_dimesniosn.getText().toString(),
                        airhandler_furnace_Door_width.getText().toString(),
                        platformAir,
                        fluSize,
                        combustionVent,
                        FloorCondition,
                        CondensateDrainCondition,
                        ExistingCondenserTonnage,
                        Existing_Condenser_pad_size.getText().toString(),
                        Existing_Condenser_breaker.getText().toString(),
                        Disconent,
                        Existing_Condenser_line_set_size.getText().toString(),
                        Existing_Condenser_apporx_length.getText().toString(),
                        DuctType,
                        duct_system_size_of_return_duct.getText().toString(),
                        duct_system_size_of_return_grill.getText().toString(),
                        FilterLocation,
                        duct_system_num_of_supply_vent.getText().toString(),
                        TestSealInterest,
                        LoadCalcs,
                        duct_system_total_meausered_return_air.getText().toString(),
                        perfRooms,
                        perfTemp,
                        perfBills,
                        perfNoise,
                        perfCycles,
                        perfTherm,
                        other_problems_or_notes.getText().toString(),
                        user_id

                );

            }
        });
    }

    //AsyncTask to send data as a http POST request
    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String name = contactData[1];
            String number = contactData[2];
            String address = contactData[3];
            String whatType = contactData[4];
            String multiple_system = contactData[5];
            String airhandler_furnace = contactData[6];
            String airhandler_furnace_btu = contactData[7];
            String airhandler_furnace_furnace_diemension = contactData[8];
            String airhandler_furnace_Closet_dimesniosn = contactData[9];
            String airhandler_furnace_Door_width = contactData[10];
            String airhandler_furnace_platform_reutrn_air = contactData[11];

            String airhandler_furnace_flu_pipe_type_and_size = contactData[12];
            String airhandler_furnace_coombustion_vents = contactData[13];
            String airhandler_furnace_floor_condition = contactData[14];
            String airhandler_furnace_condenstate_drain = contactData[15];
            String airhandler_furnace_tonnage = contactData[16];

            String Existing_Condenser_pad_size = contactData[17];
            String Existing_Condenser_breaker = contactData[18];
            String Existing_Condenser_diconnect_ok_or_replace = contactData[19];
            String Existing_Condenser_line_set_size = contactData[20];
            String Existing_Condenser_apporx_length = contactData[21];
            String duct_system_type = contactData[22];
            String duct_system_size_of_return_duct = contactData[23];
            String duct_system_size_of_return_grill = contactData[24];
            String duct_system_location_of_filter = contactData[25];
            String duct_system_num_of_supply_vent = contactData[26];
            String duct_system_Interested_in_test_and_seal = contactData[27];
            String duct_system_Load_Calcs_Needed = contactData[28];
            String duct_system_total_meausered_return_air = contactData[29];

            String system_performance_problem_rooms = contactData[30];
            String system_performance_maintains_temp = contactData[31];
            String system_performance_high_bills = contactData[32];
            String system_performance_noisy = contactData[33];
            String system_performance_cycles_freq = contactData[34];
            String system_performance_change_thermostat = contactData[35];

            String other_problems_or_notes = contactData[36];
            String my_user_id = contactData[36];

            String postBody = "";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = name_key + "=" + URLEncoder.encode(name, "UTF-8") +
                        "&" + number_key + "=" + URLEncoder.encode(number, "UTF-8") +
                        "&" + address_key + "=" + URLEncoder.encode(address, "UTF-8")
                        + "&" + system_type_key + "=" + URLEncoder.encode(whatType, "UTF-8")
                        + "&" + multiple_system_key + "=" + URLEncoder.encode(multiple_system, "UTF-8")

                        + "&" + airhandler_furnace_key + "=" + URLEncoder.encode(airhandler_furnace, "UTF-8")
                        + "&" + airhandler_furnace_btu_key + "=" + URLEncoder.encode(airhandler_furnace_btu, "UTF-8")
                        + "&" + airhandler_furnace_furnace_diemension_key + "=" + URLEncoder.encode(airhandler_furnace_furnace_diemension, "UTF-8")
                        + "&" + airhandler_furnace_Closet_dimesniosn_key + "=" + URLEncoder.encode(airhandler_furnace_Closet_dimesniosn, "UTF-8")
                        + "&" + airhandler_furnace_Door_width_key + "=" + URLEncoder.encode(airhandler_furnace_Door_width, "UTF-8")
                        + "&" + airhandler_furnace_platform_reutrn_air_key + "=" + URLEncoder.encode(airhandler_furnace_platform_reutrn_air, "UTF-8")

                        + "&" + airhandler_furnace_flu_pipe_type_and_size_key + "=" + URLEncoder.encode(airhandler_furnace_flu_pipe_type_and_size, "UTF-8")
                        + "&" + airhandler_furnace_coombustion_vents_key + "=" + URLEncoder.encode(airhandler_furnace_coombustion_vents, "UTF-8")
                        + "&" + airhandler_furnace_floor_condition_key + "=" + URLEncoder.encode(airhandler_furnace_floor_condition, "UTF-8")
                        + "&" + airhandler_furnace_condenstate_drain_key + "=" + URLEncoder.encode(airhandler_furnace_condenstate_drain, "UTF-8")
                        + "&" + airhandler_furnace_tonnage_key + "=" + URLEncoder.encode(airhandler_furnace_tonnage, "UTF-8")
                        + "&" + Existing_Condenser_pad_size_key + "=" + URLEncoder.encode(Existing_Condenser_pad_size, "UTF-8")
                        + "&" + Existing_Condenser_breaker_key + "=" + URLEncoder.encode(Existing_Condenser_breaker, "UTF-8")
                        + "&" + Existing_Condenser_diconnect_ok_or_replace_key + "=" + URLEncoder.encode(Existing_Condenser_diconnect_ok_or_replace, "UTF-8")
                        + "&" + Existing_Condenser_line_set_size_key + "=" + URLEncoder.encode(Existing_Condenser_line_set_size, "UTF-8")
                        + "&" + Existing_Condenser_apporx_length_key + "=" + URLEncoder.encode(Existing_Condenser_apporx_length, "UTF-8")
                        + "&" + duct_system_type_key + "=" + URLEncoder.encode(duct_system_type, "UTF-8")
                        + "&" + duct_system_size_of_return_duct_key + "=" + URLEncoder.encode(duct_system_size_of_return_duct, "UTF-8")
                        + "&" + duct_system_size_of_return_grill_key + "=" + URLEncoder.encode(duct_system_size_of_return_grill, "UTF-8")
                        + "&" + duct_system_location_of_filter_key + "=" + URLEncoder.encode(duct_system_location_of_filter, "UTF-8")
                        + "&" + duct_system_num_of_supply_vent_key + "=" + URLEncoder.encode(duct_system_num_of_supply_vent, "UTF-8")
                        + "&" + duct_system_Interested_in_test_and_seal_key + "=" + URLEncoder.encode(duct_system_Interested_in_test_and_seal, "UTF-8")
                        + "&" + duct_system_Load_Calcs_Needed_key + "=" + URLEncoder.encode(duct_system_Load_Calcs_Needed, "UTF-8")
                        + "&" + duct_system_total_meausered_return_air_key + "=" + URLEncoder.encode(duct_system_total_meausered_return_air, "UTF-8")
                        + "&" + system_performance_problem_rooms_key + "=" + URLEncoder.encode(system_performance_problem_rooms, "UTF-8")
                        + "&" + system_performance_maintains_temp_key + "=" + URLEncoder.encode(system_performance_maintains_temp, "UTF-8")
                        + "&" + system_performance_high_bills_key + "=" + URLEncoder.encode(system_performance_high_bills, "UTF-8")
                        + "&" + system_performance_noisy_key + "=" + URLEncoder.encode(system_performance_noisy, "UTF-8")
                        + "&" + system_performance_cycles_freq_key + "=" + URLEncoder.encode(system_performance_cycles_freq, "UTF-8")
                        + "&" + system_performance_change_thermostat_key + "=" + URLEncoder.encode(system_performance_change_thermostat, "UTF-8")
                        + "&" + other_problems_or_notes_key + "=" + URLEncoder.encode(other_problems_or_notes, "UTF-8")
                        + "&" + sheets_validation_key + "=" + URLEncoder.encode(my_user_id, "UTF-8");

            } catch (UnsupportedEncodingException ex) {
                result = false;
            }

            try

            {
                //Create OkHttpClient for sending POST? request
                OkHttpClient client = new OkHttpClient();
                //Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                //Send the request
                Response response = client.newCall(request).execute();
            } catch (
                    IOException exception
                    )

            {
                result = false;
            }

            return result;
        }


        protected void onPostExecute(Boolean result) {

            if (result) {
                Toast toast = Toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

            } else {
                */
/*
                toast.makeText(context, "There was some error in sending message. Please try again later.", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
                toast.show();
                *//*
-
                Toast toast = Toast.makeText(context, "There was some error in sending message. Please try again later", Toast.LENGTH_LONG);
                // toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                toast.show();
            }

        }
    }
}
*/
