package com.example.user.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        openDialog();

    }

    private void openDialog() {
        new AlertDialog.Builder(this)
                .setTitle("註冊成功!!")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                //按下按鈕後執行的動作，沒寫則退出Dialog
                                Intent intent = new Intent();
                                intent.setClass(Main4Activity.this , MainActivity.class);
                                startActivity(intent);
                            }
                        }
                )
                .show();
    }
}
