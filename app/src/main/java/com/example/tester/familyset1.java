package com.example.tester;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class familyset1 extends Fragment {
    private Button MinusButton;
    private Button PlusButton;
    private TextView ordercornpizza;
    private TextView ordercheesepastapasta;
    private TextView ordergrilledchicken_S;
    private int countercornpizza;
    private int countercheesepasta;
    private int countergrilledchicken_S;

    //add back to family fragment button
    private Button BackToFamFm;
    //corn
    private View.OnClickListener clickListener1 = new View.OnClickListener() {
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
    //cheesepasta
    private View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Minuscheesepasta:
                    Minuscheesepasta();
                    break;
                case R.id.Pluscheesepasta:
                    Plusfrenchfries_M();
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
        View view = inflater.inflate(R.layout.fragment_familyset1, container, false);

        //add method back to family fragment
        BackToFamFm = (Button) view.findViewById(R.id.backToFamFm1);

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
        //corn
        ordercornpizza = (TextView) view.findViewById(R.id.ordercornpizza);
        MinusButton = (Button) view.findViewById(R.id.Minuscornpizza);
        MinusButton.setOnClickListener(clickListener1);
        PlusButton = (Button) view.findViewById(R.id.Pluscornpizza);
        PlusButton.setOnClickListener(clickListener1);

        //cheesepasta
        ordercheesepastapasta = (TextView) view.findViewById(R.id.ordercheesepasta);
        MinusButton = (Button) view.findViewById(R.id.Minuscheesepasta);
        MinusButton.setOnClickListener(clickListener2);
        PlusButton = (Button) view.findViewById(R.id.Pluscheesepasta);
        PlusButton.setOnClickListener(clickListener2);
        initCounter2();


        //grilledchicken_S
        ordergrilledchicken_S = (TextView) view.findViewById(R.id.ordergrilledchicken_S);
        MinusButton = (Button) view.findViewById(R.id.Minusgrilledchicken_S);
        MinusButton.setOnClickListener(clickListener3);
        PlusButton = (Button) view.findViewById(R.id.Plusgrilledchicken_S);
        PlusButton.setOnClickListener(clickListener3);
        initCounter3();
        return view;

    }


    //corn
    private void initCounter1(){
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
    //cheesepasta
    private void initCounter2(){
        countercheesepasta=0;
        ordercheesepastapasta.setText(countercheesepasta + "");
    }
    private void Plusfrenchfries_M(){
        countercheesepasta++;
        ordercheesepastapasta.setText(countercheesepasta + "");
    }
    private void Minuscheesepasta(){
        countercheesepasta--;
        ordercheesepastapasta.setText(countercheesepasta + "");
    }
    //grilledchicken_S
    private void initCounter3(){
        countergrilledchicken_S=0;
        ordergrilledchicken_S.setText(countergrilledchicken_S + "");
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

