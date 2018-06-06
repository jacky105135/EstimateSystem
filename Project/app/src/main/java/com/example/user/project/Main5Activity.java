package com.example.user.project;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Main5Activity extends AppCompatActivity {

    TextView textView1;
    Button button1;
    EditText id,id_num;

    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_4 = "ChkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textView1 = (TextView)findViewById(R.id.textview1);
        button1 = (Button)findViewById(R.id.button1);
        id = (EditText)findViewById(R.id.id);
        id_num = (EditText)findViewById(R.id.id_num);
        button1.setOnClickListener(new View.OnClickListener(){



            @Override
            public void
            onClick(View v) {
                t1.start();
            }

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Bundle myBundle = new Bundle();
                        try {
                            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_4);
                            request.addProperty("id", id.getText().toString());
                            request.addProperty("id_num", id_num.getText().toString());
                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                            envelope.setOutputSoapObject(request);
                            HttpTransportSE ht = new HttpTransportSE(URL);
                            envelope.dotNet = true;
                            ht.call(NAMESPACE + METHOD_USERNAME_4, envelope);
                            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
                            boolean success = Boolean.parseBoolean(response.toString());

                            if (success) {
                                String id2 = id.getText().toString();
                                Intent intent = new Intent();
                                intent.setClass(Main5Activity.this, Main6Activity.class);

                                Bundle bundle = new Bundle();
                                bundle.putString("id",id2);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }else{
                                String a = "";
                                myBundle.putString("name",a);
                                Message msg = new Message();
                                msg.setData(myBundle);
                                Handler.sendMessage(msg);
                            }

                        } catch (HttpResponseException e) {
                            e.printStackTrace();
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                });
        });
    }
    private Handler Handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            String a = msg.getData().toString();
            String b = a.replace("Bundle[{name=","");
            String c = b.replace("}]","");
            id_num.setText(c);
        }
    };


}
