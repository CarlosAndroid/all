package com.codes.buttons;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.codes.R;

public class Buttons extends AppCompatActivity {

    FloatingActionButton button;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        context = this;

        button = (FloatingActionButton) findViewById(R.id.buttonFloatButtons);

            button.setOnClickListener(new FloatingActionButton.OnClickListener(){
                @Override
                public void onClick(View v){
                    Snackbar.make(v, "Acción realizada", Snackbar.LENGTH_LONG)
                            .setActionTextColor(ContextCompat.getColor(context, R.color.colorPrimaryLight))
                            .setAction("Deshacer", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.i("Snackbar", "Acción");
                                }
                            }).show();
                }
            }
        );
    }
}
