package com.edu.huatec.gjx;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Adactivity extends AppCompatActivity {


    TextView textView;

    Handler handler=new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adactivity);


        textView=(TextView) findViewById(R.id.tv1);



        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=5;i>=0;i--)
                {
                    SystemClock.sleep(1000);
                    final int count=i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("点击跳转"+count);
                        }
                    });


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(Adactivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });



                }

            }
        }).start();




    }
}
