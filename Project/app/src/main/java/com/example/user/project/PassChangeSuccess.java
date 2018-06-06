package com.example.user.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PassChangeSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_change_success);

        openDialog();

    }

    private void openDialog() {
        new AlertDialog.Builder(this)
                .setTitle("密碼更改成功!!")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                //按下按鈕後執行的動作，沒寫則退出Dialog
                                Intent intent = new Intent();
                                intent.setClass(PassChangeSuccess.this , MainActivity.class);
                                startActivity(intent);
                            }
                        }
                )
                .show();
    }
}
