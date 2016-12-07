package com.example.mac.infolab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by mac on 06/12/16.
 */

public class Monitor extends AppCompatActivity {
    public static String mUserId;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    public  String FIREBASE_URL= "https://hello-595eb.firebaseio.com/";
    public static ArrayList<firebasedata> RetrievedData;
    ArrayList<String>KeysForRetrievedData;
    TextView text;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_activity);
        text = (TextView)findViewById(R.id.s_text);
        p=(ProgressBar)findViewById(R.id.progressBar1);
        p.setVisibility(View.VISIBLE);
        Firebase.setAndroidContext(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mUserId = mFirebaseUser.getUid();

        Firebase ref = new Firebase(FIREBASE_URL);
        Firebase neft=  ref.child("users").child(mUserId);

        RetrievedData=new ArrayList<>();
        KeysForRetrievedData=new ArrayList<>();
        neft.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                RetrievedData=new ArrayList<>();
                KeysForRetrievedData=new ArrayList<>();
                Log.e("Count!!!!!!!!!!" ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    String key=postSnapshot.getKey();
                    Log.e("key:  ",key);
                    firebasedata post = postSnapshot.getValue(firebasedata.class);
                    text.setText(text.getText().toString().trim()+"\n"+"DATE :-"+post.getDate()+"\n"+"WEIGHT :-"+post.getWeight()+"\n"+"HEIGHT :-"+post.getheight()+"\n"+"CALORIES :-"+post.getCalories()+"\n"+"KM RUN :-"+post.getkm());
                    RetrievedData.add(post);
                    KeysForRetrievedData.add(key);
                }
                   p.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("The read failed: " ,firebaseError.getMessage());
            }
        });

        neft.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                RetrievedData=new ArrayList<>();
                KeysForRetrievedData=new ArrayList<>();
                Log.e("Count!!!!!!!!!!" ,""+snapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    String key=postSnapshot.getKey();
                    Log.e("key:  ",key);
                    firebasedata post = postSnapshot.getValue(firebasedata.class);

                    RetrievedData.add(post);
                    KeysForRetrievedData.add(key);
                }

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("The read failed: " ,firebaseError.getMessage());
            }
        });




    }

}
