package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class comboset2 extends Fragment {

    private Button MinusButton;
    private Button PlusButton;
    private TextView ordertunapizza;
    private TextView ordercheesepasta;
    private TextView ordergrilledchicken_M;
    private TextView orderbeefsalad;
    private int countertunapizza;
    private int countercheesepasta;
    private int countergrilledchicken_M;
    private int counterbeefsalad;

    //add back to combo fragment button
    private Button BackToComFm;
    //tuna
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minustunapizza:
                    Minustunpizza();
                    break;
                case R.id.Plustunapizza:
                    Plusttunapizzad();
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
                    Pluscheesepasta ();
                    break;
            }
        }
    };
    //grilledchicken_M
    private View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusgrilledchicken_M:
                    Minusgrilledchicken_M();
                    break;
                case R.id.Plusgrilledchicken_M:
                    Plusgrilledchicken_M();
                    break;
            }
        }
    };
    //beefsalad
    private View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minusbeefsalad:
                    Minudbeefsalad();
                    break;
                case R.id.Plusbeefsalad:
                    Plusbeefsalad();
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comboset2, container, false);

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
        //add NextBtn
        Button NextBtn = (Button) view.findViewById(R.id.goToOtherFm);

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OthersMenuFragment());
                fr.commit();
            }
        });

        //tuna
        ordertunapizza = (TextView) view.findViewById(R.id.ordertunapizza);
        MinusButton = (Button) view.findViewById(R.id.Minustunapizza);
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Plustunapizza);
        PlusButton.setOnClickListener(clickListener1);
        initCounter1();
        //cheesepasta
        ordercheesepasta = (TextView) view.findViewById(R.id.ordercheesepasta);
        MinusButton = (Button) view.findViewById(R.id.Minuscheesepasta);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Pluscheesepasta);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();
        //grilledchicken_M
        ordergrilledchicken_M = (TextView) view.findViewById(R.id.ordergrilledchicken_M);
        MinusButton = (Button) view.findViewById(R.id.Minusgrilledchicken_M);
        MinusButton.setOnClickListener(clickListener3);
        PlusButton = (Button) view.findViewById(R.id.Plusgrilledchicken_M);
        PlusButton.setOnClickListener(clickListener3);
        initCounter3();
        //beefsalad
        orderbeefsalad = (TextView) view.findViewById(R.id.textview_orderbeefsalad);
        MinusButton = (Button) view.findViewById(R.id.Minusbeefsalad);
        MinusButton.setOnClickListener(clickListener4);
        PlusButton = (Button) view.findViewById(R.id.Plusbeefsalad);
        PlusButton.setOnClickListener(clickListener4);
        initCounter4();
        return view;
    }







    //tuna
    private void initCounter1(){
        countertunapizza=0;
        ordertunapizza.setText(countertunapizza+ "");
    }
    private void Plusttunapizzad(){
        countertunapizza++;
        ordertunapizza.setText(countertunapizza + "");
    }
    private void Minustunpizza(){
        countertunapizza--;
        ordertunapizza.setText(countertunapizza + "");
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
    //grilledchicken_M
    private void initCounter3(){
        countergrilledchicken_M=0;
        ordergrilledchicken_M.setText(countergrilledchicken_M+ "");
    }
    private void Plusgrilledchicken_M(){
        countergrilledchicken_M++;
        ordergrilledchicken_M.setText(countergrilledchicken_M + "");
    }
    private void Minusgrilledchicken_M(){
        countergrilledchicken_M--;
        ordergrilledchicken_M.setText(countergrilledchicken_M + "");
    }
    //beefsalad
    private void initCounter4(){
        counterbeefsalad=0;
        orderbeefsalad.setText(counterbeefsalad + "");
    }
    private void Plusbeefsalad(){
        counterbeefsalad++;
        orderbeefsalad.setText(counterbeefsalad + "");
    }
    private void Minudbeefsalad(){
        counterbeefsalad--;
        orderbeefsalad.setText(counterbeefsalad + "");
    }
}

