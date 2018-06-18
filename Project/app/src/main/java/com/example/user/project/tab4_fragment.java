package com.example.user.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.project.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/13.
 */

public class tab4_fragment extends Fragment {
    private static final String TAG = "tab4_Fragment";
    public static final float Max = 9 ,Min = 0f;
    public static final int NB_Qualities = 7;

    private RadarChart chart;
    private SparseIntArray factors = new SparseIntArray(7);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        factors.append(1,R.string.ex1);
        factors.append(2,R.string.ex2);
        factors.append(3,R.string.ex3);
        factors.append(4,R.string.ex4);
        factors.append(5,R.string.ex5);
        factors.append(6,R.string.ex6);
        factors.append(7,R.string.ex7);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_fragment,container,false);

        chart = (RadarChart) view.findViewById(R.id.radarchart);
        chart.setBackgroundColor(Color.rgb(60,65,82));
        chart.getDescription().setEnabled(false);
        chart.setWebLineWidth(1f);
        chart.setWebColor(Color.WHITE);
        chart.setWebLineWidth(1f);
        chart.setWebColorInner(Color.WHITE);
        chart.setWebAlpha(100);
        setData();

        XAxis xAxis = chart.getXAxis();
        xAxis.setXOffset(0f);
        xAxis.setYOffset(0f);
        xAxis.setTextSize(15f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] mFactors = new String[]{getString(factors.get(1)), getString(factors.get(2)),
                    getString(factors.get(3)), getString(factors.get(4)), getString(factors.get(5)), getString(factors.get(6)), getString(factors.get(7))};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mFactors[(int) value % mFactors.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        xAxis.setTextColor(Color.WHITE);

        YAxis yAxis = chart.getYAxis();
        yAxis.setAxisMinimum(Min);
        yAxis.setAxisMaximum(Max);
        yAxis.setTextSize(9f);
        yAxis.setLabelCount(NB_Qualities, false);
        yAxis.setDrawLabels(false);

        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);
        chart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);

        return view;
    }
    private void setData() {
        SharedPreferences msg = getActivity().getSharedPreferences("result", Context.MODE_PRIVATE);
        final String c = msg.getString("id","");
        final String d = msg.getString("ex1","");
        final String e = msg.getString("ex2","");
        final String f = msg.getString("ex3","");
        final String g = msg.getString("ex4","");
        final String h = msg.getString("ex5","");
        final String i = msg.getString("ex6","");
        final String j = msg.getString("ex7","");
        String[] list = new String[]{d,e,f,g,h,i,j};
        ArrayList<RadarEntry> student = new ArrayList<>();

        float score;
        for (int z = 0; z < NB_Qualities; z++){
            if(list[z].equals("優秀")) {
                score = getRandom(7,9);
            }else if(list[z].equals("達到要求")){
                score = getRandom(4,6);
            }else if(list[z].equals("未符要求")){
                score = getRandom(1,3);
            }else{
                score = 0;
            }
            student.add(new RadarEntry(score));
        }

        RadarDataSet set1 = new RadarDataSet(student,c);
        set1.setColor(Color.GREEN);
        set1.setFillColor(Color.GREEN);
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightIndicators(false);
        set1.setDrawHighlightCircleEnabled(true);

        RadarData data = new RadarData(set1);
        data.setDrawValues(false);
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate();
    }

    public int getRandom(int min,int max){
        return (int) (Math.random()*(max-min+1)+min);
    }
}
