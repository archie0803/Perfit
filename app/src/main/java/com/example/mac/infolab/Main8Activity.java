package com.example.mac.infolab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Archita on 10-07-2016.
 */
public class Main8Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
    }
    public void showme(View v){
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(),Main9Activity.class));
    }
    public void showme1(View v){
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(),Main10Activity.class));
    }
    public void showme2(View v){
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(),Main11Activity.class));
    }
    public void showme3(View v){
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(),Main12Activity.class));
    }

    public void showme4(View v){
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(),Main13Activity.class));
    }

}
