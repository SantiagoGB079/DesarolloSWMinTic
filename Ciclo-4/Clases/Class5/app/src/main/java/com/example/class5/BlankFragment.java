package com.example.class5;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    public static final int YES = 1;
    public static final int NO = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
        TextView termino = rootView.findViewById(R.id.tv_uno);
        TextView texto = rootView.findViewById(R.id.tv_dos);
        TextView mensaje = rootView.findViewById(R.id.tv_tres);
        Button terminos = rootView.findViewById(R.id.btnTerminos);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);

                switch (index) {
                    case YES:
                        mensaje.setVisibility(View.VISIBLE);
                        texto.setText(R.string.siMessage);
                        initAuxiliar();

                        break;

                    case NO:
                        mensaje.setVisibility(View.INVISIBLE);
                        texto.setText(R.string.noMessage);
                        break;

                    default:
                        break;
                }
            }
        });

        terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setVisibility(View.VISIBLE);
                texto.setText(R.string.terminos);

            }
        });

        return rootView;
    }

    public void initAuxiliar() {
        Intent intent = new Intent(getContext(), Date.class);
        startActivity(intent);

    }

}