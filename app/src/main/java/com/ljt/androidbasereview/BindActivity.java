package com.ljt.androidbasereview;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BindActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private TextView textView;
    private MyService myService;
    private boolean mBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);

        button=findViewById(R.id.btn01_bind);
        button2=findViewById(R.id.btn02_bind);
        textView=findViewById(R.id.tv01_bind);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BindActivity.this, MyService.class);
                bindService(intent,connection, Context.BIND_AUTO_CREATE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBind){
                    int result=myService.getRandomNum();
                    textView.setText("--->>"+result);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mBind){
            unbindService(connection);
            mBind=false;
        }
    }

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder localBinder = (MyService.LocalBinder) service;
            myService = localBinder.getService();
            mBind = true;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBind=false;
        }
    };

}
