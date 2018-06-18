package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Calendar;

public class Main16Activity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    Button btn_go;
    EditText ET,VT,VT2;
    TextView date,age,anal,operate,oldnew,gender,position,stuid,Tname,a,b,c,d,e,f,g;

    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_2 = "insertdata";
    private static final String METHOD_USERNAME_3 = "insertdata2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_go = (Button)findViewById(R.id.btn_go);

        date = (TextView)findViewById(R.id.date);

        final Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);

        date.setText(new StringBuilder()
        .append(yy).append("/").append(mm + 1).append("/").append(dd));

        age = (TextView)findViewById(R.id.age);
        anal = (TextView)findViewById(R.id.anal);
        operate = (TextView)findViewById(R.id.operate);
        oldnew = (TextView)findViewById(R.id.oldnew);
        gender = (TextView)findViewById(R.id.gender);
        position = (TextView)findViewById(R.id.position);
        stuid = (TextView)findViewById(R.id.stuid);
        Tname = (TextView)findViewById(R.id.Tname);
        a = (TextView)findViewById(R.id.a);
        b = (TextView)findViewById(R.id.b);
        c = (TextView)findViewById(R.id.c);
        d = (TextView)findViewById(R.id.d);
        e = (TextView)findViewById(R.id.e);
        f = (TextView)findViewById(R.id.f);
        g = (TextView)findViewById(R.id.g);

        ET = (EditText)findViewById(R.id.excellentthing);
        VT = (EditText)findViewById(R.id.view_time);
        VT2 = (EditText)findViewById(R.id.view_time2);

        Bundle b1 = this.getIntent().getExtras();

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
        String Tname1 = b1.getString("Tname");
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

        btn_go.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                t1.start();
                t2.start();
                Intent intent = new Intent();
                intent.setClass(Main16Activity.this , Main7Activity.class);
                startActivity(intent);
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
            request.addProperty("GB", ET.getText().toString());
            request.addProperty("OB_time", VT.getText().toString());
            request.addProperty("GB_time", VT2.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try {

                ht.call(NAMESPACE + METHOD_USERNAME_2, envelope);

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
            request.addProperty("GB", ET.getText().toString());
            request.addProperty("OB_time", VT.getText().toString());
            request.addProperty("GB_time", VT2.getText().toString());
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

            case R.id.backtomain:
                Intent intent2 = new Intent();
                intent2.setClass(Main16Activity.this, TMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(Main16Activity.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Main16Activity.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
