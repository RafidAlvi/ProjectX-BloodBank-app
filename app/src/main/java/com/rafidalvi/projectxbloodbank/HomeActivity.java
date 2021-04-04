package com.rafidalvi.projectxbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
TextView userEmail;
ImageView profile;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LinearLayout seekhelpL = findViewById(R.id.SEEKHELP);
        LinearLayout reqL = findViewById(R.id.requestsAct);


        seekhelpL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SeekhelpActivity.class);
                startActivity(intent);
            }
        });

        reqL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,RequestsActivity.class);
                startActivity(intent);
            }
        });

        ImageView img = findViewById(R.id.profileLogo);




        userEmail = findViewById(R.id.usermailTV);
        profile = findViewById(R.id.profileLogo);
        mAuth = FirebaseAuth.getInstance();


        if (!mAuth.getCurrentUser().getEmail().isEmpty()) {
            userEmail.setText(mAuth.getCurrentUser().getEmail());

        }





        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(mAuth.getCurrentUser().getUid()).child("uFBlogo");



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);

                if (!value.isEmpty()) {
                    Glide.with(img).load(value).into(img);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });








        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


      /* if (!getIntent().getStringExtra("email").toString().isEmpty()) {
            userEmail.setText(getIntent().getStringExtra("email").toString());
            userEmail.append("\n UID:" + getIntent().getStringExtra("uid").toString());
        }
       */
    }
}