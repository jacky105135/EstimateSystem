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

public class Main15Activity extends AppCompatActivity {

    RadioGroup radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9,radioGroup10,radioGroup11;

    Button btn_go;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        btn_go = (Button)findViewById(R.id.btn_go);
        radioGroup5 = (RadioGroup)findViewById(R.id.radioGroup5);
        radioGroup6 = (RadioGroup)findViewById(R.id.radioGroup6);
        radioGroup7 = (RadioGroup)findViewById(R.id.radioGroup7);
        radioGroup8 = (RadioGroup)findViewById(R.id.radioGroup8);
        radioGroup9 = (RadioGroup)findViewById(R.id.radioGroup9);
        radioGroup10 = (RadioGroup)findViewById(R.id.radioGroup10);
        radioGroup11 = (RadioGroup)findViewById(R.id.radioGroup11);

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

        btn_go.setOnClickListener(new View.OnClickListener(){

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
                bundle.putString("a",a);
                bundle.putString("b",b);
                bundle.putString("c",c);
                bundle.putString("d",d);
                bundle.putString("e",e);
                bundle.putString("f",f);
                bundle.putString("g",g);
                intent.putExtras(bundle);
                intent.setClass(Main15Activity.this , Main16Activity.class);
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
                intent2.setClass(Main15Activity.this, TMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(Main15Activity.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Main15Activity.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
