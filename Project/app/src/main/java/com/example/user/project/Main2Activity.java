package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView teaching;
    private Button teachbtn;
    Button stubtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        teachbtn = (Button)findViewById(R.id.teachbtn);
        stubtn = (Button)findViewById(R.id.stubtn);

        stubtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this , Main3Activity.class);
                startActivity(intent);
            }
        });

        teachbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this , Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
