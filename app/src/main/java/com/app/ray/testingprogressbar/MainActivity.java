package com.app.ray.testingprogressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar myProgressBar;
    int myProgress = 0;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProgressBar = (ProgressBar)findViewById(R.id.progressbar);
        myProgressBar.setProgress(myProgress);

        new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(myProgress<100){
                    try{
                        myHandle.sendMessage(myHandle.obtainMessage());
                        Thread.sleep(1000);
                    }catch(Throwable t){
                    }
                }
            }
        }).start();

    }

    Handler myHandle = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            myProgress++;
            myProgressBar.setProgress(myProgress);
        }
    };
}