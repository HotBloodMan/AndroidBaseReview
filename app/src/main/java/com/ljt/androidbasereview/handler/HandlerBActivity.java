package com.ljt.androidbasereview.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.ljt.androidbasereview.R;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

public class HandlerBActivity extends AppCompatActivity {

    static TextView  tv;
    Button btn;
    static int i=0;
    private final MyHandler myHandler=new MyHandler(this);

    private static final Runnable sRunnable=new Runnable() {
        @Override
        public void run() {
            Log.d("MyHandler","sRunnable");
//           if(i<10){
//               tv.setText(i++);
//           }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_b);
        initView();
    }

    private void initView() {
        tv=findViewById(R.id.tv_handlerb);
        btn=findViewById(R.id.btn_handlerb);
//        myHandler.post(sRunnable);
        mHandlerPro.sendEmptyMessage(0x11);
    }


    private static class MyHandler extends Handler{

        private final WeakReference<HandlerBActivity> mActivity;

        private MyHandler(HandlerBActivity mActivity){
            this.mActivity=new WeakReference<>(mActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HandlerBActivity activity = mActivity.get();
            if(activity!=null){
//                if(i<10){
//                    tv.setText(i++);
//                }
            }
        }
    }


    private Handler mHandlerPro=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what==0x11){
                if(i<10){
                    Log.d("Handler","mHandlerPro");
//                    tv.setText(i++);
                }
            }
            mHandlerPro.sendEmptyMessageDelayed(0x11,1000);
            return true;
        }
    });
}
