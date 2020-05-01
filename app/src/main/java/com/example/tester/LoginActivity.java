package com.example.tester;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tester.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity { //just deleted this out (implements View.OnClickListener)

    private Button LoginButton;
    private EditText Username,Password; //changed from user_editText and password_editText
    private TextView userRegistration;

    private String parentData = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Username = (EditText) findViewById(R.id.user_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        LoginButton = (Button) findViewById(R.id.login_button);
        userRegistration = (TextView) findViewById(R.id.registerLink); //go to register page

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });


    }

    private void LoginUser(){
        String username = Username.getText().toString();
        String password = Password.getText().toString();

        if (TextUtils.isEmpty(username)){
            Toast.makeText(this,"Please enter your username", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else {
            AllowAccessToAccount(username,password);
        }
    }

    private void AllowAccessToAccount(final String username, final String password){
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentData).child(username).exists()){
                    Users userData = dataSnapshot.child(parentData).child(username).getValue(Users.class);

                    if(userData.getUsername().equals(username)){
                        if(userData.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this,"logged in successfully",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);//if login is successful it will change into mainActivity
                            Prevalent.currentOnlineUser = userData;//เพื่อดึงข้อมูลของ User ออกมาใช้งานต่อ
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Incorrect password",Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else {
                    Toast.makeText(LoginActivity.this,"Username " + username + "not found.",Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
