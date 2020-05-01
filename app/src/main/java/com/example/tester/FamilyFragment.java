package com.example.tester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FamilyFragment extends Fragment {

    private Button familyset1,familyset2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_family, container, false);

        Button familyset1 = (Button)view.findViewById(R.id.familyset1_link);

        familyset1.setOnClickListener(new View.OnClickListener() { //change into flash deal fragment
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new familyset1());
                fr.commit();
            }
        });

        Button familyset2 = (Button) view.findViewById(R.id.familyset2_link);

        familyset2.setOnClickListener(new View.OnClickListener() { //change into flash deal fragment
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new familyset2()); //if you want to change fragment to child fragment you have to add id to parent fragment container
                fr.commit();
            }
        });// this button is already work

        return view;
    }
}
