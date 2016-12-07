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
public class Main5Activity extends AppCompatActivity {
    ViewPager viewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button btnPlay=(Button)findViewById(R.id.button2);


        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);
        PagerAdapter adapter = new CustomAdapter2(Main5Activity.this);
        viewPager1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
