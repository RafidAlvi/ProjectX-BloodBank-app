package com.rafidalvi.projectxbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    Button loginbt;
    TextInputLayout emailED,passED;
    ProgressBar bar;
    CountryCodePicker ccp;
    private FirebaseAuth mAuth;
    TextView tvsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hbt = findViewById(R.id.homebt);
        mAuth = FirebaseAuth.getInstance();


        loginbt = findViewById(R.id.loginBT);
        //ccp = (CountryCodePicker) findViewById(R.id.ccp);
        emailED = findViewById(R.id.email);
        passED = findViewById(R.id.pwd);
        bar = findViewById(R.id.prgrssbar);

                tvsignup = findViewById(R.id.signupActivityTV);


        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (emailED.getEditText().getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Enter Mail Please", Toast.LENGTH_SHORT).show();

                } else if (passED.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Password Invalid", Toast.LENGTH_SHORT).show();

                } else {


                    bar.setVisibility(View.VISIBLE);
                    String email = emailED.getEditText().getText().toString().trim();
                    String password = passED.getEditText().getText().toString().trim();

                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        emailED.getEditText().setText("");
                                        passED.getEditText().setText("");
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser currentuser = mAuth.getCurrentUser();
                                        bar.setVisibility(View.INVISIBLE);
                                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                        intent.putExtra("email", mAuth.getCurrentUser().getEmail());
                                        intent.putExtra("uid", mAuth.getCurrentUser().getUid());

                                        startActivity(intent);


                                        Toast.makeText(MainActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        bar.setVisibility(View.INVISIBLE);
                                        emailED.getEditText().setText("");
                                        passED.getEditText().setText("");
                                        Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                }
            }
        });

        hbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            //reload();
        }
    }

}