package com.example.mac.infolab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ThirdActivity extends Activity implements OnClickListener {


    // private GoogleApiClient client;
    private ImageButton image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences mSharedPreferences = ThirdActivity.this.getSharedPreferences("app_prefs", MODE_PRIVATE);

        setContentView(R.layout.activity_third);
        initializeLayout();

        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    private void initializeLayout() {
        Button mBtnPublishAction;
        ImageView mImgVwLaunchBeatMonitor;

        mImgVwLaunchBeatMonitor = (ImageView) findViewById(R.id.imgvwLaunchHeartRater);
        mImgVwLaunchBeatMonitor.setOnClickListener(this);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
      /*  if (v.getId() == R.id.btnPublishAction) {
            saveDoctorId();
        }*/
        if (v.getId() == R.id.imgvwLaunchHeartRater) {
            int INDEX = 0;
            startActivity(new Intent(ThirdActivity.this, HeartRateMonitor.class));
        }

    }



    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


    }


}