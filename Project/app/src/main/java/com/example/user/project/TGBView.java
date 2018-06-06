package com.example.user.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class TGBView extends AppCompatActivity {

    Button gradeconfirm;
    EditText stu_coaction;
    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_2 = "teacher_giveback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tgbview);

        Bundle bb = this.getIntent().getExtras();
        final String stuid = bb.getString("stuid");
        final String Tname = bb.getString("Tname");
        final String date = bb.getString("date");
        long date0 = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MM dd/ yyyy hh:mm");
        final String addtime = sdf.format(date0);
        stu_coaction = (EditText)findViewById(R.id.stu_coaction);


        gradeconfirm = (Button)findViewById(R.id.gradeconfirm);
        gradeconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.start();
                TGBView.this.finish();
                Toast.makeText(TGBView.this, "回饋已送出", Toast.LENGTH_SHORT).show();
            }
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_2);
                    request.addProperty("id",stuid);
                    request.addProperty("Tname",Tname);
                    request.addProperty("date",date);
                    request.addProperty("teacher_giveback",stu_coaction.getText().toString());
                    request.addProperty("addtime",addtime);
                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    envelope.dotNet = true;
                    envelope.setOutputSoapObject(request);
                    HttpTransportSE ht = new HttpTransportSE(URL);
                    try{
                        ht.call(NAMESPACE + METHOD_USERNAME_2, envelope);
                    }catch (HttpResponseException e) {
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
}
