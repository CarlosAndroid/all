package com.codes.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.codes.R;

public class Fragments extends AppCompatActivity implements Comunicador{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

    }

    @Override
    public void responder(String datos) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragmentBFragments);
        fragmentB.cambiarTexto(datos);
    }
}
