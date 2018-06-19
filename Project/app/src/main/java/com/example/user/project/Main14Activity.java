package com.example.user.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.logging.Handler;


public class Main14Activity extends AppCompatActivity {

    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";

    public String[] response;
    private BarChart chart;
    private XAxis xAxis;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        Bundle b = this.getIntent().getExtras();
        final String stuid = b.getString("stuid");
        final String a = b.getString("response");
        response = a.split(",");

        chart = (BarChart) findViewById(R.id.barchart);
        chart.setMaxVisibleValueCount(60);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setData();
    }

    private void setData() {
        ArrayList<BarEntry> yvalues = new ArrayList<>();
        ArrayList<BarEntry> yvalues2 = new ArrayList<>();
        ArrayList<BarEntry> yvalues3 = new ArrayList<>();
        ArrayList<BarEntry> yvalues4 = new ArrayList<>();
        ArrayList<BarEntry> yvalues5 = new ArrayList<>();
        ArrayList<BarEntry> yvalues6 = new ArrayList<>();
        ArrayList<BarEntry> yvalues7 = new ArrayList<>();

        /*SharedPreferences msg = getSharedPreferences("trend", Context.MODE_PRIVATE);
        final String a = msg.getString("response","");
        String b = a.replace("ㄅ",",");
        response = b.split(",");*/
        //  String stuid = msg.getString("stuid","");

        int count = (response.length) / 7;
        float val1 = 0, val2 = 0, val3 = 0, val4 = 0, val5 = 0, val6 = 0, val7 = 0;
        float[] list = new float[]{val1, val2, val3, val4, val5, val6, val7};

        for (int j = 0; j < count; j++) {
            if (response[j * 7].equals("優秀")) {
                list[0] = getRandom(9, 7);
            } else if (response[j * 7].equals("達到要求")) {
                list[0] = getRandom(6, 4);
            } else if (response[j * 7].equals("未符要求")) {
                list[0] = getRandom(3, 1);
            } else {
                list[0] = 0;
            }
            yvalues.add(new BarEntry(j + 1, list[0]));
        }

        for (int j = 0; j < count; j++) {
            if (response[j * 7 + 1].equals("優秀")) {
                list[1] = getRandom(9, 7);
            } else if (response[j * 7 + 1].equals("達到要求")) {
                list[1] = getRandom(6, 4);
            } else if (response[j * 7 + 1].equals("未符要求")) {
                list[1] = getRandom(3, 1);
            } else {
                list[1] = 0;
            }
            yvalues2.add(new BarEntry(j + 1, list[1]));
        }

        for (int j = 0; j < count; j++) {
            if (response[j * 7 + 2].equals("優秀")) {
                list[2] = getRandom(9, 7);
            } else if (response[j * 7 + 2].equals("達到要求")) {
                list[2] = getRandom(6, 4);
            } else if (response[j * 7 + 2].equals("未符要求")) {
                list[2] = getRandom(3, 1);
            } else {
                list[2] = 0;
            }
            yvalues3.add(new BarEntry(j + 1, list[2]));
        }

        for (int j = 0; j < count; j++) {
            if (response[j * 7 + 3].equals("優秀")) {
                list[3] = getRandom(9, 7);
            } else if (response[j * 7 + 3].equals("達到要求")) {
                list[3] = getRandom(6, 4);
            } else if (response[j * 7 + 3].equals("未符要求")) {
                list[3] = getRandom(3, 1);
            } else {
                list[3] = 0;
            }
            yvalues4.add(new BarEntry(j + 1, list[3]));
        }

        for (int j = 0; j < count; j++) {
            if (response[j * 7 + 4].equals("優秀")) {
                list[4] = getRandom(9, 7);
            } else if (response[j * 7 + 4].equals("達到要求")) {
                list[4] = getRandom(6, 4);
            } else if (response[j * 7 + 4].equals("未符要求")) {
                list[4] = getRandom(3, 1);
            } else {
                list[4] = 0;
            }
            yvalues5.add(new BarEntry(j + 1, list[4]));
        }

        for (int j = 0; j < count; j++) {
            if (response[j * 7 + 5].equals("優秀")) {
                list[5] = getRandom(9, 7);
            } else if (response[j * 7 + 5].equals("達到要求")) {
                list[5] = getRandom(6, 4);
            } else if (response[j * 7 + 5].equals("未符要求")) {
                list[5] = getRandom(3, 1);
            } else {
                list[5] = 0;
            }
            yvalues6.add(new BarEntry(j + 1, list[5]));
        }

        for (int j = 0; j < count; j++) {
            if (response[j * 7 + 6].equals("優秀")) {
                list[6] = getRandom(9, 7);
            } else if (response[j * 7 + 6].equals("達到要求")) {
                list[6] = getRandom(6, 4);
            } else if (response[j * 7 + 6].equals("未符要求")) {
                list[6] = getRandom(3, 1);
            } else {
                list[6] = 0;
            }
            yvalues7.add(new BarEntry(j + 1, list[6]));
        }

        BarDataSet set1 = new BarDataSet(yvalues, "醫療面談");
        int color1 = getResources().getColor(R.color.color_1);
        set1.setColor(color1);


        BarDataSet set2 = new BarDataSet(yvalues2, "身體檢查");
        int color2 = getResources().getColor(R.color.color_2);
        set2.setColor(color2);

        BarDataSet set3 = new BarDataSet(yvalues3, "操作技能");
        int color3 = getResources().getColor(R.color.color_3);
        set3.setColor(color3);


        BarDataSet set4 = new BarDataSet(yvalues4, "諮商衛教");
        int color4 = getResources().getColor(R.color.color_4);
        set4.setColor(color4);


        BarDataSet set5 = new BarDataSet(yvalues5, "臨床判斷");
        int color5 = getResources().getColor(R.color.color_5);
        set5.setColor(color5);


        BarDataSet set6 = new BarDataSet(yvalues6, "組織效能");
        set6.setColor(Color.YELLOW);
        int color6 = getResources().getColor(R.color.color_6);
        set6.setColor(color6);


        BarDataSet set7 = new BarDataSet(yvalues7, "人道專業");
        int color7 = getResources().getColor(R.color.color_7);
        set7.setColor(color7);

        ArrayList<IBarDataSet> bardata = new ArrayList<>();//IBarDataSet 接口很关键，是添加多组数据的关键结构，LineChart也是可以采用对应的接口类，也可以添加多组数据
        bardata.add(set1);
        bardata.add(set2);
        bardata.add(set3);
        bardata.add(set4);
        bardata.add(set5);
        bardata.add(set6);
        bardata.add(set7);


        BarData data = new BarData(bardata);
        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(12f);
        data.setBarWidth(0.07f);
        data.groupBars(0.5f, 0.3f, 0.03f);
        xAxis = chart.getXAxis();
        xAxis.setTextSize(18f);
        xAxis.setLabelCount(count - 1, false);
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextSize(18f);
        YAxis yAxis1 = chart.getAxisRight();
        yAxis1.setTextSize(18f);
        //chart.setPinchZoom(true);
        Legend legend = chart.getLegend();
        legend.setTextSize(15f);
        chart.setData(data);
        chart.setFitBars(true);
        xAxis.setValueFormatter(new MyAxisValueFormatter());
        //chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.invalidate();
        chart.getXAxis().setAxisMinimum(0.6f);
        chart.getAxisLeft().setAxisMinValue(0.0f);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getDescription().setEnabled(false);
        chart.animateY(1000);
        //chart.animateX( 1400,Easing.EasingOption.EaseInOutQuad);
    }

    private float getRandom(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.backtomain:
                Intent intent2 = new Intent(Main14Activity.this, StuMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent = new Intent();
                intent.setClass(Main14Activity.this, Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Main14Activity.this, MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
