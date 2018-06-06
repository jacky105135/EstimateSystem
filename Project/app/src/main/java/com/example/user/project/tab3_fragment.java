package com.example.user.project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.project.R;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by user on 2018/1/5.
 */

public class tab3_fragment extends Fragment {
    private static final String TAG = "tab3_Fragment";
    Button gradeconfirm,stufeedback;

    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_3 = "deletedata";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);

        SharedPreferences msg = getActivity().getSharedPreferences("result", Context.MODE_PRIVATE);
        final String a = msg.getString("date","");
        final String b = msg.getString("position","");
        final String c = msg.getString("operation","");
        final String d = msg.getString("ex1","");
        final String e = msg.getString("ex2","");
        final String f = msg.getString("ex3","");
        final String g = msg.getString("ex4","");
        final String h = msg.getString("ex5","");
        final String i = msg.getString("ex6","");
        final String j = msg.getString("ex7","");
        final String k = msg.getString("GB","");
        final String l = msg.getString("OB_Time","");
        final String m = msg.getString("GB_Time","");
        final String n = msg.getString("id","");
        final String o = msg.getString("name","");
        final String p = msg.getString("gender","");
        final String q = msg.getString("patient_sign","");
        final String r = msg.getString("patient_age","");
        final String s = msg.getString("diagnose","");

        gradeconfirm = (Button)view.findViewById(R.id.gradeconfirm);
        stufeedback = (Button)view.findViewById(R.id.stufeedback);

        stufeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getActivity(),Main11Activity.class);
                getActivity().startActivity(i);
            }
        });
        gradeconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.start();
                Intent i = new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(i);
                Toast.makeText(getActivity(), "成績已送出，無法再做更改!", Toast.LENGTH_SHORT).show();
            }


            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
                    request.addProperty("id",n);
                    request.addProperty("name",o);
                    request.addProperty("date",a);
                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    envelope.dotNet = true;
                    envelope.setOutputSoapObject(request);
                    HttpTransportSE ht = new HttpTransportSE(URL);
                    try {
                        ht.call(NAMESPACE + METHOD_USERNAME_3, envelope);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        });
        return view;
    }
}
