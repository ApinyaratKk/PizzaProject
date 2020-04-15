package com.example.tester;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static android.widget.Toast.makeText;


public class RegisterFragment extends Fragment {

    private EditText Username,Cardnumber,Password;
    private Button registerButton;

    //FirebaseDatabase rootNode;
    //DatabaseReference RootRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false); //open fragment activity

        Username = (EditText) view.findViewById(R.id.user_editText);
        Cardnumber = (EditText) view.findViewById(R.id.card_editText);
        Password = (EditText) view.findViewById(R.id.password_editText);
        registerButton = (Button) view.findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });

        return view;

    }
    private void CreateAccount(){
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String card = Cardnumber.getText().toString();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(getActivity(),"Please enter your username",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(),"Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(card)){
            Toast.makeText(getActivity(),"Please enter your card number", Toast.LENGTH_SHORT).show();
        }
        else{
            Validate(username,password,card);
        }
    }
    //after press the register button validate method doesn't appear

    private void Validate(final String username, final String card, final String password){
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() { //change from add singlevalue blahblah
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(username).exists())){
                    HashMap<String,Object> userdataMap = new HashMap<>();
                    userdataMap.put("Username",username);
                    userdataMap.put("Password",password);
                    userdataMap.put("Card No.",card);

                    RootRef.child("Users").child(username).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(getActivity(),"Congratulation, your account has been created.",Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(getActivity(),"Error, Please try again",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(getActivity(),"This username was taken", Toast.LENGTH_SHORT).show();

                    Toast.makeText(getActivity(),"Please try again using another username", Toast.LENGTH_SHORT).show();

                    Intent intent =  new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
