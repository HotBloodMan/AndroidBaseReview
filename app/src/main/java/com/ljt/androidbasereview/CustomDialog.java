package com.ljt.androidbasereview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDialog {

    private AlertDialog.Builder builder;
    private Context mContext;

    public CustomDialog(Context context){
        mContext=context;
    }


    public void createDialog(String buttontext,String title,
                             String message,final CallBacks callBacks){
        builder=new AlertDialog.Builder(mContext);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(buttontext, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callBacks.isConfirm(true);
            }
        });
        builder.create().show();

    }


    public interface  CallBacks{
        public void isConfirm(boolean flag);
    }

    public void createToasts(String message, LayoutInflater layoutInflater)
    {
        View view = layoutInflater.inflate(R.layout.toast, null);
        TextView textView=view.findViewById(R.id.text);
        textView.setText(message);


        Toast toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();


    }

}
