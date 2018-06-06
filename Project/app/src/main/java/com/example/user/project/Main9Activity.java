package com.example.user.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.HashMap;
import java.util.List;

public class Main9Activity extends AppCompatActivity {


    private static  final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_3 = "select_table1";

    ViewAdapter adapter = null;
    public String[] response = null;
    ListView listView1;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView1 = (ListView)findViewById(R.id.listview1);

        Bundle b1 = this.getIntent().getExtras();
        final String result = b1.getString("result");
        response = result.split("ㄅ");
        final String a1 = b1.getString("id");

        adapter = new ViewAdapter(Main9Activity.this);
        listView1.setAdapter(adapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view,  int position, long id) {

                final String date = (String) adapter.getItem(position*3);
                final String tname =(String) adapter.getItem(position*3 + 2);

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        SoapObject request = new SoapObject(NAMESPACE, METHOD_USERNAME_3);
                        request.addProperty("id",a1);
                        request.addProperty("date",date);
                        request.addProperty("Tname",tname);
                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                        envelope.dotNet = true;
                        envelope.setOutputSoapObject(request);
                        HttpTransportSE ht = new HttpTransportSE(URL);
                        try
                        {
                            ht.call(NAMESPACE+METHOD_USERNAME_3, envelope);
                            Object response = (Object) envelope.getResponse();
                            String result = response.toString();
                            String pattern = "string=";
                            String b = result.replaceAll(pattern,"");
                            String c = b.replace("anyType{","");
                            String d = c.replace(" }","");
                            String d1 = d.replace(";",",");
                            String e[] = d1.split(",");
                            String date = e[0];
                            String position = e[1];
                            String operation = e[2];
                            String ex1 = e[3];
                            String ex2 = e[4];
                            String ex3 = e[5];
                            String ex4 = e[6];
                            String ex5 = e[7];
                            String ex6 = e[8];
                            String ex7 = e[9];
                            String GB = e[10];
                            String OB_Time = e[11];
                            String GB_Time = e[12];
                            String name = e[13];
                            String gender = e[14];
                            String patient_sign = e[15];
                            String patient_age = e[16];
                            String diagnose = e[17];

                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("id",a1);
                            bundle.putString("date",date);
                            bundle.putString("Tname",tname);
                            bundle.putString("date",date);
                            bundle.putString("position",position);
                            bundle.putString("operation",operation);
                            bundle.putString("ex1",ex1);
                            bundle.putString("ex2",ex2);
                            bundle.putString("ex3",ex3);
                            bundle.putString("ex4",ex4);
                            bundle.putString("ex5",ex5);
                            bundle.putString("ex6",ex6);
                            bundle.putString("ex7",ex7);
                            bundle.putString("GB",GB);
                            bundle.putString("OB_Time",OB_Time);
                            bundle.putString("GB_Time",GB_Time);
                            bundle.putString("name",name);
                            bundle.putString("gender",gender);
                            bundle.putString("patient_sign",patient_sign);
                            bundle.putString("patient_age",patient_age);
                            bundle.putString("diagnose",diagnose);

                            intent.putExtras(bundle);
                            intent.setClass(Main9Activity.this,Main13Activity.class);
                            startActivity(intent);

                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
            }
        });
    }

    public class ViewAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        public ViewAdapter(Context c) {
            inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return (response.length)/3;
        }

        @Override
        public Object getItem(int position) {
            return response[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.list_item, null);

            TextView date = (TextView) convertView.findViewById(R.id.date);
            TextView diagnose = (TextView) convertView.findViewById(R.id.diagnose);
            TextView Tname = (TextView) convertView.findViewById(R.id.Tname);

            date.setText(response[position*3]);
            diagnose.setText(response[(position*3) + 1]);
            Tname.setText(response[(position*3) + 2]);
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.password:
                Intent intent= new Intent();
                intent.setClass(Main9Activity.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Main9Activity.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
