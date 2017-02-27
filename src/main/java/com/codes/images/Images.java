package com.codes.images;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.codes.R;
import com.codes.cardview.CardView;

/**
 * Created by Posti on 19/01/2017.
 */

public class Images extends CardView{

    private Context context;
    private final String TAG = "Images";
    private RadioGroup radioGroup;
    private ImageView imageView;
    private Bitmap bitmap2;
    private boolean flagZoom = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupImages);
        imageView = (ImageView) findViewById(R.id.imageViewImages);

        bitmap2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.city);
        context = this;
        final AnimatorSet animZoomIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.zoom_in);
        final AnimatorSet animZoomOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.zoom_out);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch(id){
                    case R.id.radioButtonCircularImages:
                        if(flagZoom == true){
                            animZoomOut.setTarget(imageView);
                            animZoomOut.start();
                            flagZoom = false;
                        }

                            Resources res = getResources();
                            Bitmap src = BitmapFactory.decodeResource(res, R.drawable.city);
                            RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, src);
                            dr.setCircular(true);
                            imageView.setImageDrawable(dr);

                        break;

                    case R.id.radioButton2:
                        setSepiaColor(imageView);
                        break;

                    case R.id.radioButton3:
                        setBlackAndWhiteColor(imageView);
                        break;

                    case R.id.radioButton4:
                        flagZoom = true;
                        animZoomIn.setTarget(imageView);
                        animZoomIn.start();
                }
            }
        });
    }


    public static void setSepiaColor(ImageView imageView) {
        if (imageView == null)
            return;

        Drawable drawable = imageView.getDrawable();

        final ColorMatrix matrixA = new ColorMatrix();
        // making image B&W
        matrixA.setSaturation(0);

        final ColorMatrix matrixB = new ColorMatrix();
        // applying scales for RGB color values
        matrixB.setScale(1f, .95f, .82f, 1.0f);
        matrixA.setConcat(matrixB, matrixA);

        final ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixA);
        //imageView.setColorFilter(filter);
        drawable.setColorFilter(filter);
    }

    private static void setBlackAndWhiteColor(ImageView imageView) {
        if (imageView == null)
            return;

        Drawable drawable = imageView.getDrawable();

        final ColorMatrix matrixA = new ColorMatrix();
        final ColorMatrix matrixB = new ColorMatrix();
        matrixA.setSaturation(0);

        final ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixA);
        //imageView.setColorFilter(filter);
        drawable.setColorFilter(filter);
    }
}
