package com.example.user.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Text;

import javax.xml.transform.Templates;

public class StuMainPage extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView textView2;
    ImageButton imageButton;
    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_3 = "select_listview";
    private static final String METHOD_USERNAME_4 = "gettrend";

    private String stuid;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main_page);


        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);


       /* Bundle bb =this.getIntent().getExtras();
        final String stuname = bb.getString("name");
        stuid = bb.getString("stuid");*/
        SharedPreferences msg1 = getSharedPreferences("login_msg", Context.MODE_PRIVATE);
        String stuname = msg1.getString("name", "");
        stuid = msg1.getString("stuid", "");

        textView2.setText(stuname);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettrend();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getList();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                Bundle b2 = new Bundle();
                b2.putString("stuid", stuid);
                i.putExtras(b2);
                i.setClass(StuMainPage.this, Teacher_giveback_list.class);
                startActivity(i);
            }
        });
    }

    private void gettrend() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_4);
                request.addProperty("id", stuid);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE ht = new HttpTransportSE(URL);
                try {
                    ht.call(NAMESPACE + METHOD_USERNAME_4, envelope);
                    Object response = (Object) envelope.getResponse();
                    if (response != null) {
                        String result = response.toString();
                        String pattern = "string=";
                        String b = result.replaceAll(pattern, "");
                        String c = b.replace("anyType{", "");
                        String d = c.replace(" }", "");
                        String e = d.replaceAll("; ", "ㄅ");
                        String f = e.replace(";", "");
                        String g = f.replace("ㄅ", ",");
                        Intent i = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("response", g);
                        i.putExtras(bundle);
                        i.setClass(StuMainPage.this, Main14Activity.class);
                        startActivity(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

    }

    public void getList() {
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
                request.addProperty("id", stuid);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE ht = new HttpTransportSE(URL);
                try {
                    ht.call(NAMESPACE + METHOD_USERNAME_3, envelope);
                    Object response = (Object) envelope.getResponse();
                    if (response != null) {
                        String result = response.toString();
                        String pattern = "string=";
                        String b = result.replaceAll(pattern, "");
                        String c = b.replace("anyType{", "");
                        String d = c.replace(" }", "");
                        String e = d.replaceAll(",", "ㄅ");
                        String f = e.replaceAll("; ", "ㄅ");
                        String g = f.replace(";", "ㄅ");
                        String a = stuid;
                        Intent intent = new Intent();
                       /* Bundle bundle = new Bundle();
                        bundle.putString("id", a);
                        bundle.putString("result", g);
                        intent.putExtras(bundle);*/
                        SharedPreferences msp1 = getSharedPreferences("rec_list", MODE_PRIVATE);
                        msp1.edit()
                                .putString("id",a)
                                .putString("result",g)
                                .apply();
                        intent.setClass(StuMainPage.this, Main9Activity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent();
                        /*Bundle bundle = new Bundle();
                        bundle.putString("id", stuid);
                        bundle.putString("result", "");
                        intent.putExtras(bundle);*/
                        SharedPreferences msp1 = getSharedPreferences("rec_list", MODE_PRIVATE);
                        msp1.edit()
                                .putString("id",stuid)
                                .putString("result","")
                                .apply();
                        intent.setClass(StuMainPage.this, Main9Activity.class);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t4.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main13, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(StuMainPage.this, Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(StuMainPage.this, MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


