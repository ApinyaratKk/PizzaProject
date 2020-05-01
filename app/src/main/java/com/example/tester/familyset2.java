package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class familyset2 extends Fragment {
    private Button MinusButton;
    private Button PlusButton;
    private TextView orderbeefpizza;
    private TextView orderbeefpasta;
    private TextView ordergrilledchicken_S;
    private int counterbeefpasta;
    private int counterbeefpizza;
    private int countergrilledchicken_S;

    //add back to family fragment button
    private Button BackToFamFm;

    //beef
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusbeefpizza:
                    Minusbeefpizza();
                    break;
                case R.id.Plusbeefpizza:
                    Plusbeefpizza();
                    break;
            }
        }
    };
    //beefpasta
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusbeefpasta:
                    Minusbeefpasta();
                    break;
                case R.id.Plusbeefpasta:
                    Plusbeefpasta();
                    break;
            }
        }
    };
    //grilledchicken_S
    private View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusgrilledchicken_S:
                    Minusgrilledchicken_S();
                    break;
                case R.id.Plusgrilledchicken_S:
                    Plusgrilledchicken_S();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_familyset2, container, false);

        //add method back to family fragment
        BackToFamFm = (Button) view.findViewById(R.id.backToFamFm2);

        BackToFamFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new FamilyFragment());
                fr.commit();
            }
        });

        //add nextBtn
        Button NextBtn = (Button) view.findViewById(R.id.goToOtherFm);

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OthersMenuFragment());
                fr.commit();
            }
        });

        //beef
        orderbeefpizza = (TextView) view.findViewById(R.id.orderbeefpizza);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefpizza);
        try {
            MinusButton.setOnClickListener(clickListener1);
        }catch (NullPointerException ignored){

        }

        //error said NullPointerException
        PlusButton = (Button) view.findViewById(R.id.Plusbeefpizza);
        try {
            PlusButton.setOnClickListener(clickListener1);
        }catch (NullPointerException ignored){

        }
        initCounter1();

        //beefpasta
        orderbeefpasta = (TextView) view.findViewById(R.id.orderbeefpasta);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefpasta);
        try {
            MinusButton.setOnClickListener(clickListener2);
        }catch (NullPointerException ignored){

        }

        PlusButton = (Button) view.findViewById(R.id.Plusbeefpasta);
        try {
            PlusButton.setOnClickListener(clickListener2);
        }catch (NullPointerException ignored){

        }

        initCounter2();

        //grilledchicken_S
        ordergrilledchicken_S = (TextView) view.findViewById(R.id.ordergrilledchicken_S);
        MinusButton = (Button) view.findViewById(R.id.Minusgrilledchicken_S);
        try {
            MinusButton.setOnClickListener(clickListener3);
        }catch (NullPointerException ignored){

        }

        PlusButton = (Button) view.findViewById(R.id.Plusgrilledchicken_S);
        try {
            PlusButton.setOnClickListener(clickListener3);
        }catch (NullPointerException ignored){

        }

        initCounter3();
        return view;

    }

    
    //beef
    private void initCounter1(){
        counterbeefpizza=0;
        try {
            orderbeefpizza.setText(counterbeefpizza + "");
        }catch (NullPointerException ignored){

        }

    }
    private void Plusbeefpizza(){
        counterbeefpizza++;
        orderbeefpizza.setText(counterbeefpizza + "");
    }
    private void Minusbeefpizza(){
        counterbeefpizza--;
        orderbeefpizza.setText(counterbeefpizza + "");
    }
    //beefpasta
    private void initCounter2(){
        counterbeefpasta=0;
        try {
            orderbeefpasta.setText(counterbeefpasta + "");
        }catch (NullPointerException ignored){

        }

    }
    private void Plusbeefpasta(){
        counterbeefpasta++;
        orderbeefpasta.setText(counterbeefpasta + "");
    }
    private void Minusbeefpasta(){
        counterbeefpasta--;
        orderbeefpasta.setText(counterbeefpasta + "");
    }
    //grilledchicken_S
    private void initCounter3(){
        countergrilledchicken_S=0;
        try {
            ordergrilledchicken_S.setText(countergrilledchicken_S + "");
        }catch (NullPointerException ignored){

        }

    }
    private void Plusgrilledchicken_S(){
        countergrilledchicken_S++;
        ordergrilledchicken_S.setText(countergrilledchicken_S + "");
    }
    private void Minusgrilledchicken_S(){
        countergrilledchicken_S--;
        ordergrilledchicken_S.setText(countergrilledchicken_S + "");
    }
}

