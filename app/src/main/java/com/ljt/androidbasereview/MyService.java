package com.ljt.androidbasereview;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {

    private final Binder binder = new LocalBinder();
    private final Random random = new Random();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public class LocalBinder extends  Binder{

        public MyService getService(){
            return MyService.this;
        }
    }

    public int getRandomNum(){
        return random.nextInt();
    }

}
