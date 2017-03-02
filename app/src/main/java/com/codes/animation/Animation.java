package com.codes.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import com.codes.R;

public class Animation extends AppCompatActivity {

    private Button buttonRotation, buttonAlpha, buttonZoom, buttonPosition, buttonAccelerated, buttonStop;
    private AnimatorSet setRotation, setAlpha, setZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        buttonRotation = (Button) findViewById(R.id.buttonRotationAnimation);
        buttonAlpha = (Button) findViewById(R.id.buttonAlphaAnimation);
        buttonZoom = (Button) findViewById(R.id.buttonZoomAnimation);
        buttonPosition = (Button) findViewById(R.id.buttonPositionAnimation);
        buttonAccelerated = (Button) findViewById(R.id.buttonAcceleratedAnimation);
        buttonStop = (Button) findViewById(R.id.buttonStopAnimation);

        setRotation = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.rotation_animator);
        setAlpha = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.alpha_animator);
        setZoom = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.zoom_animator);
        //setRotation = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.rotation_animator);

        buttonStop.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                stopAnimations();
            }
        });

        buttonRotation.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                setRotation.setTarget(buttonRotation);
                setRotation.start();
            }
        });

        buttonAlpha.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                setAlpha.setTarget(buttonAlpha);
                setAlpha.start();
            }
        });

        buttonZoom.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                setZoom.setTarget(buttonZoom);
                setZoom.start();
            }
        });

        buttonPosition.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                int screenSize = metrics.widthPixels - buttonPosition.getWidth() - 40;

                ObjectAnimator oa = ObjectAnimator.ofFloat(buttonPosition, "translationX", 0, screenSize);
                oa.setDuration(1000);

                oa.start();
            }
        });

        buttonAccelerated.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                int screenSize = metrics.widthPixels - buttonAccelerated.getWidth() - 40;

                ObjectAnimator oa = ObjectAnimator.ofFloat(buttonAccelerated, "translationX", 0, screenSize);
                oa.setDuration(1000);
                oa.setInterpolator(new AccelerateInterpolator(1.5f));

                oa.start();
            }
        });

    }

    public void stopAnimations(){
        if(setRotation.isRunning()){
            setRotation.end();
        }

        if(setAlpha.isRunning()){
            setAlpha.cancel();
        }

        if(setZoom.isRunning()){
            setZoom.cancel();
        }
    }
}
