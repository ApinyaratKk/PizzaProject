package com.example.tester;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tester.Prevalent.Prevalent;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    private Button LogoutBtn;
    private TextView usernameTextView,cardTextView,passwordTextView;
    //add change picture textView
    //private TextView ;
    private ImageView ProfilePicSetting;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_profile, container, false);//open activity profile

        //profile picture changing link //maybe have to delete this
        /*changeProfilePictureLink = (TextView) view.findViewById(R.id.change_profile_pic_link);

        changeProfilePictureLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(),ChangeProfile.class);
                startActivity(intent);
            }
        });*/

        //add profile pic setting
        ProfilePicSetting = (ImageView) view.findViewById(R.id.profile_pic_setting);

        ProfilePicSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class); //error
                startActivity(intent);
            }
        });

        //for logout button //have to update logout button into (if clicked have to clear the user data)
        LogoutBtn = (Button) view.findViewById(R.id.logoutBtn);

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        usernameTextView = (TextView) view.findViewById(R.id.username_TextView);//ตั้งแต่บรรทัดนี้คือการ setText ให้แสดงผลออกมาที่หน้า profile เมื่อล็อคอิน
        cardTextView = (TextView) view.findViewById(R.id.user_cardTextView);
        passwordTextView = (TextView) view.findViewById(R.id.user_passwordTextView);

        try{
            usernameTextView.setText(Prevalent.currentOnlineUser.getUsername());
        }catch (NullPointerException ignored){
        }

        try{
            cardTextView.setText(Prevalent.currentOnlineUser.getCardno());
        }catch (NullPointerException ignored){
        }

        try{
            passwordTextView.setText(Prevalent.currentOnlineUser.getPassword());//ถึงบรรทัดนี้
        }catch (NullPointerException ignored){
        }

        return view;
    }

}
