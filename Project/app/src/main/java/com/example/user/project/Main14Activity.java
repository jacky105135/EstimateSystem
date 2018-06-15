package com.example.user.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;


public class Main14Activity extends AppCompatActivity {

    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_4 = "gettrend";
    public String[] response;
    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        Bundle b = this.getIntent().getExtras();
        final String stuid = b.getString("stuid");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_4);
                request.addProperty("id", stuid);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE ht = new HttpTransportSE(URL);
                try {
                    ht.call(NAMESPACE + METHOD_USERNAME_4, envelope);
                    Object response = (Object) envelope.getResponse();
                    if (response != null) {
                        String result = response.toString();
                        String pattern = "string=";
                        String b = result.replaceAll(pattern, "");
                        String c = b.replace("anyType{", "");
                        String d = c.replace(" }", "");
                        String e = d.replaceAll("; ", "ㄅ");
                        String f = e.replace(";", "");
                        SharedPreferences msp0 = getSharedPreferences("trend", MODE_PRIVATE);
                        msp0.edit()
                                .putString("response", f)
                                .putString("stuid",stuid)
                                .apply();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        chart = (BarChart)findViewById(R.id.barchart);
        chart.setMaxVisibleValueCount(60);

        setData();
    }

    private void setData() {
        ArrayList<BarEntry> yvalues = new ArrayList<>();

        SharedPreferences msg = getSharedPreferences("trend", Context.MODE_PRIVATE);
        final String a = msg.getString("response","");
        String b = a.replace("ㄅ",",");
        response = b.split(",");
      //  String stuid = msg.getString("stuid","");

        int count = (response.length)/7;
        float val1 = 0 ,val2 = 0,val3 = 0,val4 = 0,val5 = 0,val6 = 0,val7 = 0;
        float [] list = new float[] {val1,val2,val3,val4,val5,val6,val7};

        for(int i = 0;i < count; i++){
            for (int j = 0; j < response.length; j++) {
                if (response[j].equals("優秀")) {
                    list[j % 7] = getRandom(7, 9);
                } else if (response[j].equals("達到要求")) {
                    list[j % 7] = getRandom(4, 6);
                } else if (response[j].equals("未達要求")) {
                    list[j % 7] = getRandom(1, 3);
                } else {
                    list[j % 7] = 0;
                }
            }
            yvalues.add(new BarEntry(i, list));
       }

        BarDataSet set1;
        set1 = new BarDataSet(yvalues,"");
        set1.setStackLabels(new String[]{"醫療面談","身體檢查","操作技能","諮商衛教","臨床判斷","組織效能","人道專業"});
        set1.setColors(ColorTemplate.JOYFUL_COLORS);

        BarData data = new BarData(set1);
        data.setValueFormatter(new MyValueFormatter());

        chart.setData(data);
        chart.setFitBars(true);
        chart.invalidate();
        chart.getDescription().setEnabled(false);
    }

    private float getRandom(int max, int min) {
        return (int) (Math.random()*(max-min+1)+min);
    }
}
