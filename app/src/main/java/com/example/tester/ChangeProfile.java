package com.example.tester;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tester.Prevalent.Prevalent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChangeProfile extends AppCompatActivity {
//new Activity for change profile picture
    private TextView changeProfilePicBtn,saveBtn;
    private CircleImageView profilePic;
    private Uri imageUri;

    private String myUrl = " ";
    private StorageTask uploadTask;
    private StorageReference storageProfilePictureRef;
    private String checker = " ";
//still error
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        //add change profile pic
        profilePic = (CircleImageView) findViewById(R.id.profile_pic);
        changeProfilePicBtn = (TextView) findViewById(R.id.change_profile_pic);
        saveBtn = (TextView) findViewById(R.id.save_profilePic);

        userInfoDisplay(profilePic);

        //setting change profile picture process
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checker.equals("clicked")) {
                    userInfosaved();
                }

            }
        });

        changeProfilePicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checker = "clicked";

                CropImage.activity(imageUri)
                        .setAspectRatio(1,1)
                        .start(ChangeProfile.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data!=null){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            imageUri = result.getUri();
            profilePic.setImageURI(imageUri);

        }else{
            Toast.makeText(this,"Error, Try again",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(ChangeProfile.this,ChangeProfile.class));
            finish();
        }
    }

    private void userInfosaved() {
        if(checker.equals("clicked")){
            uploadImage();
        }

    }

    private void uploadImage() {
        if(imageUri != null){
            final StorageReference fileRef = storageProfilePictureRef
                    .child(Prevalent.currentOnlineUser.getCardno() + ".jpg");
            uploadTask = fileRef.putFile(imageUri);

            uploadTask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();

                    }
                    return fileRef.getDownloadUrl();
                }
            })
                    .addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if(task.isSuccessful()){
                                Uri downloadUrl = task.getResult();
                                myUrl = downloadUrl.toString();
                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");

                                HashMap<String,Object> userMap = new HashMap<>();
                                userMap.put("image",myUrl);

                                startActivity(new Intent(ChangeProfile.this,MainActivity.class));
                                Toast.makeText(ChangeProfile.this,"Profile info updated",Toast.LENGTH_LONG).show();
                                finish();
                            }
                            else{
                                Toast.makeText(ChangeProfile.this,"Error.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else{
            Toast.makeText(this,"Select profile Picture",Toast.LENGTH_SHORT).show();
        }
    }

    private void userInfoDisplay(final CircleImageView profilePic){
        DatabaseReference UserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(Prevalent.currentOnlineUser.getCardno());

        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    if(dataSnapshot.child("image").exists()){
                        String image = dataSnapshot.child("image").getValue().toString();

                        Picasso.get().load(image).into(profilePic);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
