package com.example.tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class drink extends Fragment {
    private Button MinusButton;
    private Button PlusButton;
    private TextView orderpepsi;
    private TextView ordersprite;
    private TextView orderwater;
    private TextView ordercokezero;
    private int counterpepsi;
    private int countersprite;
    private int countercokezero;
    private int counterwater;

    //add back to combo fragment button
    private Button BackToOtherFm;


    //pepsi_S
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minuspepsi:
                    Minuspepsi();
                    break;
                case R.id.Pluspepsi:
                    Pluspepsi();
                    break;
            }
        }
    };
    //sprite
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minussprite:
                    Minussprite();
                    break;
                case R.id.Plussprite:
                    Plussprite();
                    break;
            }
        }
    };
    //cokezero
    private View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minuscokezero:
                    Minuscokezero();
                    break;
                case R.id.Pluscokezero:
                    Pluscokezero();
                    break;
            }
        }
    };
    //water
    private View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minuswater:
                    Minuswater();
                    break;
                case R.id.Plusswater:
                    Pluswater();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drink, container, false);

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
    //add button to order fragment
        Button goToOrderFm = (Button) view.findViewById(R.id.goToOrderFm);
        goToOrderFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new OrderFragment());
                fr.commit();
            }
        });
        //orderpepsi
        orderpepsi = (TextView) view.findViewById(R.id.orderpepsi);
        MinusButton = (Button) view.findViewById(R.id.Minuspepsi);
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Pluspepsi);
        PlusButton.setOnClickListener(clickListener1);
        initCounter1();
        //ordersprite
        ordersprite = (TextView) view.findViewById(R.id.ordersprite);
        MinusButton = (Button) view.findViewById(R.id.Minussprite);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Plussprite);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();
        //ordercokezero
        ordercokezero = (TextView) view.findViewById(R.id.ordercokezero);
        MinusButton = (Button) view.findViewById(R.id.Minuscokezero);
        MinusButton.setOnClickListener(clickListener3);
        PlusButton = (Button) view.findViewById(R.id.Pluscokezero);
        PlusButton.setOnClickListener(clickListener3);
        initCounter3();
        //water
        orderwater = (TextView) view.findViewById(R.id.orderwater);
        MinusButton = (Button) view.findViewById(R.id.Minuswater);
        MinusButton.setOnClickListener(clickListener4);
        PlusButton = (Button) view.findViewById(R.id.Plusswater);
        PlusButton.setOnClickListener(clickListener4);
        initCounter4();

        return view;
    }


    //pepsi
    private void initCounter1(){
        counterpepsi=0;
        orderpepsi.setText(counterpepsi+ "");
    }
    private void Pluspepsi(){
        counterpepsi++;
        orderpepsi.setText(counterpepsi + "");
    }
    private void Minuspepsi(){
        counterpepsi--;
        orderpepsi.setText(counterpepsi+ "");
    }
    //sprite
    private void initCounter2(){
        countersprite=0;
        ordersprite.setText(countersprite + "");
    }
    private void Plussprite(){
        countersprite++;
        ordersprite.setText(countersprite + "");
    }
    private void Minussprite(){
        countersprite--;
        ordersprite.setText(countersprite + "");
    }
    //cokezero
    private void initCounter3(){
        countercokezero=0;
        ordercokezero.setText(countercokezero + "");
    }
    private void Pluscokezero(){
        countercokezero++;
        ordercokezero.setText(countercokezero + "");
    }
    private void Minuscokezero(){
        countercokezero--;
        ordercokezero.setText(countercokezero + "");
    }
    //water
    private void initCounter4(){
        counterwater=0;
        orderwater.setText(counterwater + "");
    }
    private void Pluswater(){
        counterwater++;
        orderwater.setText(counterwater + "");
    }
    private void Minuswater(){
        counterwater--;
        orderwater.setText(counterwater + "");
    }
}
