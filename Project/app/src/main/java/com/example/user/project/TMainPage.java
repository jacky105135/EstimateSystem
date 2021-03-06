package com.example.user.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class TMainPage extends AppCompatActivity {

    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_3 = "select_rec_listview1";
    Button btn1, btn2, btn3;
    TextView textView2;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tmain_page);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView2 = (TextView) findViewById(R.id.textView2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        // Bundle bb =this.getIntent().getExtras();
        //final String tname = bb.getString("name");
        SharedPreferences msg2 = getSharedPreferences("Tlogin_msg", Context.MODE_PRIVATE);
        final String tname = msg2.getString("name", "");
        textView2.setText(tname);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
                        request.addProperty("tname", tname);
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
                                String f = e.replace("; ", "ㄅ");
                                String g = f.replace(";", "");
                                //String f[] = e.split(";");
                                Intent intent = new Intent();
                               /* Bundle bundle = new Bundle();
                                bundle.putString("list", g);
                                intent.putExtras(bundle);*/
                                SharedPreferences msp1 = getSharedPreferences("self_rec", MODE_PRIVATE);
                                msp1.edit()
                                        .putString("list",g)
                                        .apply();
                                intent.setClass(TMainPage.this, TselfRec.class);
                                startActivity(intent);
                            } else {
                                Intent intent1 = new Intent();
                                intent1.setClass(TMainPage.this, TselfRec.class);
                                SharedPreferences msp1 = getSharedPreferences("self_rec", MODE_PRIVATE);
                                msp1.edit()
                                        .putString("list","")
                                        .apply();
                                startActivity(intent1);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TMainPage.this, Main7Activity.class);
                /*Bundle b = new Bundle();
                b.putString("id", tname);
                i.putExtras(b);*/
                SharedPreferences msp1 = getSharedPreferences("tname", MODE_PRIVATE);
                msp1.edit()
                        .putString("tname",tname)
                        .apply();
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TMainPage.this, StuGiveBackList.class);
                Bundle b = new Bundle();
                b.putString("id", tname);
                i.putExtras(b);
                startActivity(i);
            }
        });
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
                intent.setClass(TMainPage.this, Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(TMainPage.this, MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
