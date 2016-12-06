package com.example.mac.infolab;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Archita on 12-07-2016.
 */
public class FirstActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView count;
    boolean activityRunning;

    private TextView textView;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;
    private int i;
    private int a;
    private double b;

    private Button Start;
    private Button Display;
    private TextView textView2;
    private TextView textView5;
    private float x1, x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_secondd);

        count = (TextView) findViewById(R.id.count);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        textView = (TextView) findViewById(R.id.textView1);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);


        Start = (Button) findViewById(R.id.button);
        Display = (Button) findViewById(R.id.button2);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView5 = (TextView) findViewById(R.id.textView5);
        ImageView image = (ImageView) findViewById(R.id.imageView);


    }



    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            textView.setText("TOTAL STEPS : " + value);
        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // For test only. Only allowed value is 1.0 i.e. for step taken
            textView.setText("TOTAL STEPS : " + value);
        }

        final int finalValue = value;
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = finalValue;
                Toast.makeText(FirstActivity.this, "YOUR STEPS ARE BEING RECORDED!", Toast.LENGTH_LONG).show();


            }
        });
        final int finalValue1 = value;
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = finalValue1 - i;
                textView2.setText("STEPS WALKED TODAY : " + a);
                b = (a * 0.762) / 1000;
                textView5.setText("TOTAL DISTANCE(km) : " + b);


            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_FASTEST);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
            mSensorManager.registerListener(this, mStepCounterSensor,

                    SensorManager.SENSOR_DELAY_FASTEST);
            mSensorManager.registerListener(this, mStepDetectorSensor,

                    SensorManager.SENSOR_DELAY_FASTEST); mSensorManager.registerListener(this, mStepCounterSensor,

                    SensorManager.SENSOR_DELAY_FASTEST);
            mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_FASTEST);
        }


    }


    @Override
    protected void onPause()
    {
        super.onPause();
        activityRunning = false;
// if you unregister the last listener, the hardware will stop detecting step events
// sensorManager.unregisterListener(this);
    }




    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
    }


}