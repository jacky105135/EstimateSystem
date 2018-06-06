package com.example.user.project;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class tChange_rec3 extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    TextView date,age,anal,operate,oldnew,gender,position,stuid,Tname,a,b,c,d,e,f,g;
    EditText excellentthing,view_time,view_time2;
    Button btn_go;
    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_2 = "updatedata";
    private static final String METHOD_USERNAME_3 = "updatedata2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_change_rec3);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        date = (TextView)findViewById(R.id.date);
        age = (TextView)findViewById(R.id.age);
        anal = (TextView)findViewById(R.id.anal);
        operate = (TextView)findViewById(R.id.operate);
        oldnew = (TextView)findViewById(R.id.oldnew);
        gender = (TextView)findViewById(R.id.gender);
        position = (TextView)findViewById(R.id.position);
        stuid = (TextView)findViewById(R.id.stuid);
        Tname = (TextView)findViewById(R.id.Tname);
        excellentthing = (EditText)findViewById(R.id.excellentthing);
        view_time = (EditText)findViewById(R.id.view_time);
        view_time2 = (EditText)findViewById(R.id.view_time2);
        a = (TextView)findViewById(R.id.a);
        b = (TextView)findViewById(R.id.b);
        c = (TextView)findViewById(R.id.c);
        d = (TextView)findViewById(R.id.d);
        e = (TextView)findViewById(R.id.e);
        f = (TextView)findViewById(R.id.f);
        g = (TextView)findViewById(R.id.g);

        Bundle b1 = this.getIntent().getExtras();
        String date1 = b1.getString("date");
        date.setText(date1);
        String age1 = b1.getString("age");
        age.setText(age1);
        String anal1 = b1.getString("anal");
        anal.setText(anal1);
        String operate1 = b1.getString("operate");
        operate.setText(operate1);
        String oldnew1 = b1.getString("oldnew");
        oldnew.setText(oldnew1);
        String gender1 = b1.getString("gender");
        gender.setText(gender1);
        String position1 = b1.getString("position");
        position.setText(position1);
        String stuid1 = b1.getString("stuid");
        stuid.setText(stuid1);
        final String Tname1 = b1.getString("Tname");
        Tname.setText(Tname1);
        String a1 = b1.getString("a");
        a.setText(a1);
        String b0 = b1.getString("b");
        b.setText(b0);
        String c1 = b1.getString("c");
        c.setText(c1);
        String d1 = b1.getString("d");
        d.setText(d1);
        String e1 = b1.getString("e");
        e.setText(e1);
        String f1 = b1.getString("f");
        f.setText(f1);
        String g1 = b1.getString("g");
        g.setText(g1);
        String GB = b1.getString("GB");
        excellentthing.setText(GB);
        String OB_Time = b1.getString("OB_Time");
        view_time.setText(OB_Time);
        String GB_Time = b1.getString("GB_Time");
        view_time2.setText(GB_Time);

        btn_go = (Button)findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.start();
                Intent i = new Intent(tChange_rec3.this,TMainPage.class);
                Bundle b = new Bundle();
                b.putString("name",Tname1);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_2);
            request.addProperty("id", stuid.getText().toString());
            request.addProperty("name", Tname.getText().toString());
            request.addProperty("date", date.getText().toString());
            request.addProperty("p_age", age.getText().toString());
            request.addProperty("position", position.getText().toString());
            request.addProperty("gender", gender.getText().toString());
            request.addProperty("p_sign", oldnew.getText().toString());
            request.addProperty("diagnose", anal.getText().toString());
            request.addProperty("operation", operate.getText().toString());
            request.addProperty("exercise1", a.getText().toString());
            request.addProperty("exercise2", b.getText().toString());
            request.addProperty("exercise3", c.getText().toString());
            request.addProperty("exercise4", d.getText().toString());
            request.addProperty("exercise5", e.getText().toString());
            request.addProperty("exercise6", f.getText().toString());
            request.addProperty("exercise7", g.getText().toString());
            request.addProperty("GB", excellentthing.getText().toString());
            request.addProperty("OB_time", view_time.getText().toString());
            request.addProperty("GB_time", view_time2.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try {

                ht.call(NAMESPACE + METHOD_USERNAME_2, envelope);
                t2.start();

            } catch (HttpResponseException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
            request.addProperty("id", stuid.getText().toString());
            request.addProperty("name", Tname.getText().toString());
            request.addProperty("date", date.getText().toString());
            request.addProperty("p_age", age.getText().toString());
            request.addProperty("position", position.getText().toString());
            request.addProperty("gender", gender.getText().toString());
            request.addProperty("p_sign", oldnew.getText().toString());
            request.addProperty("diagnose", anal.getText().toString());
            request.addProperty("operation", operate.getText().toString());
            request.addProperty("exercise1", a.getText().toString());
            request.addProperty("exercise2", b.getText().toString());
            request.addProperty("exercise3", c.getText().toString());
            request.addProperty("exercise4", d.getText().toString());
            request.addProperty("exercise5", e.getText().toString());
            request.addProperty("exercise6", f.getText().toString());
            request.addProperty("exercise7", g.getText().toString());
            request.addProperty("GB", excellentthing.getText().toString());
            request.addProperty("OB_time", view_time.getText().toString());
            request.addProperty("GB_time", view_time2.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try {

                ht.call(NAMESPACE + METHOD_USERNAME_3, envelope);

            } catch (HttpResponseException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });


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
                intent.setClass(tChange_rec3.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(tChange_rec3.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
