package com.example.tester;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OthersMenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_others_menu, container, false);

        Button SaladBtn = (Button) view.findViewById(R.id.saladFm_link);
        SaladBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new salad());
                fr.commit();
            }
        });

        Button DrinksBtn = (Button) view.findViewById(R.id.drinksFm_link);
        DrinksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new drink());
                fr.commit();
            }
        });

        Button ChickenBtn = (Button) view.findViewById(R.id.chickenFm_link);
        ChickenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new chicken());
                fr.commit();
            }
        });

        Button goToOrderFm = (Button) view.findViewById(R.id.goToOrderFm);
        goToOrderFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OrderFragment());
                fr.commit();
            }
        });

        return view;
    }
}
