package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class pasta extends Fragment {

    private Button MinusButton;
    private Button PlusButton;
    private TextView ordercheesepasta;
    private TextView orderbeefpasta;
    private int counterbeefpasta;
    private int countercheesepasta;

    //beefpasta
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
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
    //cheesepasta
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minuscheesepasta:
                    Minuscheesepasta();
                    break;
                case R.id.Pluscheesepasta:
                    Pluscheesepasta();
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pasta, container, false);

        //beefpasta
        orderbeefpasta = (TextView) view.findViewById(R.id.orderbeefpasta);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefpasta);
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Plusbeefpasta);
        PlusButton.setOnClickListener(clickListener1);
        initCounter1();

        //cheesepasta
        ordercheesepasta = (TextView) view.findViewById(R.id.ordercheesepasta);
        MinusButton = (Button) view.findViewById(R.id.Minuscheesepasta);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Pluscheesepasta);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();
        return view;
    }





    //beefpasta
    private void initCounter1(){
        counterbeefpasta=0;
        orderbeefpasta.setText(counterbeefpasta + "");
    }
    private void Plusbeefpasta(){
        counterbeefpasta++;
        orderbeefpasta.setText(counterbeefpasta + "");
    }
    private void Minusbeefpasta(){
        counterbeefpasta--;
        orderbeefpasta.setText(counterbeefpasta + "");
    }
    //cheesepasta
    private void initCounter2(){
        countercheesepasta=0;
        ordercheesepasta.setText(countercheesepasta + "");
    }
    private void Pluscheesepasta(){
        countercheesepasta++;
        ordercheesepasta.setText(countercheesepasta + "");
    }
    private void Minuscheesepasta(){
        countercheesepasta--;
        ordercheesepasta.setText(countercheesepasta + "");
    }
}

