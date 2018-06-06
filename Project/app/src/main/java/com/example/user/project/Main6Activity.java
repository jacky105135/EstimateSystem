package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
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

public class Main6Activity extends AppCompatActivity {

    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_5 = "password_change";

    Button button1;
    EditText newpass,passconfirm;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        tv1 = (TextView)findViewById(R.id.tv1);
        button1 = (Button) findViewById(R.id.button1);
        newpass = (EditText) findViewById(R.id.newpass);
        passconfirm = (EditText) findViewById(R.id.passcomfirm);

        Editable a = newpass.getText();
        String aa = a.toString();

        Editable b = passconfirm.getText();
        String bb = b.toString();

        Bundle bundle05 = this.getIntent().getExtras();
        String id = bundle05.getString("id");
        tv1.setText(id);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                passwordChange();
                openSuccessActivity();
            }

            private void passwordChange() {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_5);
                            request.addProperty("id", tv1.getText().toString());
                            request.addProperty("password", newpass.getText().toString());
                            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                            envelope.dotNet = true;
                            envelope.setOutputSoapObject(request);
                            HttpTransportSE ht = new HttpTransportSE(URL);
                            ht.call(NAMESPACE + METHOD_USERNAME_5, envelope);

                        } catch (HttpResponseException e) {
                            e.printStackTrace();
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
            }

            private void openSuccessActivity() {
                Intent intent = new Intent();
                intent.setClass(Main6Activity.this, PassChangeSuccess.class);
                startActivity(intent);
            }
        });

    }
}
