package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Main3Activity extends AppCompatActivity {

    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_3 = "SignUp";

    Button button1;
    AutoCompleteTextView editText3,editText4,editText5,editText6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button1 = (Button)findViewById(R.id.button1);
        editText3 = (AutoCompleteTextView) findViewById(R.id.editText3);
        editText4 = (AutoCompleteTextView) findViewById(R.id.editText4);
        editText5 = (AutoCompleteTextView) findViewById(R.id.editText5);
        editText6 = (AutoCompleteTextView) findViewById(R.id.editText6);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Thread thread1 = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try{
                            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
                            request.addProperty("name", editText3.getText().toString());
                            request.addProperty("password", editText5.getText().toString());
                            request.addProperty("Email", editText4.getText().toString());
                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                            envelope.dotNet = true;
                            envelope.setOutputSoapObject(request);
                            HttpTransportSE ht = new HttpTransportSE(URL);
                            ht.call(NAMESPACE+METHOD_USERNAME_3, envelope);

                            Intent intent = new Intent();
                            intent.setClass(Main3Activity.this , Main4Activity.class);
                            startActivity(intent);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                thread1.start();
            }

            });
    }
}
