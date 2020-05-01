package com.example.tester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ComboFragment extends Fragment {

    private Button comboset1,comboset2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_combo, container, false);

        comboset1 = (Button) view.findViewById(R.id.comboset1_link);

        comboset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new comboset1());
                fr.commit();
            }
        }); //this button is not working

        comboset2 = (Button) view.findViewById(R.id.comboset2_link);

        comboset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new comboset2()); //if you want to change fragment to child fragment you have to add id to parent fragment container
                fr.commit();
            }
        });


        return view;
    }
}
