package com.codes.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codes.R;

public class FragmentB extends Fragment {

    View rootView;
    TextView textViewContador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_b, container, false);
        textViewContador = (TextView) rootView.findViewById(R.id.textViewFragmentB);

        return rootView;
    }

    public void cambiarTexto(String cad){
        if(cad!=null){
            textViewContador.setText(cad);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
