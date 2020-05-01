package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class comboset1 extends Fragment {

    private Button MinusButton;
    private Button PlusButton;
    private TextView orderbeefpizza;
    private TextView orderbeefpasta;
    private TextView ordersalmonsalad;
    private TextView orderfriedchicken_M;
    private int counterbeefpizza;
    private int counterbeefpasta;
    private int counterfriedchicken_M;
    private int countersalmonsalad;

    //add back to combo fragment button
    private Button BackToComFm;

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
    //friedchicken_M
    private View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusfriedchicken_M:
                    Minusfriedchicken_M();
                    break;
                case R.id.Plusfriedchicken_M:
                    Plusbbqpizzae();
                    break;
            }
        }
    };
    //salmonsalad
    private View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minussalmonsalad:
                    Plussalmonsalad();
                    break;
                case R.id.Plussalmonsalad:
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comboset1, container, false);

        //add method back to family fragment
        BackToComFm = (Button) view.findViewById(R.id.backToComFm);

        BackToComFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new ComboFragment());
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
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Plusbeefpizza);
        PlusButton.setOnClickListener(clickListener1);
        initCounter1();
        //beefpasta
        orderbeefpasta = (TextView) view.findViewById(R.id.orderbeefpasta);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefpasta);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Plusbeefpasta);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();
        //friedchicken_M
        orderfriedchicken_M = (TextView) view.findViewById(R.id.orderfriedchicken_M);
        MinusButton = (Button) view.findViewById(R.id.Minusfriedchicken_M);
        MinusButton.setOnClickListener(clickListener3);
        PlusButton = (Button) view.findViewById(R.id.Plusfriedchicken_M);
        PlusButton.setOnClickListener(clickListener3);
        initCounter3();
        //salmonsalad
        ordersalmonsalad = (TextView) view.findViewById(R.id.textview_ordersalmonsalad);
        MinusButton = (Button) view.findViewById(R.id.Minussalmonsalad);
        MinusButton.setOnClickListener(clickListener4);
        PlusButton = (Button) view.findViewById(R.id.Plussalmonsalad);
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
    //beefpasta
    private void initCounter2(){
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
    //friedchicken_M
    private void initCounter3(){
        counterfriedchicken_M=0;
        orderfriedchicken_M.setText(counterfriedchicken_M + "");
    }
    private void Plusbbqpizzae(){
        counterfriedchicken_M++;
        orderfriedchicken_M.setText(counterfriedchicken_M+ "");
    }
    private void Minusfriedchicken_M(){
        counterfriedchicken_M--;
        orderfriedchicken_M.setText(counterfriedchicken_M + "");
    }
    //salmonsalad
    private void initCounter4(){
        countersalmonsalad=0;
        try{
            ordersalmonsalad.setText(countersalmonsalad + "");
        }catch (NullPointerException ignored) {

        }
    }
    private void Plussalmonsalad(){
        countersalmonsalad++;
        ordersalmonsalad.setText(countersalmonsalad + "");
    }
    private void MinussalmonSalad(){
        countersalmonsalad--;
        ordersalmonsalad.setText(countersalmonsalad + "");
    }
}

