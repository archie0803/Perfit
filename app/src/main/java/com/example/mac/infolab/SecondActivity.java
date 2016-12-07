package com.example.mac.infolab;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class SecondActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        TextView calories = (TextView)findViewById(R.id.overall);
        String calvalue = getIntent().getStringExtra("passedvalue");
        if(getIntent() != null) {
            Intent intent = getIntent();
            if (intent.hasExtra("passedvalue"))
            {
                calvalue = intent.getExtras().getString("passedvalue");

            } else {
                calvalue = "0";  // I put 0 in String, because you parse it later. SO the logic is that is the first time you open the App, you have no Calories
            }
        }

        int f = Integer.parseInt(calvalue);
        calories.setText(""+f);
        Button add = (Button)findViewById(R.id.add_meal);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}