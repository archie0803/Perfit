package com.example.mac.infolab;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.firebase.client.Config;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.firebase.client.Firebase;
import com.google.firebase.database.ValueEventListener;


public class FifthActivity extends AppCompatActivity {

    TextView tv4;
    public  static String FIREBASE_URL= "https://hello-595eb.firebaseio.com/";
    private Cursor note;
    private FirebaseAuth mFirebaseAuth;

    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    public static String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        String user_name = "User";
        TextView tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void b1clicked(View view) {
        // Get the references to the widgets
        final EditText ed1 = (EditText) findViewById(R.id.ed1);
        final EditText ed2 = (EditText) findViewById(R.id.ed2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        String ht = ed1.getText().toString();
        String wt = ed2.getText().toString();

        if (TextUtils.isEmpty(ht)) {
            ed1.setError("Please enter your height");
            ed1.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(wt)) {
            ed2.setError("Please enter your weight");
            ed2.requestFocus();
            return;
        }

//Get the user values from the widget reference
        String date;
        long msTime = System.currentTimeMillis();
        Date curDateTime = new Date(msTime);
        String curDate;
        SimpleDateFormat formatter = new SimpleDateFormat("d'/'M'/'y");
        curDate = formatter.format(curDateTime);
        firebasedata temp = new firebasedata(wt,ht,curDate);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserId = mFirebaseUser.getUid();
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase(FIREBASE_URL);
        Firebase neft=  ref.child("users").child(mUserId);
        neft.push().setValue(temp);
        final float weight = Float.parseFloat(wt);
        float height = Float.parseFloat(ht) / 100;

//Calculate BMI value
        float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
        String bmiMeans = interpretBMI(bmiValue);
        tv4.setText(String.valueOf("BMI : " + bmiValue + "\nYou're " + bmiMeans));
        //Ideal BMI and Target Weight
        float idealB = (float) 22.5;
        final float idealW = idealB * (height * height);
        tv4.append(String.valueOf("\nIdeal BMI : " + idealB + "\nIdeal Weight : " + idealW + "\n"));
        float stepGoals = 0;
        float kmGoals = (stepGoals / 1320);
        if (idealW >= weight) {
            stepGoals = 3000;
            kmGoals = stepGoals / 1320;
            tv4.append(String.valueOf("\nYou're fit enough.Here's your Goal:\nSteps - " + stepGoals + "\nKilometres - " + kmGoals));

        }
        else
        {
            final float lose = weight - idealW;
            tv4.append(String.valueOf("\nWeight to lose : "+lose));
            LinearLayout hiddenLayout = (LinearLayout) findViewById(R.id.hiddenLayout);
            if (hiddenLayout == null) {
                //Inflate the Hidden Layout Information View
                LinearLayout myLayout = (LinearLayout) findViewById(R.id.linearLayout2);
                View hiddenInfo = getLayoutInflater().inflate(R.layout.hidden, myLayout, false);
                myLayout.addView(hiddenInfo);
            }
            Button button1 = (Button) findViewById(R.id.button1);
            final EditText editText1 = (EditText) findViewById(R.id.editText1);
            //Get References to the TextView
            final TextView TextView2 = (TextView) findViewById(R.id.textView2);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Update the TextView Text
                    String mnth = editText1.getText().toString();
                    if (TextUtils.isEmpty(mnth)) {
                        editText1.setError("Please enter your height");
                        editText1.requestFocus();
                        return;
                    }
                    int month = Integer.parseInt(mnth);
                    float permonth = lose / month;  //1.333
                    //final float kjtocal = (float) 0.2388;
                    //float kjmaint = weight * 140;
                    float kjpermonth = permonth * 35000; //
                    float kjperkm = (float) ((weight * 1 + idealW * 1) * 2); //161
                    float kmpermonth = kjpermonth / kjperkm;//289.855
                    float kmGoals = kmpermonth / 30;
                    float stepGoals = (int) (kmGoals * 1320);
                    TextView2.setText("Daily Goals :\nWalk - " + kmGoals  + "\n OR\nSteps - " + stepGoals);



                }
            });


        }
    }

    //Calculate BMI

    private float calculateBMI(float weight, float height) {
        return (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
