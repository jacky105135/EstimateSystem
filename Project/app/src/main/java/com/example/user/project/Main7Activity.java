package com.example.user.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Main7Activity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    Button button;
    EditText stunum;
    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_3 = "select_listview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        button = (Button)findViewById(R.id.button);
        stunum = (EditText)findViewById(R.id.stunum);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Bundle b1 = this.getIntent().getExtras();
        SharedPreferences msg2 = getSharedPreferences("tname", Context.MODE_PRIVATE);
        final String Tname = msg2.getString("tname", "");


        SharedPreferences msp0 = getSharedPreferences("test", MODE_PRIVATE);
        msp0.edit()
                .putString("Tname",Tname)
                .apply();

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
                        request.addProperty("id",stunum.getText().toString());
                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                        envelope.dotNet = true;
                        envelope.setOutputSoapObject(request);
                        HttpTransportSE ht = new HttpTransportSE(URL);
                        try
                        {
                            ht.call(NAMESPACE+METHOD_USERNAME_3, envelope);
                            Object response = (Object) envelope.getResponse();
                            if (response!=null) {
                                String result = response.toString();
                                String pattern = "string=";
                                String b = result.replaceAll(pattern, "");
                                String c = b.replace("anyType{", "");
                                String d = c.replace(" }", "");
                                String e = d.replaceAll(",", "ㄅ");
                                String f = e.replace("; ","ㄅ");
                                String g = f.replace(";","");
                                //String f[] = e.split(";");
                                Intent intent = new Intent();
                                Bundle bundle = new Bundle();
                                bundle.putString("stunum", stunum.getText().toString());
                                bundle.putString("Tname", Tname);
                                bundle.putString("list", g);
                                intent.putExtras(bundle);
                                intent.setClass(Main7Activity.this, Main8Activity.class);
                                startActivity(intent);
                            }
                            else{
                                Intent intent1 = new Intent();
                                Bundle bundle = new Bundle();
                                bundle.putString("stunum", stunum.getText().toString());
                                bundle.putString("Tname", Tname);
                                bundle.putString("list", "");
                                intent1.putExtras(bundle);
                                intent1.setClass(Main7Activity.this, Main8Activity.class);
                                startActivity(intent1);
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                    }
                });
                t1.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.backtomain:
                Intent intent = new Intent();
                intent.setClass(Main7Activity.this, TMainPage.class);
                startActivity(intent);
                return true;

            case R.id.password:
                Intent intent1 = new Intent();
                intent1.setClass(Main7Activity.this,Main5Activity.class);
                startActivity(intent1);
                return true;

            case R.id.logout:
                Intent intent2 = new Intent();
                intent2.setClass(Main7Activity.this,MainActivity.class);
                startActivity(intent2);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}