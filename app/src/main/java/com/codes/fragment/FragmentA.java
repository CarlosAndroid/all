package com.codes.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.codes.R;

public class FragmentA extends Fragment {

    View rootView;
    Button button;
    int contador = 0;
    Comunicador comunicador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_a, container, false);
        button = (Button) rootView.findViewById(R.id.buttonFragment1);

        comunicador = (Comunicador) getActivity();

        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                View detailsFrame = getActivity().findViewById(R.id.fragmentBFragments);
                boolean mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

                if(mDualPane){
                    contador++;
                    comunicador.responder("Pulsaciones: " +contador);
                }

                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Gire la pantalla", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}


