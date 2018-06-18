package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main12Activity extends AppCompatActivity {

    EditText agenum,analyze,operate;
    Button btn_go;
    android.support.v7.widget.Toolbar toolbar;
    RadioGroup radioGroup2,radioGroup3,radioGroup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        btn_go = (Button)findViewById(R.id.btn_go);

        agenum = (EditText)findViewById(R.id.agenum);
        analyze = (EditText)findViewById(R.id.analyze);
        operate = (EditText)findViewById(R.id.operate);

        radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup)findViewById(R.id.radioGroup3);
        radioGroup4 = (RadioGroup)findViewById(R.id.radioGroup4);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b1 = this.getIntent().getExtras();
        final String stuid = b1.getString("stunum");
        final String Tname = b1.getString("Tname");

        btn_go.setOnClickListener(new View.OnClickListener(){

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
                bundle.putString("stuid",stuid);
                bundle.putString("Tname",Tname);
                intent.putExtras(bundle);
                intent.setClass(Main12Activity.this , Main15Activity.class);
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
                intent2.setClass(Main12Activity.this, TMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(Main12Activity.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Main12Activity.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
