package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
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

/**
 * This should get data from out text fields and send it to our online database.
 */
public class packageUnitSend extends AppCompatActivity {
    String filter_location = "";

    String natural_propane = "";
    public static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static final String URL = "https://docs.google.com/forms/d/1g2Zu8pcYI5zK9DoTZJ11iG1R2apLoS2O0xbDYn6BybY/formResponse";
    String tons = "";
    String ground_roof = "";
    Activity context = this;
    String nothing = "-";
    String gas_elect = "";
    String loadCalcs = "";

    //lets setup the entry keys for all of our values to be inserted, shall we?
    public static final String name_key = "entry.1025159044";
    public static final String address_key = "entry.1391652761";
    public static final String number_key = "entry.2110829785";
    public static final String email_key = "entry.242428598";
    public static final String gas_or_elect_key = "entry.620419816";
    public static final String natural_or_propane_key = "entry.2075134533";
    public static final String mobile_home_key = "entry.645324410";
    public static final String indoor_outdoor_furnace_key = "entry.2138546779";
    public static final String ground_key = "entry.81808171";
    public static final String pad_size_key = "entry.106897305";
    public static final String type_of_fittings_key = "entry.1788484860";
    public static final String room_to_expand_key = "entry.93577083";
    public static final String roof_tonnage_key = "entry.1849535176";
    public static final String roof_key = "entry.2096077937";
    public static final String type_of_roof_key = "entry.928402177";
    public static final String stand_size_key = "entry.418916137";
    public static final String elbows_key = "entry.868054496";
    public static final String down_shot_key = "entry.81411862";
    public static final String pitch_of_roof_key = "entry.1946473228";
    public static final String tonage_roof_key = "entry.1894010400";
    public static final String btu_roof_key = "entry.1494835687";
    public static final String Existing_Condenser_apporx_length_key = "entry.69469737";
    public static final String duct_system_type_key = "entry.676957110";
    public static final String duct_system_size_of_return_duct_key = "entry.1593206100";
    public static final String duct_system_size_of_return_grill_key = "entry.513365988";
    public static final String duct_system_location_of_filter_key = "entry.865014562";
    public static final String duct_system_num_of_supply_vent_key = "entry.926835558";
    public static final String duct_system_Load_Calcs_Needed_key = "entry.109826681";
    public static final String duct_system_Interested_in_test_and_seal_key = "entry.406053406";
    public static final String duct_system_total_meausered_return_air_key = "entry.2086369831";
    public static final String system_performance_problem_rooms_key = "entry.1021622503";
    public static final String system_performance_maintains_temp_key = "entry.975771468";
    public static final String system_performance_high_bills_key = "entry.1356467638";
    public static final String system_performance_noisy_key = "entry.1745715904";
    public static final String system_performance_cycles_freq_key = "entry.293620830";
    public static final String system_performance_change_thermostat_key = "entry.778756792";
    public static final String other_problems_or_notes_key = "entry.1818835172";
    public static final String field_service_name_key = "entry.703370180";
    public static final String price_to_replace_key = "entry.237023672";
    public static final String system_quality_key = "entry.1247684630";
    //Declare all textviews, if you want.
    /*
    TextView tvname;
    TextView tvaddress;
    TextView tvphone;
    TextView tvexisting_furnace;
    TextView tvbtu;
    TextView tvup_flow;
    TextView tvdown_flow;
    TextView tvfurnace_dimension;
    TextView tvcloset_dimension;
    TextView tvdoor_width;
    TextView tvplatform_return_air;
    TextView tvflu_pipe_type_size;
    TextView tvcomb_vents;
    TextView tvfloor_condition;
    TextView tvcondensate_drain;
    TextView tvexisting_condensor;
    TextView tvtons;
    TextView tvpad_size;
    TextView tvbreaker;
    TextView tvdiconnect;
    TextView tvline_set_size;
    TextView tvapprox_length;
    TextView tvduct_system;
    TextView tvduct_type;
    TextView tvsize_return_duct;
    TextView tvsize_return_grill;
    TextView rter_location;
    TextView tvsuplly_vent_no;
    TextView tvinterested_test_seal;
    TextView tvload_calcs;
    TextView tvmeasured_return_air;
    TextView tvsystem_performance;
    TextView tvproblem_rooms;
    TextView tvmaintains_temp;
    TextView tvhigh_bills;
    TextView tvnoisy;
    TextView tvcycles_freq;
    TextView tvthermostat;
    TextView tvother_problems;
*/


    EditText etdownshot, etpad_dimensionwidth, etpad_dimensionlength;
    EditText etelbowheight, etelbowwidth;
    //EditText etpad_dimensionwidthfoot_dimensionwidthfoot,etpad_dimensionwidthinch,etpad_dimensionlengthinch,etpad_dimensionlengthfoot;
    EditText etpad_dimensionwidthinch, etpad_dimensionwidthfoot, etpad_dimensionlengthinch, etpad_dimensionlengthfoot;

    EditText etstand_size;

    TextView tvpadHeightFoot, tvpadHeightInch, tvpadWidthInch, tvpadWidthFoot, tvgas;
    EditText etrooftype;

    // private NumberPicker npclosetHeightFoot, npclosetHeightInch, npclosetWidthInch, npclosetWidthFoot;
    // private NumberPicker nppadHeightFoot, nppadHeightInch, nppadWidthInch, nppadWidthFoot;

    //declare our edittexts from user_information_layout
    private EditText etname, etemail, etaddress, etphone;
    // declare our edittext from our ground_layout
    private RadioGroup rgroomtoexpand, rggaselect;
    private RadioButton rbroomtoexpandyes, rbroomtoexpandno, rbelect, rbgas, rbnatural, rbpropane;
    private RadioButton rbloadcalcsyes, rbloadcalcsno;
    private RadioGroup rggas, rgloadcalcs;
    // declare our edittext from our roof_layout

    //declare variables used everhwere
    private EditText etfittingtype;

    private EditText etbtu;


    public String problemrooms, temp, bills, noisy, cycles, thermostat;

    CheckBox cbproblemrooms, cbtemp, cbbills, cbnoisy, cbcycles, cbthermostat;


    EditText etsize_return_duct, etsize_return_grill, etfilter_location, etsuplly_vent_no, etinterested_test_seal, etpitch;
    EditText etload_calcs, etmeasured_return_air, etother_problems, etsize_return_grill_width;

    // initiazlize chcboxes

    /*
    * This can be misleading, as we are really only using one of these radiobuttons and getting the
    * ID and subsequently the text from it- WE AREN't USING BOTH RADIOBUTTONS.
    * */
    RadioGroup rgducttype, rgtons, rggroundroof, rgquality;

    RadioButton rbtons2, rbroof, rbground, rbducttype, rbbasic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.package_unit_layout1);
        TextView tvbasicinfo;
//Don't istantiate UI objects until after you set the view, dummy.
        TextView tvduct_system = (TextView) findViewById(R.id.tvduct_system);
        tvduct_system.setBackgroundResource(R.color.grayseperate);
        View extra_view = findViewById(R.id.extra_layout);
        View system_quality_price_layout = findViewById(R.id.system_quality_priace_layout);
        final View user_information = findViewById(R.id.user_information_layout);
        TextView tvnameuserinfo = (TextView) user_information.findViewById(R.id.tvnameuserinfo);
        final EditText etpricetoreplace = (EditText) user_information.findViewById(R.id.etpricetoreplace);

        tvnameuserinfo.setBackgroundResource(R.color.grayseperate);
        final View ground_layout = findViewById(R.id.ground_layout);
        final View roof_layout = findViewById(R.id.roof_layout);
        TextView tvroof = (TextView) roof_layout.findViewById(R.id.tvroof);
        tvroof.setBackgroundResource(R.color.grayseperate);
        TextView tvground = (TextView) ground_layout.findViewById(R.id.tvground);
        tvground.setBackgroundResource(R.color.grayseperate);
        etbtu = (EditText) findViewById(R.id.etbtu);
        TextView tvother_problems = (TextView) extra_view.findViewById(R.id.tvother_problems);
        tvother_problems.setBackgroundResource(R.color.grayseperate);

        tvbasicinfo = (TextView) findViewById(R.id.tvbasicinfo);
        TextView tvsystem_performance = (TextView) extra_view.findViewById(R.id.tvsystem_performance);
        tvsystem_performance.setBackgroundResource(R.color.grayseperate);
        tvbasicinfo.setBackgroundResource(R.color.grayseperate);
        RadioGroup rgfilterlocation;
        final RadioButton rbfilterlocationinside = (RadioButton) extra_view.findViewById(R.id.rbfilterlocationinside);
        final RadioButton rbfilterlocationgrill = (RadioButton) extra_view.findViewById(R.id.rbfilterlocationgrill);
        final RadioButton rbfilterlocationother = (RadioButton) extra_view.findViewById(R.id.rbfilterlocationother);
        etfilter_location = (EditText) extra_view.findViewById(R.id.etfilter_location);
        //final EditText etpricetoreplace = (EditText) user_information.findViewById(R.id.etpricetoreplace);

        rgloadcalcs = (RadioGroup) extra_view.findViewById(R.id.rgloadcalcs);
        rbloadcalcsyes = (RadioButton) extra_view.findViewById(R.id.rbloadcalcsyes);
        rbloadcalcsno = (RadioButton) extra_view.findViewById(R.id.rbloadcalcsno);

        rgquality = (RadioGroup) user_information.findViewById(R.id.rgquality);
        rbbasic = (RadioButton) user_information.findViewById(R.id.rbbasic);


        etfilter_location.setVisibility(View.GONE);

     /*   nppadHeightInch = (NumberPicker) ground_layout.findViewById(R.id.nppadHeightInch);
        nppadWidthInch = (NumberPicker) ground_layout.findViewById(R.id.nppadWidthInch);
        nppadWidthFoot = (NumberPicker) ground_layout.findViewById(R.id.nppadWidthFoot);
        nppadHeightFoot = (NumberPicker) ground_layout.findViewById(R.id.nppadHeightFoot);*/
        etfittingtype = (EditText) ground_layout.findViewById(R.id.etfittingtype);
        etrooftype = (EditText) roof_layout.findViewById(R.id.etrooftype);
        etelbowheight = (EditText) roof_layout.findViewById(R.id.etelbowheight);
        etelbowwidth = (EditText) roof_layout.findViewById(R.id.etelbowwidth);
        etdownshot = (EditText) roof_layout.findViewById(R.id.etdownshot);
        etpitch = (EditText) roof_layout.findViewById(R.id.etpitch);
        rgducttype = (RadioGroup) extra_view.findViewById(R.id.rgducttype);
        etsize_return_duct = (EditText) extra_view.findViewById(R.id.etsize_return_duct);
        etsize_return_grill_width = (EditText) extra_view.findViewById(R.id.etsize_return_grill_width);
        etsize_return_grill = (EditText) extra_view.findViewById(R.id.etsize_return_grill);
        etsuplly_vent_no = (EditText) extra_view.findViewById(R.id.etsuplly_vent_no);
        // etinterested_test_seal = (EditText) extra_view.findViewById(R.id.etinterested_test_seal);
        // etload_calcs = (EditText) extra_view.findViewById(R.id.etload_calcs);
        etmeasured_return_air = (EditText) extra_view.findViewById(R.id.etmeasured_return_air);
        etother_problems = (EditText) extra_view.findViewById(R.id.etother_problems);
        etstand_size = (EditText) roof_layout.findViewById(R.id.etstand_size);
        etpad_dimensionwidthfoot = (EditText) ground_layout.findViewById(R.id.etpad_dimensionwidthfoot);
        etpad_dimensionwidthinch = (EditText) ground_layout.findViewById(R.id.etpad_dimensionwidthinch);
        etpad_dimensionlengthinch = (EditText) ground_layout.findViewById(R.id.etpad_dimensionlengthinch);
        etpad_dimensionlengthfoot = (EditText) ground_layout.findViewById(R.id.etpad_dimensionlengthfoot);

        /*
        etpad_dimensionwidth = (EditText) roof_layout.findViewById(R.id.etpad_dimensionwidth);
        etpad_dimensionlength = (EditText) roof_layout.findViewById(R.id.etpad_dimensionlength);
*/
        // initiazlize chckboxes
        cbproblemrooms = (CheckBox) extra_view.findViewById(R.id.ecbproblem_rooms);
        cbtemp = (CheckBox) extra_view.findViewById(R.id.cbmaintains_temp);
        cbbills = (CheckBox) extra_view.findViewById(R.id.cbhigh_bills);
        cbnoisy = (CheckBox) extra_view.findViewById(R.id.cbnoisy);
        cbcycles = (CheckBox) extra_view.findViewById(R.id.cbcycles_freq);
        cbthermostat = (CheckBox) extra_view.findViewById(R.id.cbthermostat);
        rbroof = (RadioButton) findViewById(R.id.rbroof);

        Button btnSubmit = (Button) extra_view.findViewById(R.id.btnSubmit);
        etname = (EditText) user_information.findViewById(R.id.etname);
        etaddress = (EditText) user_information.findViewById(R.id.etaddress);
        etphone = (EditText) user_information.findViewById(R.id.etphone);
        etemail = (EditText) user_information.findViewById(R.id.etEmail);

        rgroomtoexpand = (RadioGroup) ground_layout.findViewById(R.id.rgroomtoexpand);
        rbroomtoexpandyes = (RadioButton) ground_layout.findViewById(R.id.rbroomtoexpandyes);
        rbroomtoexpandno = (RadioButton) ground_layout.findViewById(R.id.rbroomtoexpandno);
        rbgas = (RadioButton) findViewById(R.id.rbgas);
        rbelect = (RadioButton) findViewById(R.id.rbelect);
        rbnatural = (RadioButton) findViewById(R.id.rbnatural);
        rbpropane = (RadioButton) findViewById(R.id.rbpropane);
        rggaselect = (RadioGroup) findViewById(R.id.rggaselect);
        rggas = (RadioGroup) findViewById(R.id.rggas);
        rggroundroof = (RadioGroup) findViewById(R.id.rggroundroof);
        rbground = (RadioButton) findViewById(R.id.rbground);
        rbroof = (RadioButton) findViewById(R.id.rbroof);


        rgducttype = (RadioGroup) extra_view.findViewById(R.id.rgducttype);
        rgfilterlocation = (RadioGroup) extra_view.findViewById(R.id.rgfilterlocation);

        rgtons = (RadioGroup) findViewById(R.id.rgtons);

        rbtons2 = (RadioButton) findViewById(R.id.rbtons2);
/*
        nppadHeightInch.setMaxValue(11);
        nppadHeightInch.setMinValue(0);

        nppadWidthInch.setMaxValue(11);
        nppadWidthInch.setMinValue(0);

        nppadWidthFoot.setMaxValue(99);
        nppadWidthFoot.setMinValue(0);

        nppadHeightFoot.setMaxValue(99);
        nppadHeightFoot.setMinValue(0);


        tvpadHeightFoot = (TextView) findViewById(R.id.tvpadHeightFoot);
        tvpadHeightInch = (TextView) findViewById(R.id.tvpadHeightInch);
        tvpadWidthFoot = (TextView) findViewById(R.id.tvpadWidthFoot);
        tvpadWidthInch = (TextView) findViewById(R.id.tvpadWidthInch);/*
        /*
        * This is where our reusable view begins, so use caution and remember to call the
        * "extra_view" when instantiating variables that are inside it.
        * */

        tvgas = (TextView) findViewById(R.id.tvgas);
        final String foot = " Feet ";
        final String inches = " Inches ";


        rgfilterlocation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbfilterlocationgrill.getId() == checkedId) {
                    etfilter_location.setVisibility(View.GONE);
                    filter_location = rbfilterlocationgrill.getText().toString();
                }
                if (rbfilterlocationinside.getId() == checkedId) {
                    etfilter_location.setVisibility(View.GONE);
                    filter_location = rbfilterlocationinside.getText().toString();
                }
                if (rbfilterlocationother.getId() == checkedId) {
                    etfilter_location.setVisibility(View.VISIBLE);
                }
            }
        });


        rggroundroof.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbground.getId() == checkedId) {
                    ground_layout.setVisibility(View.VISIBLE);
                    roof_layout.setVisibility(View.GONE);
                    ground_roof = "Ground Unit";

                }
                if (rbroof.getId() == checkedId) {
                    roof_layout.setVisibility(View.VISIBLE);
                    ground_layout.setVisibility(View.GONE);
                    ground_roof = "Roof Unit";
                }
            }
        });
        tvgas.setVisibility(View.GONE);
        rggas.setVisibility(View.GONE);
        rbnatural.setVisibility(View.GONE);
        rbpropane.setVisibility(View.GONE);
        rggaselect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (rbgas.getId() == checkedId) {
                    gas_elect = " Gas/Electric ";
                    tvgas.setVisibility(View.VISIBLE);
                    rggas.setVisibility(View.VISIBLE);
                    rbnatural.setVisibility(View.VISIBLE);
                    rbpropane.setVisibility(View.VISIBLE);

                }
                if (rbelect.getId() == checkedId) {
                    gas_elect = " Heat Pump ";
                    tvgas.setVisibility(View.GONE);
                    rggas.setVisibility(View.GONE);
                    rbnatural.setVisibility(View.GONE);
                    rbpropane.setVisibility(View.GONE);

                }
            }
        });

        rgloadcalcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbloadcalcsyes.isPressed()) {
                    loadCalcs = " Yes ";

                }
                if (rbloadcalcsno.isPressed()) {

                    loadCalcs = " No ";

                }

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener()

                                     {
                                         @Override
                                         public void onClick(View w) {
                                             //Here we dismiss our keyboard after the user has clicked "submit."
                                             /*
                                             InputMethodManager inputManager = (InputMethodManager)
                                                     getSystemService(Context.INPUT_METHOD_SERVICE);

                                             inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                                                     InputMethodManager.HIDE_NOT_ALWAYS);
                                             */

                                             //Setup required values here and set toast to let user know if they have not
                                             //filled out required value.
                /*
                if (TextUtils.isEmpty(emailEditText.getText().toString()) ||
                        TextUtils.isEmpty(subjectEditText.getText().toString()) ||
                        TextUtils.isEmpty(messageEditText.getText().toString())) {
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                    return;
                }*/
                /*
                //Veryify any data/strings that you want to verify
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.getText().toString()).matches()) {
                    Toast.makeText(context, "Please enter a valid email.", Toast.LENGTH_LONG).show();
                    return;
                }
int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
View radioButton = radioButtonGroup.findViewById(radioButtonID);
int idx = radioButtonGroup.indexOfChild(radioButton);


*/
                                             //uncomment for a bit of data client-side verification. the returns make the code go back to the
                                             // submitbutton onclick listener, even though its return type is void- that shit totally works.

                                           /*//uncomment for user-side data validation
                                             if (ground_roof.equals("")) {
                                                 Toast toast = Toast.makeText(context, "Please indicate if it is a ground or roof unit.", Toast.LENGTH_LONG);
                                                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                 toast.show();
                                                 return;
                                             }


                                             if (gas_elect.equals("")) {
                                                 Toast toast = Toast.makeText(context, "Please indicate if it is gas or electric.", Toast.LENGTH_LONG);
                                                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                 toast.show();
                                                 return;
                                             }
                                            */


                                             String quality = "";
                                             rgquality = (RadioGroup) user_information.findViewById(R.id.rgquality);
                                             int selectedIdquality = rgquality.getCheckedRadioButtonId();
                                             if (selectedIdquality != -1) {
                                                 rbbasic = (RadioButton) findViewById(selectedIdquality);
                                                 String myquality = rbbasic.getText().toString();
                                                 quality += myquality;
                                             }


                                             int selectedIdloadcalc = rgloadcalcs.getCheckedRadioButtonId();
                                             if (selectedIdloadcalc != -1) {
                                                 rbloadcalcsyes = (RadioButton) findViewById(selectedIdloadcalc);
                                                 loadCalcs = rbloadcalcsyes.getText().toString();
                                             }


                                             rggas = (RadioGroup) findViewById(R.id.rggas);
                                             int gaselectID = rggas.getCheckedRadioButtonId();
                                             if (gaselectID != -1) {
                                                 rbnatural = (RadioButton) findViewById(gaselectID);
                                                 String gas_it = rbnatural.getText().toString();
                                                 natural_propane += gas_it;
                                             }
                                             String ducttype = "";
                                             int selectedIdducttypeType = rgducttype.getCheckedRadioButtonId();
                                             if (selectedIdducttypeType != -1) {
                                                 rbducttype = (RadioButton) findViewById(selectedIdducttypeType);
                                                 String ducttype_condition1 = rbducttype.getText().toString();
                                                 ducttype += ducttype_condition1;
                                             }


                                             rgtons = (RadioGroup) findViewById(R.id.rgtons);
                                             int selectedIdtons = rgtons.getCheckedRadioButtonId();
                                             if (selectedIdtons != -1) {
                                                 rbtons2 = (RadioButton) findViewById(selectedIdtons);
                                                 String mytons = rbtons2.getText().toString();
                                                 tons += mytons;
                                             }
                                             String roomtoexpand = "";
                                             rgroomtoexpand = (RadioGroup) findViewById(R.id.rgroomtoexpand);
                                             int selectedIdroomtoexpand = rgroomtoexpand.getCheckedRadioButtonId();
                                             if (selectedIdroomtoexpand != -1) {
                                                 rbroomtoexpandyes = (RadioButton) findViewById(selectedIdroomtoexpand);
                                                 String myroomtoexpand = rbroomtoexpandyes.getText().toString();
                                                 roomtoexpand += myroomtoexpand;
                                             }

                                             problemrooms = "";
                                             temp = "";
                                             bills = "";
                                             noisy = "";
                                             cycles = "";
                                             thermostat = "";

                                             if (cbproblemrooms.isChecked()) {
                                                 problemrooms += "Problem Rooms";
                                             }
                                             if (cbtemp.isChecked()) {
                                                 temp += "Maintains Temp ";
                                             }
                                             if (cbbills.isChecked()) {
                                                 bills += "High Bills";
                                             }
                                             if (cbnoisy.isChecked()) {
                                                 noisy += "Noisy";
                                             }
                                             if (cbcycles.isChecked()) {
                                                 cycles += "Cycles Freq. ";
                                             }
                                             if (cbthermostat.isChecked()) {
                                                 thermostat += "Thermostat";
                                             }
                                             //     EditText etpad_dimensionwidthfoot,etpad_dimensionwidthinch,etpad_dimensionlengthinch,etpad_dimensionlengthfoot;
                                             String pad_size = (etpad_dimensionwidthfoot.getText().toString() + " feet " + etpad_dimensionwidthinch.getText().toString() + " inches" + " by " + etpad_dimensionlengthfoot.getText().toString() + " feet " + etpad_dimensionlengthinch.getText().toString() + " inches");
                                             String elbows = (etelbowwidth.getText().toString() + " inches by " + etelbowheight.getText().toString() + " inches");
                                             String size_return_grill = (etsize_return_grill.getText().toString() + " inches by " + etsize_return_grill_width.getText().toString());
                                             // String field_service_name = "Wacky jack package";
                                             filter_location += etfilter_location.getText().toString();
                                             String field_service_name = PreferenceManager.getDefaultSharedPreferences(context).getString("MYNAME", "Tablet user has not entered name.");

                                             PostDataTask postDataTask = new PostDataTask();
                                             if (etname.getText().toString().equals("") || etaddress.getText().toString().equals("") || etphone.getText().toString().equals("")) {
                                                 Toast toast = Toast.makeText(context, "Please fill out name, address,and phone.", Toast.LENGTH_LONG);
                                                 //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                 toast.show();
                                                 return;
                                             }
                                             if (gas_elect.equals("")) {
                                                 Toast toast = Toast.makeText(context, "Please select H.P. or gas/electric.", Toast.LENGTH_LONG);
                                                 //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                 toast.show();
                                                 return;
                                             }
                                             if (ground_roof.equals("")) {
                                                 Toast toast = Toast.makeText(context, "Please select if its a ground or roof unit.", Toast.LENGTH_LONG);
                                                 //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                 toast.show();
                                                 return;
                                             }
                                             if (ground_roof.equals("Ground Unit")) {
                                                 if (etpad_dimensionwidthfoot.getText().toString().equals("") || etpad_dimensionlengthfoot.equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please fill out the pad size.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;

                                                 }
                                                 if (etfittingtype.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please fill out fitting type.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;

                                                 }

                                                 if (roomtoexpand.equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please choose if there is room to expand.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }


                                                 if (roomtoexpand.equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please choose if there is room to expand.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;

                                                 }
                                                 if (etbtu.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please choose BTUs.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;

                                                 }

                                                 if (tons.equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please choose the unit's tonnage.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;

                                                 }
                                             }
                                             if (ground_roof.equals("Roof Unit")) {
                                                 if (etrooftype.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please select a roof type.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }
                                                 if (etrooftype.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please select a roof type.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }
                                                 if (etstand_size.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please enter a stand size.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }

                                                 if (etelbowwidth.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please enter elbow height.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }

                                                 if (etdownshot.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please enter down shot.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }
                                                 if (etpitch.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please enter pitch of roof.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }
                                                 if (tons.equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please enter tons.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;
                                                 }
                                                 if (etbtu.getText().toString().equals("")) {
                                                     Toast toast = Toast.makeText(context, "Please enter btu's.", Toast.LENGTH_LONG);
                                                     //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                                                     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                     toast.show();
                                                     return;

                                                 }
                                             }

                                             postDataTask.execute(URL,
                                                     etname.getText().

                                                             toString(),//1

                                                     etaddress.getText().

                                                             toString(),//2

                                                     etphone.getText().

                                                             toString(),//3

                                                     etemail.getText().

                                                             toString(), //4 email

                                                     gas_elect,//5 gas_or_elect
                                                     natural_propane, //6 natural or propane
                                                     nothing, //7. mobile_home
                                                     nothing,  //     8. indoor_outdoor_furnace
                                                     ground_roof,  //     9. ground
                                                     pad_size,  //     10. pad_size
                                                     etfittingtype.getText().

                                                             toString(),//     11. type_of_fittings

                                                     roomtoexpand, //     12. room_to_expand
                                                     tons,    // 13. roof_tonnage
                                                     nothing, //     14. roof
                                                     etrooftype.getText().

                                                             toString(),  //     15. type_of_roof

                                                     etstand_size.getText().

                                                             toString(),  //     16. stand_size

                                                     elbows,   //     17. elbows
                                                     etdownshot.getText().

                                                             toString(),  //     18. down_shot

                                                     etpitch.getText().

                                                             toString(),  //     19. pitch_of_roof

                                                     nothing,  //     20. tonage_roof
                                                     etbtu.getText().

                                                             toString(), //     21. btu_roof

                                                     nothing,  //     22. Existing_Condenser_apporx_length
                                                     ducttype,  //     23. duct_system_type
                                                     etsize_return_duct.getText().

                                                             toString(), //     24. duct_system_size_of_return_duct

                                                     etsize_return_grill.getText().

                                                             toString(),  //     25. duct_system_size_of_return_grill

                                                     filter_location,//etfilter_location.getText().toString(), // etfilter_location.getText().toString(), //     26. duct_system_location_of_filter
                                                     etsuplly_vent_no.getText().

                                                             toString(), //     27. duct_system_num_of_supply_vent

                                                     loadCalcs,// etload_calcs.getText().toString(), //     28. duct_system_Load_Calcs_Needed
                                                     nothing, //     29. duct_system_Interested_in_test_and_seal
                                                     (etmeasured_return_air.getText().

                                                             toString()

                                                             + " CFM"),  //     30. duct_system_total_meausered_return_air
                                                     problemrooms,  //     31. system_performance_problem_rooms
                                                     temp,  //   32. system_performance_maintains_temp
                                                     bills,  //33. system_performance_high_bills
                                                     noisy,   //34. system_performance_noisy
                                                     cycles,  //35. system_performance_cycles_freq
                                                     thermostat,  //36. system_performance_change_thermostat
                                                     etother_problems.getText().toString(),//37. other_problems_or_notes
                                                     field_service_name,
                                                     etpricetoreplace.getText().toString(),
                                                     quality
                                             );
                                         }
                                     }

        );
    }

    //AsyncTask to send data as a http POST request
    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... formData) {
            Boolean result = true;
            String url = formData[0];
            String name = formData[1];
            String address = formData[2];
            String number = formData[3];
            String email = formData[4];
            String gas_or_elect = formData[5];
            String natural_or_propane = formData[6];
            String mobile_home = formData[7];
            String indoor_outdoor_furnace = formData[8];
            String ground = formData[9];
            String pad_size = formData[10];
            String type_of_fittings = formData[11];
            String room_to_expand = formData[12];
            String roof_tonnage = formData[13];
            String roof = formData[14];
            String type_of_roof = formData[15];
            String stand_size = formData[16];
            String elbows = formData[17];
            String down_shot = formData[18];
            String pitch_of_roof = formData[19];
            String tonage_roof = formData[20];
            String btu_roof = formData[21];
            String Existing_Condenser_apporx_length = formData[22];
            String duct_system_type = formData[23];
            String duct_system_size_of_return_duct = formData[24];
            String duct_system_size_of_return_grill = formData[25];
            String duct_system_location_of_filter = formData[26];
            String duct_system_num_of_supply_vent = formData[27];
            String duct_system_Load_Calcs_Needed = formData[28];
            String duct_system_Interested_in_test_and_seal = formData[29];
            String duct_system_total_meausered_return_air = formData[30];
            String system_performance_problem_rooms = formData[31];
            String system_performance_maintains_temp = formData[32];
            String system_performance_high_bills = formData[33];
            String system_performance_noisy = formData[34];
            String system_performance_cycles_freq = formData[35];
            String system_performance_change_thermostat = formData[36];
            String other_problems_or_notes = formData[37];
            String field_service_name = formData[38];
            String price_to_replace = formData[39];
            String system_quality = formData[40];
            String postBody = "";
            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = name_key + "=" + URLEncoder.encode(name, "UTF-8") +
                        "&" + address_key + "=" + URLEncoder.encode(address, "UTF-8") +
                        "&" + number_key + "=" + URLEncoder.encode(number, "UTF-8") +
                        "&" + email_key + "=" + URLEncoder.encode(email, "UTF-8") +
                        "&" + gas_or_elect_key + "=" + URLEncoder.encode(gas_or_elect, "UTF-8") +
                        "&" + natural_or_propane_key + "=" + URLEncoder.encode(natural_or_propane, "UTF-8") +
                        "&" + mobile_home_key + "=" + URLEncoder.encode(mobile_home, "UTF-8") +
                        "&" + indoor_outdoor_furnace_key + "=" + URLEncoder.encode(indoor_outdoor_furnace, "UTF-8") +
                        "&" + ground_key + "=" + URLEncoder.encode(ground, "UTF-8") +
                        "&" + pad_size_key + "=" + URLEncoder.encode(pad_size, "UTF-8") +
                        "&" + type_of_fittings_key + "=" + URLEncoder.encode(type_of_fittings, "UTF-8") +
                        "&" + room_to_expand_key + "=" + URLEncoder.encode(room_to_expand, "UTF-8") +
                        "&" + roof_tonnage_key + "=" + URLEncoder.encode(roof_tonnage, "UTF-8") +
                        "&" + roof_key + "=" + URLEncoder.encode(roof, "UTF-8") +
                        "&" + type_of_roof_key + "=" + URLEncoder.encode(type_of_roof, "UTF-8") +
                        "&" + stand_size_key + "=" + URLEncoder.encode(stand_size, "UTF-8") +
                        "&" + elbows_key + "=" + URLEncoder.encode(elbows, "UTF-8") +
                        "&" + down_shot_key + "=" + URLEncoder.encode(down_shot, "UTF-8") +
                        "&" + pitch_of_roof_key + "=" + URLEncoder.encode(pitch_of_roof, "UTF-8") +
                        "&" + tonage_roof_key + "=" + URLEncoder.encode(tonage_roof, "UTF-8") +
                        "&" + btu_roof_key + "=" + URLEncoder.encode(btu_roof, "UTF-8") +
                        "&" + Existing_Condenser_apporx_length_key + "=" + URLEncoder.encode(Existing_Condenser_apporx_length, "UTF-8") +
                        "&" + duct_system_type_key + "=" + URLEncoder.encode(duct_system_type, "UTF-8") +
                        "&" + duct_system_size_of_return_duct_key + "=" + URLEncoder.encode(duct_system_size_of_return_duct, "UTF-8") +
                        "&" + duct_system_size_of_return_grill_key + "=" + URLEncoder.encode(duct_system_size_of_return_grill, "UTF-8") +

                        "&" + duct_system_location_of_filter_key + "=" + URLEncoder.encode(duct_system_location_of_filter, "UTF-8") +
                        "&" + duct_system_num_of_supply_vent_key + "=" + URLEncoder.encode(duct_system_num_of_supply_vent, "UTF-8") +
                        "&" + duct_system_Load_Calcs_Needed_key + "=" + URLEncoder.encode(duct_system_Load_Calcs_Needed, "UTF-8") +
                        "&" + duct_system_Interested_in_test_and_seal_key + "=" + URLEncoder.encode(duct_system_Interested_in_test_and_seal, "UTF-8") +
                        "&" + duct_system_total_meausered_return_air_key + "=" + URLEncoder.encode(duct_system_total_meausered_return_air, "UTF-8") +
                        "&" + system_performance_problem_rooms_key + "=" + URLEncoder.encode(system_performance_problem_rooms, "UTF-8") +
                        "&" + system_performance_maintains_temp_key + "=" + URLEncoder.encode(system_performance_maintains_temp, "UTF-8") +
                        "&" + system_performance_high_bills_key + "=" + URLEncoder.encode(system_performance_high_bills, "UTF-8") +
                        "&" + system_performance_noisy_key + "=" + URLEncoder.encode(system_performance_noisy, "UTF-8") +
                        "&" + system_performance_cycles_freq_key + "=" + URLEncoder.encode(system_performance_cycles_freq, "UTF-8") +
                        "&" + system_performance_change_thermostat_key + "=" + URLEncoder.encode(system_performance_change_thermostat, "UTF-8") +
                        "&" + other_problems_or_notes_key + "=" + URLEncoder.encode(other_problems_or_notes, "UTF-8") +
                        "&" + field_service_name_key + "=" + URLEncoder.encode(field_service_name, "UTF-8") +
                        "&" + price_to_replace_key + "=" + URLEncoder.encode(price_to_replace, "UTF-8") +
                        "&" + system_quality_key + "=" + URLEncoder.encode(system_quality, "UTF-8");


                ;
                result = true;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
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
                    ) {
                result = false;
            }
            return result;
        }

        protected void onPostExecute(Boolean result) {
            if (result) {
                Toast toast = Toast.makeText(context, "Job information sent.", Toast.LENGTH_LONG);
                //  toast.makeText(context, "Message successfully sent!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            } else {
                Toast toast = Toast.makeText(context, "There was some error in sending message. Please try again later", Toast.LENGTH_LONG);
                // toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
            Intent intent = new Intent(packageUnitSend.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
