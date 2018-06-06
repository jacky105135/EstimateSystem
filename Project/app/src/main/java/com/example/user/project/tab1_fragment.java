package com.example.user.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.project.R;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Text;

/**
 * Created by user on 2018/1/5.
 */

public class tab1_fragment extends Fragment {


    private static final String TAG = "tab1_Fragment";
    String id,date,Tname,position,operation,ex1,ex2,ex3,ex4,ex5,ex6,ex7,sex,state,age,anal;
    TextView date1,position1,operation1,a_score,b_score,c_score,d_score,e_score,f_score,g_score,sex1,state1,age1,anal1;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        SharedPreferences msg = getActivity().getSharedPreferences("result", Context.MODE_PRIVATE);
        id = msg.getString("id","");
        date = msg.getString("date","");
        Tname = msg.getString("Tname","");
        position = msg.getString("position","");
        operation = msg.getString("operation","");
        ex1 = msg.getString("ex1","");
        ex2 = msg.getString("ex2","");
        ex3 = msg.getString("ex3","");
        ex4 = msg.getString("ex4","");
        ex5 = msg.getString("ex5","");
        ex6 = msg.getString("ex6","");
        ex7 = msg.getString("ex7","");
        sex = msg.getString("gender","");
        state = msg.getString("patient_sign","");
        age = msg.getString("patient_age","");
        anal = msg.getString("diagnose","");

        date1 = (TextView) view.findViewById(R.id.date1);
        position1 = (TextView) view.findViewById(R.id.position1);
        operation1 = (TextView) view.findViewById(R.id.operation1);
        a_score = (TextView) view.findViewById(R.id.a_score);
        b_score = (TextView) view.findViewById(R.id.b_score);
        c_score = (TextView) view.findViewById(R.id.c_score);
        d_score = (TextView) view.findViewById(R.id.d_score);
        e_score = (TextView) view.findViewById(R.id.e_score);
        f_score = (TextView) view.findViewById(R.id.f_score);
        g_score = (TextView) view.findViewById(R.id.g_score);
        sex1 = (TextView) view.findViewById(R.id.sex1);
        state1 =(TextView)view.findViewById(R.id.state1);
        age1 = (TextView) view.findViewById(R.id.age1);
        anal1 = (TextView) view.findViewById(R.id.anal1);

        date1.setText(date);
        position1.setText(position);
        operation1.setText(operation);
        a_score.setText(ex1);
        b_score.setText(ex2);
        c_score.setText(ex3);
        d_score.setText(ex4);
        e_score.setText(ex5);
        f_score.setText(ex6);
        g_score.setText(ex7);
        sex1.setText(sex);
        state1.setText(state);
        age1.setText(age);
        anal1.setText(anal);

        return view;
    }



}
