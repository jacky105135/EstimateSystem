package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TChangeRec1 extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    EditText agenum,analyze,operate;
    String id,date,Tname,position,operation,ex1,ex2,ex3,ex4,ex5,ex6,ex7,GB,OB_Time,GB_Time,diagnose,name,gender,patient_sign,patient_age;
    RadioGroup radioGroup2,radioGroup3,radioGroup4;
    Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tchange_rec1);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bb =this.getIntent().getExtras();
        id = bb.getString("id");
        date = bb.getString("date");
        Tname = bb.getString("Tname");
        position = bb.getString("position");
        operation = bb.getString("operation");
        ex1 = bb.getString("ex1");
        ex2 = bb.getString("ex2");
        ex3 = bb.getString("ex3");
        ex4 = bb.getString("ex4");
        ex5 = bb.getString("ex5");
        ex6 = bb.getString("ex6");
        ex7 = bb.getString("ex7");
        GB = bb.getString("GB");
        OB_Time = bb.getString("OB_Time");
        GB_Time = bb.getString("GB_Time");
        diagnose = bb.getString("diagnose");
        name = bb.getString("name");
        gender = bb.getString("gender");
        patient_sign = bb.getString("patient_sign");
        patient_age = bb.getString("patient_age");

        radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        if (position.equals("門診")){
            radioGroup2.check(R.id.radiobutton1);
        }else if (position.equals("急診")){
            radioGroup2.check(R.id.radiobutton2);
        }else if (position.equals("病房")){
            radioGroup2.check(R.id.radiobutton3);
        }else if (position.equals("加護病房")){
            radioGroup2.check(R.id.radiobutton4);
        }else if (position.equals("其他")){
            radioGroup2.check(R.id.radiobutton5);
        }

        radioGroup3 = (RadioGroup)findViewById(R.id.radioGroup3);
        if (gender.equals("男")){
            radioGroup3.check(R.id.man);
        }else if (gender.equals("女")) {
            radioGroup3.check(R.id.woman);
        }

        radioGroup4 = (RadioGroup)findViewById(R.id.radioGroup4);
        if (patient_sign.equals("新病人")){
            radioGroup4.check(R.id.newpatient);
        }else if (patient_sign.equals("舊病人")) {
            radioGroup4.check(R.id.oldpatient);
        }

        agenum = (EditText)findViewById(R.id.agenum);
        agenum.setText(patient_age);

        analyze = (EditText)findViewById(R.id.analyze);
        analyze.setText(diagnose);

        operate = (EditText)findViewById(R.id.operate);
        operate.setText(operation);

        btn_go = (Button)findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = agenum.getText().toString();
                String b = analyze.getText().toString();
                String c = operate.getText().toString();
                String d = ((RadioButton)findViewById(radioGroup4.getCheckedRadioButtonId())).getText().toString();
                String e = ((RadioButton)findViewById(radioGroup3.getCheckedRadioButtonId())).getText().toString();
                String f = ((RadioButton)findViewById(radioGroup2.getCheckedRadioButtonId())).getText().toString();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("age",a);
                bundle.putString("anal",b);
                bundle.putString("operate",c);
                bundle.putString("oldnew",d);
                bundle.putString("gender",e);
                bundle.putString("position",f);
                bundle.putString("stuid",id);
                bundle.putString("Tname",Tname);
                bundle.putString("date",date);
                bundle.putString("ex1",ex1);
                bundle.putString("ex2",ex2);
                bundle.putString("ex3",ex3);
                bundle.putString("ex4",ex4);
                bundle.putString("ex5",ex5);
                bundle.putString("ex6",ex6);
                bundle.putString("ex7",ex7);
                bundle.putString("GB",GB);
                bundle.putString("OB_Time",OB_Time);
                bundle.putString("GB_Time",GB_Time);
                intent.putExtras(bundle);
                intent.setClass(TChangeRec1.this , tchange_rec2.class);
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

            case R.id.backtomain:
                Intent intent2 = new Intent();
                intent2.setClass(TChangeRec1.this, TMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(TChangeRec1.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(TChangeRec1.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
