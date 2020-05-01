package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class chicken extends Fragment {
    private Button MinusButton;
    private Button PlusButton;
    private TextView orderfriedchicken_S;
    private TextView orderfriedchicken_M;
    private TextView ordergrilledchicken_S;
    private TextView ordergrilledchicken_M;
    private int counterfriedchicken_S;
    private int counterfriedchicken_M;
    private int countergrilledchicken_S;
    private int countergrilledchicken_M;

    //friedchicken_S
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusfriedchicken_S:
                    Minusfriedchicken_S();
                    break;
                case R.id.Plusfriedchicken_S:
                    Plusfriedchicken_S();
                    break;
            }
        }
    };
    //friedchicken_M
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
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
    //grilledchicken_M
    private View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusgrilledchicken_M:
                    Minustropicalseafood();
                    break;
                case R.id.Plusgrilledchicken_M:
                    Plusgrilledchicken_M();
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chicken, container, false);
        //add button
        Button backToOtherFm = (Button) view.findViewById(R.id.goToOtherFm) ;
        try{
            backToOtherFm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container,new OthersMenuFragment());
                    fr.commit();
                }
            });
        }catch (NullPointerException ignored){

        }


        Button goToOrderFm = (Button) view.findViewById(R.id.goToOrderFm) ;
        goToOrderFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OrderFragment());
                fr.commit();
            }
        });

        //beef
        orderfriedchicken_S = (TextView) view.findViewById(R.id.orderfriedchicken_S);
        MinusButton = (Button) view.findViewById(R.id.Minusfriedchicken_S);
        try{
            MinusButton.setOnClickListener(clickListener1);
        }catch(NullPointerException ignored){

        }

        PlusButton = (Button) view.findViewById(R.id.Plusfriedchicken_S);
        try{
            PlusButton.setOnClickListener(clickListener1);
        }catch(NullPointerException ignored){

        }

        initCounter1();
        //friedchicken_M
        orderfriedchicken_M = (TextView) view.findViewById(R.id.orderfriedchicken_M);
        MinusButton = (Button) view.findViewById(R.id.Minusfriedchicken_M);
        try{
            MinusButton.setOnClickListener(clickListener2);
        }catch(NullPointerException ignored){

        }

        PlusButton = (Button) view.findViewById(R.id.Plusfriedchicken_M);
        try{
            PlusButton.setOnClickListener(clickListener2);
        }catch(NullPointerException ignored){

        }

        initCounter2();
        //grilledchicken_S
        ordergrilledchicken_S = (TextView) view.findViewById(R.id.ordergrilledchicken_S);
        MinusButton = (Button) view.findViewById(R.id.Minusgrilledchicken_S);
        try{
            MinusButton.setOnClickListener(clickListener3);
        }catch(NullPointerException ignored){

        }

        PlusButton = (Button) view.findViewById(R.id.Plusgrilledchicken_S);
        try{
            PlusButton.setOnClickListener(clickListener3);
        }catch(NullPointerException ignored){

        }

        initCounter3();
        //grilledchicken_M
        ordergrilledchicken_M = (TextView) view.findViewById(R.id.ordergrilledchicken_M);
        MinusButton = (Button) view.findViewById(R.id.Minusgrilledchicken_M);
        try{
            MinusButton.setOnClickListener(clickListener4);
        }catch(NullPointerException ignored){

        }

        PlusButton = (Button) view.findViewById(R.id.Plusgrilledchicken_M);
        try{
            PlusButton.setOnClickListener(clickListener4);
        }catch(NullPointerException ignored){

        }

        initCounter4();
        return view;
    }







    //friedchicken_S
    private void initCounter1(){
        counterfriedchicken_S=0;
        try{
            orderfriedchicken_S.setText(counterfriedchicken_S + "");
        }catch(NullPointerException ignored){

        }

    }
    private void Plusfriedchicken_S(){
        counterfriedchicken_S++;
        try{
            orderfriedchicken_S.setText(counterfriedchicken_S + "");
        }catch(NullPointerException ignored){

        }

    }
    private void Minusfriedchicken_S(){
        counterfriedchicken_S--;
        try{
            orderfriedchicken_S.setText(counterfriedchicken_S + "");
        }catch(NullPointerException ignored){

        }

    }
    //friedchicken_M
    private void initCounter2(){
        counterfriedchicken_M=0;
        try{
            orderfriedchicken_M.setText(counterfriedchicken_M + "");
        }catch(NullPointerException ignored){

        }

    }
    private void Plusbbqpizzae(){
        counterfriedchicken_M++;
        try{
            orderfriedchicken_M.setText(counterfriedchicken_M+ "");
        }catch(NullPointerException ignored){

        }

    }
    private void Minusfriedchicken_M(){
        counterfriedchicken_M--;
        try{
            orderfriedchicken_M.setText(counterfriedchicken_M + "");
        }catch(NullPointerException ignored){

        }

    }
    //grilledchicken_S
    private void initCounter3(){
        countergrilledchicken_S=0;
        try{
            ordergrilledchicken_S.setText(countergrilledchicken_S + "");
        }catch(NullPointerException ignored){

        }

    }
    private void Plusgrilledchicken_S(){
        countergrilledchicken_S++;
        try{
            ordergrilledchicken_S.setText(countergrilledchicken_S + "");
        }catch(NullPointerException ignored){

        }

    }
    private void Minusgrilledchicken_S(){
        countergrilledchicken_S--;
        try{
            ordergrilledchicken_S.setText(countergrilledchicken_S + "");
        }catch(NullPointerException ignored){

        }

    }
    //grilledchicken_M
    private void initCounter4(){
        countergrilledchicken_M=0;
        try{
            ordergrilledchicken_M.setText(countergrilledchicken_M+ "");
        }catch(NullPointerException ignored){

        }

    }
    private void Plusgrilledchicken_M(){
        countergrilledchicken_M++;
        try{
            ordergrilledchicken_M.setText(countergrilledchicken_M + "");
        }catch(NullPointerException ignored){

        }

    }
    private void Minustropicalseafood(){
        countergrilledchicken_M--;
        try{
            ordergrilledchicken_M.setText(countergrilledchicken_M + "");
        }catch(NullPointerException ignored){

        }

    }
}