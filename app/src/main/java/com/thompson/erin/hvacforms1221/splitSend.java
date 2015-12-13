package com.thompson.erin.hvacforms1221;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
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
public class splitSend extends AppCompatActivity {

    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //If you change your URL You'll have to change all entries. just so you know
    public static final String URL = "https://docs.google.com/forms/d/1UNMnp9ghKb17p89cervGDe7Pzb2cTNyFUj4xT43FEIM/formResponse";
    //If you change the URL you're obligated to change everything- be aware.
    //input element ids found from the live form page

    //lets setup the entry keys for all of our values to be inserted, shall we?
    public static final String name_key = "entry.157149672";
    public static final String address_key = "entry.1010143073";
    public static final String phone_key = "entry.610424818";
    // public static final String existing_furnace_key = "entry.1511876519";
    public static final String kbtu_key = "entry.602589398";
    public static final String up_flow_key = "entry.1406351811";
    public static final String down_flow_key = "entry.1708161375";
    public static final String furnace_dimension_key = "entry.450820439";
    public static final String closet_dimension_key = "entry.320993328";
    public static final String door_width_key = "entry.1517602566";
    public static final String platform_return_air_key = "entry.1771401370";
    public static final String flu_pipe_type_size_key = "entry.365672378";
    public static final String comb_vents_key = "entry.986694026";
    public static final String floor_condition_key = "entry.2012145590";
    public static final String condensate_drain_key = "entry.558582079";
    public static final String existing_condensor_key = "entry.80363832";
    public static final String tons_key = "entry.1860995146";
    public static final String pad_size_key = "entry.1046709638";
    public static final String breaker_key = "entry.1036334794";
    public static final String diconnect_key = "entry.428074047";
    public static final String line_set_size_key = "entry.662074321";
    public static final String approx_length_key = "entry.1142054493";
    //public static final String duct_system_key = "entry.1768610892";
    public static final String duct_type_key = "entry.1309241823";
    public static final String size_return_duct_key = "entry.1855044343";
    public static final String size_return_grill_key = "entry.490353232";
    public static final String filter_location_key = "entry.636529183";
    public static final String suplly_vent_no_key = "entry.946068431";
    public static final String interested_test_seal_key = "entry.1184702602";
    public static final String load_calcs_key = "entry.1397375405";
    public static final String measured_return_air_key = "entry.479993022";
    public static final String system_performance_key = "entry.1277726568";
    public static final String problem_rooms_key = "entry.766320572";
    public static final String maintains_temp_key = "entry.1649962924";
    public static final String high_bills_key = "entry.889302158";
    public static final String noisy_key = "entry.771122672";
    public static final String cycles_freq_key = "entry.1107875997";
    public static final String thermostat_key = "entry.1082695116";
    public static final String other_problems_key = "entry.1353810658";
    public static final String mobile_home_key = "entry.579179967";
    public static final String noData = " ";
    String disconnect = " ";
    String mobile = " ";
    String line_set_size = " ";
    String tons = " ";
    //Declare all textviews, if you want.
    /*
    TextView tvname;
    TextView tvaddress;
    TextView tvphone;
    TextView tvexisting_furnace;
    TextView tvkbtu;
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
    TextView tvfilter_location;
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
    TextView tvamps, tvindooroutdoorfurnace;
    EditText etdoor_dimensionwidth, approx_dimensionlengthinch, approx_dimensionlengthfoot;
    EditText etpad_dimensionwidthfoot, etpad_dimensionwidthinch, etpad_dimensionlengthinch, etpad_dimensionlengthfoot;

    //EditText etcloset_dimensionlength, etcloset_dimensiondepth;
    //EditText etclosetHeightFoot, etclosetWidthFoot
    //TextView tvpadHeightFoot, tvpadHeightInch, tvpadWidthInch, tvpadWidthFoot;

    //private NumberPicker npFurnaceHeightFoot, npFurnaceHeightInch, npFurnaceWidthInch, npFurnaceWidthFoot;
    private NumberPicker npapprox_lengthFoot, npapprox_lengthInch;
    //private NumberPicker npdoorwidthfoot, npdoorwidthinch;

    // private NumberPicker npclosetHeightFoot, npclosetHeightInch, npclosetWidthInch, npclosetWidthFoot;
    //private NumberPicker nppadHeightFoot, nppadHeightInch, nppadWidthInch, nppadWidthFoot;


    //declare our edittexts

    private EditText etname, etemail;
    private EditText etaddress;
    private EditText etphone;
    // private EditText etexisting_furnace;
    private EditText etkbtu;
    private EditText etup_flow;
    private EditText etdown_flow;
    // private EditText etfurnace_dimension;
    private TextView tvapprox_lengthFoot;
    private TextView tvapprox_lengthInch;

    private EditText etplatform_return_air;
    //private EditText etexisting_condensor;
    private EditText ettons;

    private EditText etbreaker;
    private EditText etline_set_size;
    //private EditText etapprox_length;

    private EditText etsize_return_duct;
    private EditText etsize_return_grill;
    private EditText etfilter_location;
    private EditText etsuplly_vent_no;
    private EditText etinterested_test_seal;
    private EditText etload_calcs;
    private EditText etmeasured_return_air;
    /*
    private EditText etsystem_performance;
    private EditText etproblem_rooms;
    private EditText etmaintains_temp;
    private EditText ethigh_bills;
    private EditText etnoisy;
    private EditText etcycles_freq;
    private EditText etthermostat;
    private TextView tvfurnace_dimension_width;
    private TextView tvfurnace_dimension_height;
    */
    private EditText etother_problems;

    private EditText etcloset_dimension_width;
    private EditText etcloset_dimension_length;


    private EditText etfurnace_dimension_width;
    private EditText etfurnace_dimension_length;

    public String problemrooms, temp, bills, noisy, cycles, thermostat;

    CheckBox cbproblemrooms, cbtemp, cbbills, cbnoisy, cbcycles, cbthermostat;

    Activity context = this;
    /*
    * This can be misleading, as we are really only using one of these radiobuttons and getting the
    * ID and subsequently the text from it- WE AREN't USING BOTH RADIOBUTTONS.
    * */

    RadioButton rbcombventsno, rbcombventsyes, rbdisconnectyes, rbdisconnectno, rbmobilehomeyes, rbmobilehomeno;
    RadioButton rbfloor_conditionyes, rbfloor_conditionno;
    RadioButton rbcondensate_drain_conditionyes, rbcondensate_drain_conditionno, rbducttype;
    RadioButton rbampsthirty, rbampssixty, rbindooroutdoorfurnaceout, rbindooroutdoorfurnacein, rbopt3, rbopt2, rbopt1, rblinesetsuction, rblinesetliquid, rbopt4;
    RadioGroup rgcombvents, rgfloor_condition, rgcondensate_drain_condition, rgducttype, rgliqsuct, rglineset;
    RadioGroup rgdisconnect, rgamps, rgindooroutdoorfurnace, rgmobilehome, rgtons;
    RadioButton rbtons2, rbtons2_5, rbtons3, rbtons3_5, rbtons4, rbtons5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //  dbHandler = new MyDBHandler(this, null, null, 1);

        setContentView(R.layout.splitsend_layout);
//Don't istantiate UI objects until after you set the view, dummy.


        //save the activity in a context variable to be used afterwards
        context = this;

        //Get references to UI elements in the layout
        View extra_view = findViewById(R.id.extra_layout);
        View user_information = findViewById(R.id.user_information_layout);


        Button btnSubmit = (Button) extra_view.findViewById(R.id.btnSubmit);


        approx_dimensionlengthinch = (EditText) findViewById(R.id.approx_dimensionlengthinch);
        approx_dimensionlengthfoot = (EditText) findViewById(R.id.approx_dimensionlengthfoot);
        etother_problems = (EditText) findViewById(R.id.etOther);
        etname = (EditText) user_information.findViewById(R.id.etname);
        etaddress = (EditText) user_information.findViewById(R.id.etaddress);
        etphone = (EditText) user_information.findViewById(R.id.etphone);
        etemail = (EditText) user_information.findViewById(R.id.etEmail);
        //existing furnace
        etkbtu = (EditText) findViewById(R.id.etkbtu);
        etup_flow = (EditText) findViewById(R.id.etup_flow);
        etdown_flow = (EditText) findViewById(R.id.etdown_flow);
//     ,,,etpad_dimensionlengthfoot;

        etpad_dimensionwidthfoot = (EditText) findViewById(R.id.etpad_dimensionwidthfoot);
        etpad_dimensionwidthinch = (EditText) findViewById(R.id.etpad_dimensionwidthinch);
        etpad_dimensionlengthinch = (EditText) findViewById(R.id.etpad_dimensionlengthinch);
        etpad_dimensionlengthfoot = (EditText) findViewById(R.id.etpad_dimensionlengthfoot);

        tvamps = (TextView) findViewById(R.id.tvamps);
        tvindooroutdoorfurnace = (TextView) findViewById(R.id.tvindooroutdoorfurnace);
     /*   tvpadHeightFoot = (TextView) findViewById(R.id.tvpadHeightFoot);
        tvpadHeightInch = (TextView) findViewById(R.id.tvpadHeightInch);
        tvpadWidthFoot = (TextView) findViewById(R.id.tvpadWidthFoot);
        tvpadWidthInch = (TextView) findViewById(R.id.tvpadWidthInch);*/


        //tvdoorwidthinch = (TextView) findViewById(R.id.tvdoorwidthinch);
        etdoor_dimensionwidth = (EditText) findViewById(R.id.etdoor_dimensionwidth);

        rbdisconnectyes = (RadioButton) findViewById(R.id.rbdisconnectyes);
        rbdisconnectno = (RadioButton) findViewById(R.id.rbdisconnectno);
        rgdisconnect = (RadioGroup) findViewById(R.id.rgdisconnect);

        rgmobilehome = (RadioGroup) findViewById(R.id.rgmobilehome);
        rgindooroutdoorfurnace = (RadioGroup) findViewById(R.id.rgindooroutdoorfurnace);
        rbindooroutdoorfurnacein = (RadioButton) findViewById(R.id.rbindooroutdoorfurnacein);


        rgtons = (RadioGroup) findViewById(R.id.rgtons);
        rbtons2 = (RadioButton) findViewById(R.id.rbtons2);
        rbtons2_5 = (RadioButton) findViewById(R.id.rbtons2_5);
        rbtons3 = (RadioButton) findViewById(R.id.rbtons2);
        rbtons3_5 = (RadioButton) findViewById(R.id.rbtons3_5);
        rbtons4 = (RadioButton) findViewById(R.id.rbtons2);
        rbtons5 = (RadioButton) findViewById(R.id.rbtons5);


        rbmobilehomeyes = (RadioButton) findViewById(R.id.rbmobilehomeyes);
        rbmobilehomeno = (RadioButton) findViewById(R.id.rbmobilehomeno);


        rbindooroutdoorfurnaceout = (RadioButton) findViewById(R.id.rbindooroutdoorfurnaceout);
        rbindooroutdoorfurnacein = (RadioButton) findViewById(R.id.rbindooroutdoorfurnacein);
        rbampsthirty = (RadioButton) findViewById(R.id.rbampsthirty);
        rbampssixty = (RadioButton) findViewById(R.id.rbampssixty);
        //rbindooroutdoorfurnaceout = (RadioButton) findViewById(R.id.rbindooroutdoorfurnaceout);
        //rbindooroutdoorfurnacein = (RadioButton) findViewById(R.id.rbindooroutdoorfurnacein);


        rbcombventsno = (RadioButton) findViewById(R.id.rbcombventsno);
        rbcombventsyes = (RadioButton) findViewById(R.id.rbcombventsyes);
        rgcombvents = (RadioGroup) findViewById(R.id.rgcombvents);
        rgamps = (RadioGroup) findViewById(R.id.rgamps);


        rbfloor_conditionno = (RadioButton) findViewById(R.id.rbfloor_coniditionno);
        rbfloor_conditionyes = (RadioButton) findViewById(R.id.rbfloor_coniditionyes);
        rgfloor_condition = (RadioGroup) findViewById(R.id.rgfloor_conidition);
        rgducttype = (RadioGroup) findViewById(R.id.rgducttype);

        rbcondensate_drain_conditionno = (RadioButton) findViewById(R.id.rbcondensate_drainno);
        rbcondensate_drain_conditionyes = (RadioButton) findViewById(R.id.rbcondensate_drainyes);
        rbopt4 = (RadioButton) findViewById(R.id.rbopt4);
        rbopt3 = (RadioButton) findViewById(R.id.rbopt3);
        rbopt2 = (RadioButton) findViewById(R.id.rbopt2);
        rbopt1 = (RadioButton) findViewById(R.id.rbopt1);
        rblinesetsuction = (RadioButton) findViewById(R.id.rblinesetsuction);
        rblinesetliquid = (RadioButton) findViewById(R.id.rblinesetliquid);

        rgcondensate_drain_condition = (RadioGroup) findViewById(R.id.rgcondensate_drain);
        rgdisconnect = (RadioGroup) findViewById(R.id.rgdisconnect);
        rgliqsuct = (RadioGroup) findViewById(R.id.rgliqsuct);
        rglineset = (RadioGroup) findViewById(R.id.rglineset);

        //tvdoorwidthfoot

        //setting the values so user can see where ft. and in. will go after they pick a number..
        final String foot = " ft.";
        final String inches = " in.";

      //  tvapprox_lengthFoot.setText(foot);
   /*     tvpadHeightFoot.setText(foot);
        tvpadWidthFoot.setText(foot);*/

        //tvapprox_lengthInch.setText(inches);
/*        tvpadHeightInch.setText(inches);
        tvpadWidthInch.setText(inches);*/

        //Iniditalize our Numberpickers


      /*  nppadHeightFoot = (NumberPicker) findViewById(R.id.nppadHeightFoot);
        nppadHeightInch = (NumberPicker) findViewById(R.id.nppadHeightInch);
*/
     /*   nppadWidthFoot = (NumberPicker) findViewById(R.id.nppadWidthFoot);
        nppadWidthInch = (NumberPicker) findViewById(R.id.nppadWidthInch);
*/


/*

        npdoorwidthfoot = (NumberPicker) findViewById(R.id.npdoorwidthfoot);
        npdoorwidthinch = (NumberPicker) findViewById(R.id.npdoorwidthinch);

        npdoorwidthfoot.setMaxValue(9);
        npdoorwidthfoot.setMinValue(0);

        npdoorwidthinch.setMaxValue(11);
        npdoorwidthinch.setMinValue(0);*/


        ///////////////
        /*
        npclosetHeightFoot.setMaxValue(99);
        npclosetHeightFoot.setMinValue(0);

        npclosetWidthInch.setMaxValue(11);
        npclosetWidthInch.setMinValue(0);

        npclosetWidthFoot.setMaxValue(99);
        npclosetWidthFoot.setMinValue(0);

        npclosetHeightInch.setMaxValue(11);
        npclosetHeightInch.setMinValue(0);
           */

  /*      nppadHeightInch.setMaxValue(99);
        nppadHeightInch.setMinValue(0);

        nppadWidthFoot.setMaxValue(99);
        nppadWidthFoot.setMinValue(0);

        nppadHeightFoot.setMaxValue(99);
        nppadHeightFoot.setMinValue(0);

        nppadWidthInch.setMaxValue(11);
        nppadWidthInch.setMinValue(0);*/
        ////////////////




        /*
        //The below crashes the app, so screw it for now.

        npFurnaceHeightFoot.setWrapSelectorWheel(false);
        npFurnaceHeightInch.setWrapSelectorWheel(false);
        npFurnaceWidthFoot.setWrapSelectorWheel(false);
        npFurnaceWidthInch.setWrapSelectorWheel(false);
*/
        etcloset_dimension_length = (EditText) findViewById(R.id.etcloset_dimensionlength);
        etcloset_dimension_width = (EditText) findViewById(R.id.etcloset_dimensionwidth);

        etfurnace_dimension_length = (EditText) findViewById(R.id.etfurnace_dimensionlength);
        etfurnace_dimension_width = (EditText) findViewById(R.id.etfurnace_dimensionwidth);


        etplatform_return_air = (EditText) findViewById(R.id.etplatform_return_air);
        final EditText etflu_pipe_type = (EditText) findViewById(R.id.etflu_pipe_type);
        final EditText etflu_pipe_size = (EditText) findViewById(R.id.etflu_pipe_size);
        //etflu_pipe_size etflu_pipe_type
        /////
        //////

        //existing_condensor
        //ettons = (EditText) findViewById(R.id.ettons);

        etbreaker = (EditText) findViewById(R.id.etbreaker);
        // etapprox_length = (EditText) findViewById(R.id.etapprox_length);
        //duct_system
        /*
        * This is where our reusable view begins, so use caution and remember to call the
        * "extra_view" when instantiating variables that are inside it.
        * */

        etsize_return_duct = (EditText) extra_view.findViewById(R.id.etsize_return_duct);
        etsize_return_grill = (EditText) extra_view.findViewById(R.id.etsize_return_grill);
        etfilter_location = (EditText) extra_view.findViewById(R.id.etfilter_location);
        etsuplly_vent_no = (EditText) extra_view.findViewById(R.id.etsuplly_vent_no);
       // etinterested_test_seal = (EditText) extra_view.findViewById(R.id.etinterested_test_seal);
        etload_calcs = (EditText) extra_view.findViewById(R.id.etload_calcs);
        etmeasured_return_air = (EditText) extra_view.findViewById(R.id.etmeasured_return_air);
        etother_problems = (EditText) extra_view.findViewById(R.id.etother_problems);
        // initiazlize chckboxes
        cbproblemrooms = (CheckBox) extra_view.findViewById(R.id.ecbproblem_rooms);
        cbtemp = (CheckBox) extra_view.findViewById(R.id.cbmaintains_temp);
        cbbills = (CheckBox) extra_view.findViewById(R.id.cbhigh_bills);
        cbnoisy = (CheckBox) extra_view.findViewById(R.id.cbnoisy);
        cbcycles = (CheckBox) extra_view.findViewById(R.id.cbcycles_freq);
        cbthermostat = (CheckBox) extra_view.findViewById(R.id.cbthermostat);
//TO update what you pass to the database, you have to add the xml entity, then get the string
        // from the user's input, then update the arraylist, then encode the string with its key
        // corresponspdonging to the correct box in the http form.
        //what a giant onclick-mess. :[


     /*   npdoorwidthfoot.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String inner_foot3 = npdoorwidthfoot.getValue() + foot;
                tvdoorwidthfoot.setText(inner_foot3);
            }
        });
        npdoorwidthinch.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String inner_inch4 = npdoorwidthinch.getValue() + inches;
                tvdoorwidthinch.setText(inner_inch4);
            }
        });
*/
        ////////////////////////////////
//        npclosetHeightFoot.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                String inner_foot2 = npclosetHeightFoot.getValue() + foot;
//                tvclosetHeightFoot.setText(inner_foot2);
//            }
//        });
//        npclosetHeightInch.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                String inner_inch2 = npclosetHeightInch.getValue() + inches;
//                tvclosetHeightInch.setText(inner_inch2);
//
//            }
//        });
//        npclosetWidthFoot.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                String inner_foot1 = npclosetWidthFoot.getValue() + foot;
//                tvclosetWidthFoot.setText(inner_foot1);
//
//            }
//        });
//        npclosetWidthInch.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                String inner_inch1 = npclosetWidthInch.getValue() + inches;
//                tvclosetWidthInch.setText(inner_inch1);
//
//            }
//        });


    /*    //////////////////////////////////
        nppadHeightFoot.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String inner_foot2 = nppadHeightFoot.getValue() + foot;
                tvpadHeightFoot.setText(inner_foot2);
            }
        });
        nppadHeightInch.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String inner_inch2 = nppadHeightInch.getValue() + inches;
                tvpadHeightInch.setText(inner_inch2);

            }
        });
        nppadWidthFoot.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String inner_foot1 = nppadWidthFoot.getValue() + foot;
                tvpadWidthFoot.setText(inner_foot1);
            }
        });
        nppadWidthInch.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String inner_inch1 = nppadWidthInch.getValue() + inches;
                tvpadWidthInch.setText(inner_inch1);

            }
        });*/
        tvamps.setVisibility(View.GONE);
        rbampsthirty.setVisibility(View.GONE);
        rbampssixty.setVisibility(View.GONE);

        rbopt4.setVisibility(View.GONE);
        rbopt3.setVisibility(View.GONE);
        rbopt2.setVisibility(View.GONE);
        rbopt1.setVisibility(View.GONE);


        rbindooroutdoorfurnaceout.setVisibility(View.GONE);
        rbindooroutdoorfurnacein.setVisibility(View.GONE);

        tvindooroutdoorfurnace.setVisibility(View.GONE);
        rblinesetliquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rblinesetliquid.isPressed()) {
                    // rgamps.setVisibility(View.VISIBLE);
                    line_set_size = "Liquid Line";
                    rbopt4.setVisibility(View.VISIBLE);
                    rbopt3.setVisibility(View.VISIBLE);
                    rbopt2.setVisibility(View.VISIBLE);
                    rbopt1.setVisibility(View.VISIBLE);
                    rbopt1.setText(Html.fromHtml("1</sup>/<sub>4</sub> Inch"));
                    rbopt2.setText(Html.fromHtml("5</sup>/<sub>16</sub> Inch"));
                    rbopt3.setText(Html.fromHtml("3</sup>/<sub>8</sub> Inch"));
                    rbopt4.setText(Html.fromHtml("1</sup>/<sub>2</sub> Inch"));
                }
            }
        });
        rblinesetsuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rblinesetsuction.isPressed()) {
                    // rgamps.setVisibility(View.VISIBLE);
                    line_set_size = "Suction Line";
                    rbopt4.setVisibility(View.VISIBLE);
                    rbopt3.setVisibility(View.VISIBLE);
                    rbopt2.setVisibility(View.VISIBLE);
                    rbopt1.setVisibility(View.VISIBLE);
                    rbopt1.setText(Html.fromHtml("1<sup> 1</sup>/<sub>8</sub> Inch"));
                    rbopt2.setText(Html.fromHtml("7</sup>/<sub>8</sub> Inch"));
                    rbopt3.setText(Html.fromHtml("3</sup>/<sub>4</sub> Inch"));
                    rbopt4.setText(Html.fromHtml("5</sup>/<sub>8</sub> Inch"));
                }
            }
        });


        rbmobilehomeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rbmobilehomeyes.isPressed()) {
                    // rgamps.setVisibility(View.VISIBLE);
                    mobile = "Mobile Home";
                    tvindooroutdoorfurnace.setVisibility(View.VISIBLE);
                    rbindooroutdoorfurnaceout.setVisibility(View.VISIBLE);
                    rbindooroutdoorfurnacein.setVisibility(View.VISIBLE);
                }
            }
        });
        rbmobilehomeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rbmobilehomeno.isPressed()) {
                    // rgamps.setVisibility(View.GONE);
                    tvindooroutdoorfurnace.setVisibility(View.GONE);
                    rbindooroutdoorfurnaceout.setVisibility(View.GONE);
                    rbindooroutdoorfurnacein.setVisibility(View.GONE);
                    mobile = "_";
                }
            }
        });

        rbdisconnectyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rbdisconnectyes.isPressed()) {
                    // rgamps.setVisibility(View.VISIBLE);
                    disconnect += "Replace";
                    tvamps.setVisibility(View.VISIBLE);
                    rbampsthirty.setVisibility(View.VISIBLE);
                    rbampssixty.setVisibility(View.VISIBLE);
                }
            }
        });
        rbdisconnectno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                if (rbdisconnectno.isPressed()) {
                    // rgamps.setVisibility(View.VISIBLE);
                    //resets our disconnect variable, so it doesn't crowd with repeated changed
                    //answers
                    disconnect = "";
                    tvamps.setVisibility(View.GONE);
                    rbampsthirty.setVisibility(View.GONE);
                    rbampssixty.setVisibility(View.GONE);
                }

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
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
                                             String line_set_size1;
                                             // rgliqsuct
                                             rgliqsuct = (RadioGroup) findViewById(R.id.rgliqsuct);
                                             int selectedIdrgliqsuct = rgliqsuct.getCheckedRadioButtonId();
                                             if (selectedIdrgliqsuct != -1) {
                                                 rbopt1 = (RadioButton) findViewById(selectedIdrgliqsuct);
                                                 line_set_size1 = rbopt1.getText().toString();
                                                 line_set_size += " " + line_set_size1;
                                             }


                                             rgtons = (RadioGroup) findViewById(R.id.rgtons);
                                             int selectedIdtons = rgtons.getCheckedRadioButtonId();
                                             if (selectedIdtons != -1) {
                                                 rbtons2 = (RadioButton) findViewById(selectedIdtons);
                                                 String mytons = rbtons2.getText().toString();
                                                 tons += mytons;
                                             }
                                             String combvents = "";
                                             int selectedCombAirType = rgcombvents.getCheckedRadioButtonId();
                                             if (selectedCombAirType != -1) {
                                                 rbcombventsyes = (RadioButton) findViewById(selectedCombAirType);
                                                 String combvents1 = rbcombventsyes.getText().toString();
                                                 combvents += combvents1;
                                             }
                                             String floor_condition = "";
                                             int selectedIdFloorType = rgfloor_condition.getCheckedRadioButtonId();
                                             if (selectedIdFloorType != -1) {
                                                 rbfloor_conditionyes = (RadioButton) findViewById(selectedIdFloorType);
                                                 String floor_condition1 = rbfloor_conditionyes.getText().toString();
                                                 floor_condition += floor_condition1;
                                             }
                                             String condensate_drain_condition = "";
                                             int selectedIdcondensate_drainType = rgcondensate_drain_condition.getCheckedRadioButtonId();
                                             if (selectedIdcondensate_drainType != -1) {
                                                 rbcondensate_drain_conditionyes = (RadioButton) findViewById(selectedIdcondensate_drainType);
                                                 String condensate_drain_condition1 = rbcondensate_drain_conditionyes.getText().toString();
                                                 condensate_drain_condition += condensate_drain_condition1;
                                             }
                                             //checks for
                                             int ampsType = rgamps.getCheckedRadioButtonId();
                                             if (ampsType != -1) {
                                                 rbampssixty = (RadioButton) findViewById(ampsType);
                                                 String amps1 = rbampssixty.getText().toString();
                                                 disconnect += amps1;
                                             }

//                    mobile = "Mobile Home";

                                             int mobilehomeint = rgindooroutdoorfurnace.getCheckedRadioButtonId();
                                             if (mobilehomeint != -1 && mobile.equals("Mobile Home")) {
                                                 rbindooroutdoorfurnacein = (RadioButton) findViewById(mobilehomeint);
                                                 String indooroutdoor = rbindooroutdoorfurnacein.getText().toString();
                                                 mobile += indooroutdoor;
                                             }

                                             //show our radio buttons that contain our amperage.
                                    /*
                                        rbamps.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View w) {

                                                     if (rbYesMultiple.isPressed()) {
                                                         etMultipleSystem.setVisibility(View.GONE);
                                                     }

                                                 }
                                             });
                                             */
                                             String ducttype = "";
                                             int selectedIdducttypeType = rgducttype.getCheckedRadioButtonId();
                                             if (selectedIdducttypeType != -1) {
                                                 rbducttype = (RadioButton) findViewById(selectedIdducttypeType);
                                                 String ducttype_condition1 = rbducttype.getText().toString();
                                                 ducttype += ducttype_condition1;
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
                                             String closet_dimension = (etcloset_dimension_length.getText().toString() + " by " + etcloset_dimension_width.getText().toString());
                                             String furnace_dimension = (etfurnace_dimension_length.getText().toString() + " by " + etfurnace_dimension_width.getText().toString());
                                             String door_width = ((etdoor_dimensionwidth.getText().toString()) + " inches");
                                             String approx_length = (approx_dimensionlengthfoot.getText().toString() + " by " + approx_dimensionlengthinch.getText().toString());
                                             //     ,,etpad_dimensionlengthinch,etpad_dimensionlengthfoot;

                                             String pad_size = (etpad_dimensionwidthfoot.getText().toString() + etpad_dimensionwidthinch.getText().toString() + " x " + etpad_dimensionlengthinch.getText().toString() + etpad_dimensionlengthfoot.getText().toString());
                                             String flu_pipe_type_size = (etflu_pipe_type.getText().toString() +"size "+ etflu_pipe_size.getText().toString()) + " inches";
                                             ////  11/24/2015 get this id from other code/other activity and make sure
                                             //that it can stay saved inside app long-term.

                                             PostDataTask postDataTask = new PostDataTask();


                                             postDataTask.execute(URL,
                                                     etname.getText().toString(),//1
                                                     etaddress.getText().toString(),//2
                                                     etphone.getText().toString(),//3
                                                     etkbtu.getText().toString(),//4
                                                     etup_flow.getText().toString(),//5
                                                     etdown_flow.getText().toString(),//6
                                                     furnace_dimension,//7
                                                     //  etfurnace_dimension_height.getText().toString(),
                                                     // etfurnace_dimension_width.getText().toString(),
                                                     closet_dimension,//8
                                                     // etcloset_dimension_height.getText().toString(),
                                                     // etcloset_dimension_width.getText().toString(),
                                                     door_width,//9
                                                     etplatform_return_air.getText().toString(),//10
                                                     flu_pipe_type_size,//11
                                                     combvents,//12
                                                     floor_condition,//13
                                                     condensate_drain_condition,//14
                                                     // etexisting_condensor.getText().toString(),/
                                                     tons,//15
                                                     pad_size,//16
                                                     etbreaker.getText().toString(),//17
                                                     disconnect,//18
                                                     line_set_size,//etline_set_size.getText().toString(),//19
                                                     approx_length, //20
                                                     ducttype, //21                                                                                                //21
                                                     etsize_return_duct.getText().toString(),//22
                                                     etsize_return_grill.getText().toString(),//23
                                                     etfilter_location.getText().toString(),//24
                                                     etsuplly_vent_no.getText().toString(),//25
                                                     noData,// etinterested_test_seal.getText().toString(),//26
                                                     etload_calcs.getText().toString(),//27
                                                     etmeasured_return_air.getText().toString(),//28
                                                     //   etsystem_performance.getText().toString(),
                                                     problemrooms,//29
                                                     temp,//30
                                                     bills,//31
                                                     noisy,//32
                                                     cycles,//33
                                                     thermostat,//34
                                                     etother_problems.getText().toString(),//35
                                                     mobile,
                                                     noData//36
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
            String etname = formData[1];
            String etaddress = formData[2];
            String etphone = formData[3];
            String etkbtu = formData[4];
            String etup_flow = formData[5];
            String etdown_flow = formData[6];
            //you need to concatonate height and weight
            String etfurnace_dimension = formData[7];
            //  String etfurnace_dimension_width = formData[8];
            String etcloset_dimension = formData[8];
            //  String etcloset_dimension_width = formData[10];
            String etdoor_width = formData[9];
            String etplatform_return_air = formData[10];
            String etflu_pipe_type_size = formData[11];
            String etcomb_vents = formData[12];
            String etfloor_condition = formData[13];
            String etcondensate_drain = formData[14];
            String ettons = formData[15];
            String etpad_size = formData[16];
            String etbreaker = formData[17];
            String etdiconnect = formData[18];
            String etline_set_size = formData[19];
            String etapprox_length = formData[20];
            String etduct_type = formData[21];
            String etsize_return_duct = formData[22];
            String etsize_return_grill = formData[23];
            String etfilter_location = formData[24];
            String etsuplly_vent_no = formData[25];
            String etinterested_test_seal = formData[26];
            String etload_calcs = formData[27];
            String etmeasured_return_air = formData[28];
            String problemrooms = formData[29];
            String temp = formData[30];
            String bills = formData[31];
            String noisy = formData[32];
            String cycles = formData[33];
            String thermostat = formData[34];
            String etother_problems = formData[35];
            String nothing = formData[36];
            String mobile_in = formData[37];
            String postBody = "";
            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = name_key + "=" + URLEncoder.encode(etname, "UTF-8") +
                        "&" + address_key + "=" + URLEncoder.encode(etaddress, "UTF-8") +
                        "&" + phone_key + "=" + URLEncoder.encode(etphone, "UTF-8") +
                        //  "&" + existing_furnace_key + "=" + URLEncoder.encode(existingFurnace, "UTF-8") +
                        "&" + kbtu_key + "=" + URLEncoder.encode(etkbtu, "UTF-8") +
                        "&" + up_flow_key + "=" + URLEncoder.encode(etup_flow, "UTF-8") +
                        "&" + down_flow_key + "=" + URLEncoder.encode(etdown_flow, "UTF-8") +
                        "&" + furnace_dimension_key + "=" + URLEncoder.encode(etfurnace_dimension, "UTF-8") +
                        "&" + closet_dimension_key + "=" + URLEncoder.encode(etcloset_dimension, "UTF-8") +
                        "&" + door_width_key + "=" + URLEncoder.encode(etdoor_width, "UTF-8") +
                        "&" + platform_return_air_key + "=" + URLEncoder.encode(etplatform_return_air, "UTF-8") +
                        "&" + flu_pipe_type_size_key + "=" + URLEncoder.encode(etflu_pipe_type_size, "UTF-8") +
                        "&" + comb_vents_key + "=" + URLEncoder.encode(etcomb_vents, "UTF-8") +
                        "&" + floor_condition_key + "=" + URLEncoder.encode(etfloor_condition, "UTF-8") +
                        "&" + condensate_drain_key + "=" + URLEncoder.encode(etcondensate_drain, "UTF-8") +
                        "&" + existing_condensor_key + "=" + URLEncoder.encode(nothing, "UTF-8") +
                        "&" + tons_key + "=" + URLEncoder.encode(ettons, "UTF-8") +
                        "&" + pad_size_key + "=" + URLEncoder.encode(etpad_size, "UTF-8") +
                        "&" + breaker_key + "=" + URLEncoder.encode(etbreaker, "UTF-8") +
                        "&" + diconnect_key + "=" + URLEncoder.encode(etdiconnect, "UTF-8") +
                        "&" + line_set_size_key + "=" + URLEncoder.encode(etline_set_size, "UTF-8") +
                        "&" + approx_length_key + "=" + URLEncoder.encode(etapprox_length, "UTF-8") +
                        "&" + duct_type_key + "=" + URLEncoder.encode(etduct_type, "UTF-8") +
                        "&" + size_return_duct_key + "=" + URLEncoder.encode(etsize_return_duct, "UTF-8") +
                        "&" + size_return_grill_key + "=" + URLEncoder.encode(etsize_return_grill, "UTF-8") +
                        "&" + filter_location_key + "=" + URLEncoder.encode(etfilter_location, "UTF-8") +
                        "&" + suplly_vent_no_key + "=" + URLEncoder.encode(etsuplly_vent_no, "UTF-8") +
                        "&" + interested_test_seal_key + "=" + URLEncoder.encode(etinterested_test_seal, "UTF-8") +
                        "&" + load_calcs_key + "=" + URLEncoder.encode(etload_calcs, "UTF-8") +
                        "&" + measured_return_air_key + "=" + URLEncoder.encode(etmeasured_return_air, "UTF-8") +
                        "&" + system_performance_key + "=" + URLEncoder.encode(nothing, "UTF-8") +
                        "&" + problem_rooms_key + "=" + URLEncoder.encode(problemrooms, "UTF-8") +
                        "&" + maintains_temp_key + "=" + URLEncoder.encode(temp, "UTF-8") +
                        "&" + high_bills_key + "=" + URLEncoder.encode(bills, "UTF-8") +
                        "&" + noisy_key + "=" + URLEncoder.encode(noisy, "UTF-8") +
                        "&" + cycles_freq_key + "=" + URLEncoder.encode(cycles, "UTF-8") +
                        "&" + thermostat_key + "=" + URLEncoder.encode(thermostat, "UTF-8") +
                        "&" + other_problems_key + "=" + URLEncoder.encode(etother_problems, "UTF-8") +
                        "&" + mobile_home_key + "=" + URLEncoder.encode(mobile_in, "UTF-8");
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
            Intent intent = new Intent(splitSend.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
