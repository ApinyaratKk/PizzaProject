package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class pizza extends Fragment {
    private Button MinusButton;
    private Button PlusButton;
    private TextView orderbeefpizza;
    private TextView orderbbqpizza;
    private TextView ordercornpizza;
    private TextView ordertunapizza;
    private int counterbeefpizza;
    private int counterbbqpizza;
    private int countercornpizza;
    private int countertunapizza;

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
    //bbq
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusbbqpizza:
                    Minusbbqpizza();
                    break;
                case R.id.Plusbbqpizza:
                    Plusbbqpizzae();
                    break;
            }
        }
    };
    //corn
    private View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minuscornpizza:
                    Minuscornpizzan();
                    break;
                case R.id.Pluscornpizza:
                    Pluscornpizza();
                    break;
            }
        }
    };
    //tuna
    private View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minustunapizza:
                    Minustunapizza();
                    break;
                case R.id.Plustunapizza:
                    Plustunapizza();
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);

        //beef
        orderbeefpizza = (TextView) view.findViewById(R.id.orderbeefpizza);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefpizza);
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Plusbeefpizza);
        PlusButton.setOnClickListener(clickListener1);
        initCounter1();
        //bbq
        orderbbqpizza = (TextView) view.findViewById(R.id.orderbbqpizza);
        MinusButton = (Button) view.findViewById(R.id.Minusbbqpizza);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Plusbbqpizza);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();
        //corn
        ordercornpizza = (TextView) view.findViewById(R.id.ordercornpizza);
        MinusButton = (Button) view.findViewById(R.id.Minuscornpizza);
        MinusButton.setOnClickListener(clickListener3);
        PlusButton = (Button) view.findViewById(R.id.Pluscornpizza);
        PlusButton.setOnClickListener(clickListener3);
        initCounter3();
        //tuna
        ordertunapizza = (TextView) view.findViewById(R.id.ordertunapizza);
        MinusButton = (Button) view.findViewById(R.id.Minustunapizza);
        MinusButton.setOnClickListener(clickListener4);
        PlusButton = (Button) view.findViewById(R.id.Plustunapizza);
        PlusButton.setOnClickListener(clickListener4);
        initCounter4();
        return view;
    }







    //beef
    private void initCounter1(){
        counterbeefpizza=0;
        orderbeefpizza.setText(counterbeefpizza + "");
    }
    private void Plusbeefpizza(){
        counterbeefpizza++;
        orderbeefpizza.setText(counterbeefpizza + "");
    }
    private void Minusbeefpizza(){
        counterbeefpizza--;
        orderbeefpizza.setText(counterbeefpizza + "");
    }
    //bbq
    private void initCounter2(){
        counterbbqpizza=0;
        orderbbqpizza.setText(counterbbqpizza + "");
    }
    private void Plusbbqpizzae(){
        counterbbqpizza++;
        orderbbqpizza.setText(counterbbqpizza+ "");
    }
    private void Minusbbqpizza(){
        counterbbqpizza--;
        orderbbqpizza.setText(counterbbqpizza + "");
    }
    //corn
    private void initCounter3(){
        countercornpizza=0;
        ordercornpizza.setText(countercornpizza + "");
    }
    private void Pluscornpizza(){
        countercornpizza++;
        ordercornpizza.setText(countercornpizza + "");
    }
    private void Minuscornpizzan(){
        countercornpizza--;
        ordercornpizza.setText(countercornpizza + "");
    }
    //tuna
    private void initCounter4(){
        countertunapizza=0;
        ordertunapizza.setText(countertunapizza+ "");
    }
    private void Plustunapizza(){
        countertunapizza++;
        ordertunapizza.setText(countertunapizza + "");
    }
    private void Minustunapizza(){
        countertunapizza--;
        ordertunapizza.setText(countertunapizza + "");
    }
}

