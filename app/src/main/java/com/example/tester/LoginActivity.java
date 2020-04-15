package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity { //just deleted this out (implements View.OnClickListener)

    private Button LoginButton;
    private EditText Username,Password; //changed from user_editText and password_editText
    //private ViewPager viewPager;
    private TextView userRegistration;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ViewPager viewPager = findViewById(R.id.viewPager);

        /*AuthenticationPagerAdapter pagerAdapter = new AuthenticationPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragmet(new LoginFragment());
        pagerAdapter.addFragmet(new RegisterFragment());
        viewPager.setAdapter(pagerAdapter);*/

        Username = (EditText) findViewById(R.id.user_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        LoginButton = (Button) findViewById(R.id.login_button);
        userRegistration = (TextView) findViewById(R.id.registerLink); //go to register page

        /*userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });*/
    }
    /*class AuthenticationPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public AuthenticationPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragmet(Fragment fragment) {
            fragmentList.add(fragment);
        }
    }*/

    /*@Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registerLink:
                startActivity(new Intent(this,RegisterActivity.class));
                break;

            case R.id.login_button:
                startActivity(new Intent(LoginActivity.this,OrderFragment.class));
                break;
        }
    }*/
}
