package com.codes.sensors;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.codes.R;

import java.util.List;

public class Sensors extends AppCompatActivity{

    private SensorManager mSensorManager;
    private LinearLayout linearLayout;
    private Sensor sensorLight;
    private static String TAG = "Sensors";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutSensors);

        context = this;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            Button bt = new Button(this);
            bt.setText("Campo magnético");

            /*bt.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, Illuminance.class);
                    startActivity(i);
                }
            });
            linearLayout.addView(bt);*/
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            Button bt = new Button(this);
            bt.setText("Temperatura ambiente");
            linearLayout.addView(bt);
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null){
            Button bt = new Button(this);
            bt.setText("Iluminación");
            bt.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, Illuminance.class);
                    startActivity(i);
                }
            });
            linearLayout.addView(bt);
        }
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
    }




}
