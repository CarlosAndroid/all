package com.codes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codes.animation.Animation;
import com.codes.images.Images;
import com.codes.buttons.Buttons;
import com.codes.camera.CameraRecord;
import com.codes.cardview.CardView;
import com.codes.fragment.Fragments;
import com.codes.map.Map;
import com.codes.sensors.Sensors;
import com.codes.toolbar.Toolbars;

public class MainActivity extends AppCompatActivity {

    private Button buttonBotones, buttonToolbar, buttonFragments, buttonCardView, buttonSensors,
            buttonAnimation, buttonLocation, buttonCamera, buttonBattery;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.prueba1);

        context = this;
        buttonBotones = (Button) findViewById(R.id.buttonBotonesMain);
        buttonToolbar = (Button) findViewById(R.id.buttonToolbarMain);
        buttonFragments = (Button) findViewById(R.id.buttonFragmentMain);
        buttonCardView = (Button) findViewById(R.id.buttonCardView);
        buttonSensors = (Button) findViewById(R.id.buttonSensorsMain);
        buttonAnimation = (Button) findViewById(R.id.buttonAnimationMain);
        buttonLocation = (Button) findViewById(R.id.buttonLocationMain);
        buttonCamera = (Button) findViewById(R.id.buttonCameraMain);
        buttonBattery = (Button) findViewById(R.id.buttonBatteryMain);

        buttonBotones.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Buttons.class);
                startActivity(i);
            }
        });

        buttonToolbar.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Toolbars.class);
                startActivity(i);
            }
        });

        buttonFragments.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Fragments.class);
                startActivity(i);
            }
        });

        buttonCardView.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CardView.class);
                startActivity(i);
            }
        });

        buttonSensors.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Sensors.class);
                startActivity(i);
            }
        });

        buttonAnimation.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Animation.class);
                startActivity(i);
            }
        });

        buttonLocation.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Map.class);
                startActivity(i);
            }
        });

        buttonCamera.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CameraRecord.class);
                startActivity(i);
            }
        });

        buttonBattery.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Images.class);
                startActivity(i);
            }
        });

    }
}
