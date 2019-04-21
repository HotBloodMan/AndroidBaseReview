package com.ljt.androidbasereview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2,btnFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.btn01_main);
        button2=findViewById(R.id.btn02_main);
        btnFrag=findViewById(R.id.btn03_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.createDialog("A", "B", "C", new CustomDialog.CallBacks() {
                    @Override
                    public void isConfirm(boolean flag) {
                        System.out.println("------>>> "+flag);

                        if(flag){
                            System.out.println("***************");
                        }
                    }
                });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.createToasts("AA",getLayoutInflater());


            }
        });
        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
                HelloFragment helloFragment = new HelloFragment();
                transaction.add(R.id.lines,helloFragment);
                transaction.commit();
            }
        });

    }
}
