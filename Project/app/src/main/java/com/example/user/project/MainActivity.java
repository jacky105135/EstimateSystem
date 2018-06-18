package com.example.user.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.SoapEnvelope;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView textview1,textview2;
    RadioGroup  radioGroup1;
    RadioButton radioButton1,radioButton2;
    private  Button button1;

    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_2 = "ChkLogin";
    private static final String METHOD_USERNAME_5 = "select_name";
    private static final String METHOD_USERNAME_3 = "select_listview";
    private static final  String SOAP_ACTION = "http://tempuri.org/ChkLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        button1 = (Button)findViewById(R.id.button1);
        radioGroup1 =(RadioGroup) findViewById(R.id.radiogroup1);
        radioButton1 =(RadioButton)findViewById(R.id.radiobutton1);
        radioButton2 =(RadioButton)findViewById(R.id.radiobutton2);
        textview1 = (TextView)findViewById(R.id.textview1);
        textview2 = (TextView)findViewById(R.id.textview2);

        textview1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , Main2Activity.class);
                startActivity(intent);
            }
        });

        textview2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , Main5Activity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
              if (radioButton1.isChecked() == true && radioButton2.isChecked() == false)
                  t1.start();
              if (radioButton2.isChecked() == true && radioButton1.isChecked() == false)
                  t2.start();
            }
        });
    }

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            Bundle myBundle = new Bundle();
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_2);
            request.addProperty("username", username.getText().toString());
            request.addProperty("password", password.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try
            {
                ht.call(SOAP_ACTION, envelope);
                SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
                boolean Flag = Boolean.parseBoolean(response.toString());
                if (Flag)
                {
                   t3.start();
                }else{
                    String a = "";
                    myBundle.putString("name",a);
                    Message msg = new Message();
                    msg.setData(myBundle);
                    Handler.sendMessage(msg);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    });

    private android.os.Handler Handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            String a = msg.getData().toString();
            String b = a.replace("Bundle[{name=","");
            String c = b.replace("}]","");
            password.setText(c);
        }
    };


    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            Bundle myBundle = new Bundle();
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_2);
            request.addProperty("username", username.getText().toString());
            request.addProperty("password", password.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try
            {
                ht.call(SOAP_ACTION, envelope);
                SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
                boolean Flag = Boolean.parseBoolean(response.toString());
                if (Flag)
                {
                    t4.start();
                }else{
                    String a = "";
                    myBundle.putString("name",a);
                    Message msg = new Message();
                    msg.setData(myBundle);
                    Handler.sendMessage(msg);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    });

    Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_5);
            request.addProperty("id",username.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try
            {
                ht.call(NAMESPACE+METHOD_USERNAME_5, envelope);
                SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
                String a = response.toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , TMainPage.class);
                SharedPreferences msp2 = getSharedPreferences("Tlogin_msg", MODE_PRIVATE);
                msp2.edit()
                        .putString("name",a)
                        .apply();
                //Bundle bundle = new Bundle();
                //bundle.putString("name", a);
                //intent.putExtras(bundle);
                startActivity(intent);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    });

    Thread t4 = new Thread(new Runnable() {
        @Override
        public void run() {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_5);
            request.addProperty("id",username.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try
            {
                ht.call(NAMESPACE+METHOD_USERNAME_5, envelope);
                SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
                String a = response.toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , StuMainPage.class);
                SharedPreferences msp1 = getSharedPreferences("login_msg", MODE_PRIVATE);
                msp1.edit()
                        .putString("name",a)
                        .putString("stuid",username.getText().toString())
                        .apply();
                //Bundle bundle = new Bundle();
                //bundle.putString("name", a);
                //bundle.putString("stuid",username.getText().toString());
                //intent.putExtras(bundle);
                startActivity(intent);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    });

}
