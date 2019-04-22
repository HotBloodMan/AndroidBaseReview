package com.ljt.androidbasereview.handler;

import android.app.Person;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ljt.androidbasereview.R;
import com.ljt.androidbasereview.bean.People;

public class HandlerActivity extends AppCompatActivity {


    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Person person= (Person) msg.obj;
            if(person!=null){
                Log.d("TAG","person.age-----"+person.getName());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        new Thread(new Runnable(){
            @Override
            public void run() {
                Message message = new Message();
                message.arg1=1;
                message.arg2=2;

                People person = new People();
                person.setAge(333);
                person.setName("Liu");

            }
        }).start();
    }
}
