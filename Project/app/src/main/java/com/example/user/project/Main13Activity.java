package com.example.user.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.SectionIndexer;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Text;

public class Main13Activity extends AppCompatActivity {

    private static final String TAG = "Main13Activity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    String id,date,Tname,position,operation,ex1,ex2,ex3,ex4,ex5,ex6,ex7,GB,OB_Time,GB_Time,diagnose,name,gender,patient_sign,patient_age;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        Log.d(TAG,"onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        final TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


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

        SharedPreferences msp0 = getSharedPreferences("result", MODE_PRIVATE);
        msp0.edit()
                .putString("date",date)
                .putString("Tname",Tname)
                .putString("position",position)
                .putString("operation",operation)
                .putString("ex1",ex1)
                .putString("ex2",ex2)
                .putString("ex3",ex3)
                .putString("ex4",ex4)
                .putString("ex5",ex5)
                .putString("ex6",ex6)
                .putString("ex7",ex7)
                .putString("GB",GB)
                .putString("OB_Time",OB_Time)
                .putString("GB_Time",GB_Time)
                .putString("diagnose",diagnose)
                .putString("name",name)
                .putString("gender",gender)
                .putString("patient_sign",patient_sign)
                .putString("patient_age",patient_age)
                .apply();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1_fragment(),"評分結果");
        adapter.addFragment(new tab2_fragment(),"回饋");
        adapter.addFragment(new tab3_fragment(),"綜合能力分析");
        viewPager.setAdapter(adapter);
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
                Intent intent2 = new Intent(Main13Activity.this,StuMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(Main13Activity.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Main13Activity.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
