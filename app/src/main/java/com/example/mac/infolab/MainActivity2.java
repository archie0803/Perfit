package com.example.mac.infolab;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity2 extends ActionBarActivity {


    int sub_weight = 0;

    EditText weight;
    TextView calories;
    Button display, save;
    public  static String FIREBASE_URL= "https://hello-595eb.firebaseio.com/";
    private Cursor note;
    private FirebaseAuth mFirebaseAuth;

    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    public static String mUserId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        weight = (EditText)findViewById(R.id.edit_weight);
        calories = (TextView)findViewById(R.id.cal_total);
        display = (Button)findViewById(R.id.display);

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView calories = (TextView)findViewById(R.id.cal_total);
                String g = calories.getText().toString();

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("passedvalue", g );
                startActivity(intent);
            }
        });

    }
    public void onCheckBoxClicked(View v){

        boolean checked = ((CheckBox) v).isChecked();

        switch (v.getId()) {
            case R.id.chapati:
                if (checked)
                    sub_weight = sub_weight + 80;
                break;
            case R.id.milk:
                if (checked)
                    sub_weight = sub_weight + 42;
                break;
            case R.id.juice:
                if (checked)
                    sub_weight = sub_weight + 54;
                break;
            case R.id.tea:
                if (checked)
                    sub_weight = sub_weight + 1;
                break;
            case R.id.fruitchat:
                if (checked)
                    sub_weight = sub_weight + 60;
                break;
            case R.id.radiocereal:
                if (checked)
                    sub_weight = sub_weight + 379;
                break;
            case R.id.radioporridge:
                if (checked)
                    sub_weight = sub_weight + 50;
                break;
            case R.id.radiotoast:
                if (checked)
                    sub_weight = sub_weight + 313;
                break;
            case R.id.radiocrisps:
                if (checked)
                    sub_weight = sub_weight + 513;
                break;
            case R.id.radionoodle:
                if (checked)
                    sub_weight = sub_weight + 138;
                break;


        }

    }
    public void display_calories(View v){

        String m = weight.getText().toString();
        int x =  Integer.parseInt(m);
        int y = x * sub_weight;
        calories.setText(y+"");
        long msTime = System.currentTimeMillis();
        Date curDateTime = new Date(msTime);
        SimpleDateFormat formatter = new SimpleDateFormat("d'/'M'/'y");
        String curDate = formatter.format(curDateTime);
        firebasedata temp =  new firebasedata();
        String km_run = ""+y;
        temp.firebasedata2(km_run,curDate);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserId = mFirebaseUser.getUid();
        Firebase.setAndroidContext(MainActivity2.this);
        Firebase ref = new Firebase(FIREBASE_URL);
        Firebase neft=  ref.child("users").child(mUserId);
        neft.push().setValue(temp);


    }

}