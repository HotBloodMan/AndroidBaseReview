package com.ljt.androidbasereview;

import android.app.Service;
import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.session.IMediaControllerCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DownLoadService extends Service {

    private final String IMAGE_PATH = "http://www.baidu.com/img/bdlogo.gif";

    public DownLoadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==1){
                    stopSelf();
                }
            }
        };
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpClient httpClient = new DefaultHttpClient();
//                HttpPost httpPost = new HttpPost(IMAGE_PATH);
//                HttpResponse  response=null;
//
//                File file = Environment.getExternalStorageDirectory();
//                FileOutputStream outputStream=null;
//
//                try {
//                    response=httpClient.execute(httpClient);
//                    if(response.getStatusLine().getStatusCode()=200){
//                        byte[] result=EntityUtils.toByteArray(
//                          response.getEntity()
//                        );
//                        if(Environment.getExternalStorageState().equals(
//                                Environment.MEDIA_MOUNTED
//                        )){
//                            File new_file = new File(file, "bdlogo.gif");
//                            outputStream=new FileOutputStream(new_file);
//                            outputStream.write(result,0,result.length);
//                            Message message=Message.obtain();
//                            message.what=1;
//                            handler.sendMessage(message);
//                        }
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }finally {
//                    if(outputStream !=null){
//                        try {
//                            outputStream.close();
//                        }catch (IOException e){
//                            e.printStackTrace();
//                        }
//                    }
//                    if(httpClient !=null){
//                        httpClient.getConnectManager().shutdown();
//                    }
//                }
//            }
//        }).start();

        return super.onStartCommand(intent, flags, startId);
    }
}
