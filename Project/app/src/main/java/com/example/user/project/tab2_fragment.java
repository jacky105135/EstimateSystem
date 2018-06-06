package com.example.user.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.project.R;

/**
 * Created by user on 2018/1/5.
 */

public class tab2_fragment extends Fragment {
    private static final String TAG = "tab2_Fragment";
    TextView excellentthing,view_time,view_time2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        SharedPreferences msg = getActivity().getSharedPreferences("result", Context.MODE_PRIVATE);
        String a = msg.getString("GB","");
        String b = msg.getString("OB_Time","");
        String c = msg.getString("GB_Time","");

        excellentthing = (TextView)view.findViewById(R.id.excellentthing);
        view_time = (TextView)view.findViewById(R.id.view_time);
        view_time2 = (TextView)view.findViewById(R.id.view_time2);

        excellentthing.setText(a);
        view_time.setText(b);
        view_time2.setText(c);

        return view;
    }
}
