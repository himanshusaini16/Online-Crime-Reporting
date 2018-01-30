package com.example.himanshu.onlinecrimereporting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.himanshu.onlinecrimereporting.fragments.Home;


public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread tp = new Thread() {
            public void run() {
                try {
                    sleep(3000);

                } catch (Exception e) {

                } finally {

                    Intent ss = new Intent(SplashActivity.this, Navigation.class);
                    startActivity(ss);
                    finish();
                }

            }

        };
        tp.start();

    }

}
