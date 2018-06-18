package com.example.user.project;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Teacher_giveback_list extends AppCompatActivity {
    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://123.193.214.240:8008/WebService1.asmx";
    private static final String METHOD_USERNAME_4 = "select_TeacherGivebackList";
    android.support.v7.widget.Toolbar toolbar;
    ListView list;
    ViewAdapter adapter = null;
    public String[] response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_giveback_list);
        list = (ListView) findViewById(R.id.list);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b1 = this.getIntent().getExtras();
        final String stuid = b1.getString("stuid");

        Thread t2 = new Thread(new Runnable() {
            Bundle myBundle = new Bundle();

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
                        String e = d.replaceAll("; ","ㄅ");
                        String f = e.replace(";","");
                        myBundle.putString("name", f);
                        Message msg = new Message();
                        msg.setData(myBundle);
                        Handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Teacher_giveback_list.this, Stu_to_Teacher.class);
                String date = (String) adapter.getItem(position*4);
                String Tname = (String) adapter.getItem(position*4+1);
                Bundle bb = new Bundle();
                bb.putString("stuid",stuid);
                bb.putString("Tname",Tname);
                bb.putString("date",date);
                intent.putExtras(bb);
                startActivity(intent);
            }
        });
    }

    private android.os.Handler Handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String a = msg.getData().toString();
            String b = a.replace("Bundle[{name=", "");
            String c = b.replace("}]", "");
            response = c.split("ㄅ");

            adapter = new Teacher_giveback_list.ViewAdapter(Teacher_giveback_list.this);
            list.setAdapter(adapter);
        }
    };

    public class ViewAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        public ViewAdapter(Context c) {
            inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return (response.length)/4;
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
            convertView = inflater.inflate(R.layout.teachergiveback_show, null);
            TextView stu_id = (TextView) convertView.findViewById(R.id.stu_id);
            TextView date = (TextView) convertView.findViewById(R.id.date);
            TextView content = (TextView) convertView.findViewById(R.id.content);
            TextView time = (TextView) convertView.findViewById(R.id.time);

            date.setText(response[(position*4)]);//測驗日期
            stu_id.setText(response[(position*4) + 1]);//老師姓名
            content.setText(response[(position*4) + 2]);//內文
            time.setText(response[(position*4) + 3]);//傳送時間

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

            case R.id.backtomain:
                Intent intent2 = new Intent(Teacher_giveback_list.this,StuMainPage.class);
                startActivity(intent2);
                return true;

            case R.id.password:
                Intent intent= new Intent();
                intent.setClass(Teacher_giveback_list.this,Main5Activity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                Intent intent1 = new Intent();
                intent1.setClass(Teacher_giveback_list.this,MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

