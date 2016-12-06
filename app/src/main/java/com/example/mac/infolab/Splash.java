package com.example.mac.infolab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Archita on 12-07-2016.
 */
public class Splash extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening);
        Thread timer = new Thread() {
            public void run() {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent op=new Intent(Splash.this, LoginActivity.class);
                    startActivity(op);
                }
            }
        };
        timer.start();
    }
}

