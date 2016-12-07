package com.example.mac.infolab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Archita on 10-07-2016.
 */
public class FourthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    public void buttonOnClick(View v)

    {
        Button button = (Button) v;
       startActivity(new Intent(FourthActivity.this, Main8Activity.class));
    }

    public void buttonOnClick1(View v)

    {
        Button button = (Button) v;
        startActivity(new Intent(FourthActivity.this, Main2Activity.class));
    }

}