package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class tchange_rec2 extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    RadioGroup radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9,radioGroup10,radioGroup11;
    Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tchange_rec2);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bb =this.getIntent().getExtras();
        final String age = bb.getString("age");
        final String anal = bb.getString("anal");
        final String operate = bb.getString("operate");
        final String oldnew = bb.getString("oldnew");
        final String gender = bb.getString("gender");
        final String position = bb.getString("position");
        final String stuid = bb.getString("stuid");
        final String Tname = bb.getString("Tname");
        final String date = bb.getString("date");
        final String ex1 = bb.getString("ex1");
        final String ex2 = bb.getString("ex2");
        final String ex3 = bb.getString("ex3");
        final String ex4 = bb.getString("ex4");
        final String ex5 = bb.getString("ex5");
        final String ex6 = bb.getString("ex6");
        final String ex7 = bb.getString("ex7");
        final String GB = bb.getString("GB");
        final String OB_Time = bb.getString("OB_Time");
        final String GB_Time = bb.getString("GB_Time");

        radioGroup5 = (RadioGroup)findViewById(R.id.radioGroup5);
        switch (ex1) {
            case "未符要求":
                radioGroup5.check(R.id.one1);
                break;
            case "達到要求":
                radioGroup5.check(R.id.two1);
                break;
            case "優秀":
                radioGroup5.check(R.id.three1);
                break;
            case "N/A*":
                radioGroup5.check(R.id.four1);
                break;
        }

        radioGroup6 = (RadioGroup)findViewById(R.id.radioGroup6);
        switch (ex2) {
            case "未符要求":
                radioGroup6.check(R.id.one2);
                break;
            case "達到要求":
                radioGroup6.check(R.id.two2);
                break;
            case "優秀":
                radioGroup6.check(R.id.three2);
                break;
            case "N/A*":
                radioGroup6.check(R.id.four2);
                break;
        }
        radioGroup7 = (RadioGroup)findViewById(R.id.radioGroup7);
        switch (ex3) {
            case "未符要求":
                radioGroup7.check(R.id.one3);
                break;
            case "達到要求":
                radioGroup7.check(R.id.two3);
                break;
            case "優秀":
                radioGroup7.check(R.id.three3);
                break;
            case "N/A*":
                radioGroup7.check(R.id.four3);
                break;
        }
        radioGroup8 = (RadioGroup)findViewById(R.id.radioGroup8);
        switch (ex4) {
            case "未符要求":
                radioGroup8.check(R.id.one4);
                break;
            case "達到要求":
                radioGroup8.check(R.id.two4);
                break;
            case "優秀":
                radioGroup8.check(R.id.three4);
                break;
            case "N/A*":
                radioGroup8.check(R.id.four4);
                break;
        }
        radioGroup9 = (RadioGroup)findViewById(R.id.radioGroup9);
        switch (ex5) {
            case "未符要求":
                radioGroup9.check(R.id.one5);
                break;
            case "達到要求":
                radioGroup9.check(R.id.two5);
                break;
            case "優秀":
                radioGroup9.check(R.id.three5);
                break;
            case "N/A*":
                radioGroup9.check(R.id.four5);
                break;
        }
        radioGroup10 = (RadioGroup)findViewById(R.id.radioGroup10);
        switch (ex6) {
            case "未符要求":
                radioGroup10.check(R.id.one6);
                break;
            case "達到要求":
                radioGroup10.check(R.id.two6);
                break;
            case "優秀":
                radioGroup10.check(R.id.three6);
                break;
            case "N/A*":
                radioGroup10.check(R.id.four6);
                break;
        }
        radioGroup11 = (RadioGroup)findViewById(R.id.radioGroup11);
        switch (ex7) {
            case "未符要求":
                radioGroup11.check(R.id.one7);
                break;
            case "達到要求":
                radioGroup11.check(R.id.two7);
                break;
            case "優秀":
                radioGroup11.check(R.id.three7);
                break;
            case "N/A*":
                radioGroup11.check(R.id.four7);
                break;
        }

        btn_go = (Button)findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = ((RadioButton)findViewById(radioGroup5.getCheckedRadioButtonId())).getText().toString();
                String b = ((RadioButton)findViewById(radioGroup6.getCheckedRadioButtonId())).getText().toString();
                String c = ((RadioButton)findViewById(radioGroup7.getCheckedRadioButtonId())).getText().toString();
                String d = ((RadioButton)findViewById(radioGroup8.getCheckedRadioButtonId())).getText().toString();
                String e = ((RadioButton)findViewById(radioGroup9.getCheckedRadioButtonId())).getText().toString();
                String f = ((RadioButton)findViewById(radioGroup10.getCheckedRadioButtonId())).getText().toString();
                String g = ((RadioButton)findViewById(radioGroup11.getCheckedRadioButtonId())).getText().toString();

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("age",age);
                bundle.putString("anal",anal);
                bundle.putString("operate",operate);
                bundle.putString("oldnew",oldnew);
                bundle.putString("gender",gender);
                bundle.putString("position",position);
                bundle.putString("stuid",stuid);
                bundle.putString("Tname",Tname);
                bundle.putString("date",date);
                bundle.putString("GB",GB);
                bundle.putString("OB_Time",OB_Time);
                bundle.putString("GB_Time",GB_Time);
                bundle.putString("a",a);
                bundle.putString("b",b);
                bundle.putString("c",c);
                bundle.putString("d",d);
                bundle.putString("e",e);
                bundle.putString("f",f);
                bundle.putString("g",g);
                intent.putExtras(bundle);
                intent.setClass(tchange_rec2.this , tChange_rec3.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(tchange_rec2.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(tchange_rec2.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
