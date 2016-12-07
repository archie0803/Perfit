package com.example.mac.infolab;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by Archita on 10-07-2016.
 */
public class Main6Activity extends AppCompatActivity {
    ViewPager viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Button btnPlay=(Button)findViewById(R.id.button3);

        viewPager2 = (ViewPager) findViewById(R.id.viewPager2);
        PagerAdapter adapter = new CustomAdapter3(Main6Activity.this);
        viewPager2.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
