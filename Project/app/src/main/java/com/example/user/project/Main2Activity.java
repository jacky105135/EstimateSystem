package com.example.user.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Main2Activity extends AppCompatActivity {
    ImageView teaching;
    private Button teachbtn;
    Button stubtn;
    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_2 = "ChkId";
    String userid, idnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        teachbtn = (Button) findViewById(R.id.teachbtn);
        stubtn = (Button) findViewById(R.id.stubtn);
        final View item = LayoutInflater.from(Main2Activity.this).inflate(R.layout.idconfirm, null);


        stubtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Main2Activity.this)
                        .setView(item)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText a = (EditText) item.findViewById(R.id.userid);
                                EditText b = (EditText) item.findViewById(R.id.idnum);
                                userid = a.getText().toString();
                                idnum = b.getText().toString();

                                if (TextUtils.isEmpty(userid)) {
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {
                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), R.string.input_ur_id, Toast.LENGTH_LONG).show();
                                } else if (TextUtils.isEmpty(idnum)) {
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {
                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), R.string.input_ur_idnum, Toast.LENGTH_LONG).show();
                                } else {
                                    t1.start();
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {

                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                }
                            }
                        })
                        .show();
            }
        });

        teachbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setView(item)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText a = (EditText) item.findViewById(R.id.userid);
                                EditText b = (EditText) item.findViewById(R.id.idnum);
                                userid = a.getText().toString();
                                idnum = b.getText().toString();

                                if (TextUtils.isEmpty(userid) && TextUtils.isEmpty(idnum) ) {
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {
                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), R.string.main_err, Toast.LENGTH_LONG).show();
                                }else if (TextUtils.isEmpty(userid)) {
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {
                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), R.string.input_ur_id, Toast.LENGTH_LONG).show();
                                } else if (TextUtils.isEmpty(idnum)) {
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {
                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), R.string.input_ur_idnum, Toast.LENGTH_LONG).show();
                                } else {
                                    t1.start();
                                    if (item != null) {
                                        ViewGroup parentViewGroup = (ViewGroup) item.getParent();
                                        if (parentViewGroup != null) {
                                            a.setText("");
                                            b.setText("");
                                           // Toast.makeText(getApplicationContext(), R.string.chkId_err, Toast.LENGTH_LONG).show();
                                            parentViewGroup.removeView(item);
                                        }
                                    }
                                }
                            }
                        })
                        .show();
            }
        });
    }

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_2);
            request.addProperty("id", userid);
            request.addProperty("id_num", idnum);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(URL);
            try {
                ht.call(NAMESPACE + METHOD_USERNAME_2, envelope);
                SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                boolean Flag = Boolean.parseBoolean(response.toString());
                if (Flag) {
                    Intent intent = new Intent();
                    intent.setClass(Main2Activity.this, Main3Activity.class);
                    startActivity(intent);
                } else {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}
