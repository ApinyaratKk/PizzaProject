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
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button flashDealBtn = (Button)view.findViewById(R.id.flashDealBtn);

        flashDealBtn.setOnClickListener(new View.OnClickListener() { //change into flash deal fragment
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new FlashDealFragment());
                fr.commit();
            }
        });

        Button comboBtn = (Button)view.findViewById(R.id.comboBtn); //change into Combo set fragment

        comboBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new ComboFragment());
                fr.commit();
            }
        });

        Button pizzaBtn = (Button)view.findViewById(R.id.pizzaMenuBtn); //change into pizza menu fragment

        pizzaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new pizza());
                fr.commit();
            }
        });

        Button familyBtn = (Button)view.findViewById(R.id.drinksMenuBtn); //change into drinks menu fragment

        familyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new FamilyFragment());
                fr.commit();
            }
        });

        Button othersBtn = (Button)view.findViewById(R.id.othersMenuBtn); //change into others menu fragment

        othersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OthersMenuFragment());
                fr.commit();
            }
        });

        return view;
    }
}
