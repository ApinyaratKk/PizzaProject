package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class salad extends Fragment {
    private Button MinusButton;
    private Button PlusButton;
    private TextView ordersalmonsalad;
    private TextView orderbeefsalad;
    private int countersalmonsalad;
    private int counterbeefsalad;

    //add this button
    private Button BackToOtherFm;

    //salmonsalad
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minussalmonsalad:
                    Minussalmonsalad();
                    break;
                case R.id.Plussalmonsalad:
                    Plussalmonsalad();
                    break;
            }
        }
    };
    //beefsalad
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusbeefsalad:
                    Minusbeefsalad();
                    break;
                case R.id.Plusbeefsalad:
                    Plusbeefsalad();
                    break;
            }
        }
    };


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salad, container, false);

        //add back to other fragment Button
        BackToOtherFm = (Button) view.findViewById(R.id.backToOtherFm);

        BackToOtherFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OthersMenuFragment());
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

        //salmonsalad
        ordersalmonsalad = (TextView) view.findViewById(R.id.textview_ordersalmonsalad);
        MinusButton = (Button) view.findViewById(R.id.Minussalmonsalad);
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Plussalmonsalad);
        PlusButton.setOnClickListener(clickListener1);
        initCounter1();

        //beefsalad
        orderbeefsalad = (TextView) view.findViewById(R.id.textview_orderbeefsalad);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefsalad);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Plusbeefsalad);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();
        return view;
    }





    //salmonsalad
    private void initCounter1(){
        countersalmonsalad=0;
        ordersalmonsalad.setText(countersalmonsalad + "");
    }
    private void Plussalmonsalad(){
        countersalmonsalad++;
        ordersalmonsalad.setText(countersalmonsalad + "");
    }
    private void Minussalmonsalad(){
        countersalmonsalad--;
        ordersalmonsalad.setText(countersalmonsalad + "");
    }
    //beefsalad
    private void initCounter2(){
        counterbeefsalad=0;
        orderbeefsalad.setText(counterbeefsalad + "");
    }
    private void Plusbeefsalad(){
        counterbeefsalad++;
        orderbeefsalad.setText(counterbeefsalad + "");
    }
    private void Minusbeefsalad(){
        counterbeefsalad--;
        orderbeefsalad.setText(counterbeefsalad + "");
    }
}

