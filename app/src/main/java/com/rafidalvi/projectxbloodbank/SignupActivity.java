package com.rafidalvi.projectxbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    TextInputLayout emailEDs,passEDs;
    ProgressBar bar;
    private FirebaseAuth mAuth;
    DatabaseReference databaseRefuser;
    DatabaseReference databaseRefuser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailEDs = findViewById(R.id.emaileds);
        passEDs = findViewById(R.id.passed);
        databaseRefuser = FirebaseDatabase.getInstance().getReference("users");
        mAuth = FirebaseAuth.getInstance();








        bar = findViewById(R.id.prgrssbar);
        Button regbt = findViewById(R.id.registerbt);


        regbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              signup();
            }
        });

    }

    public void signup(){

        String email = emailEDs.getEditText().getText().toString().trim();
        String password = passEDs.getEditText().getText().toString().trim();
        mAuth = FirebaseAuth.getInstance();

        if (!email.isEmpty() && !password.isEmpty()){


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            bar.setVisibility(View.INVISIBLE);
                             emailEDs.getEditText().setText("");
                             passEDs.getEditText().setText("");
                            databaseRefuser = FirebaseDatabase.getInstance().getReference("users");
                            String uBloodType = "Select";
                            String uNameS = "";
                            String uAddressS= "";
                            String uFBlogo= "";
                            String uPhn= "";
                            String uAlrphn= "";
                            String uWeight= "";
                            String uReligion= "";
                            String uBirthdate= "";
                            String uMail= emailEDs.getEditText().getText().toString().trim();
                            String ucounts = "0";
                            String uLastdonated = "Last Donation: Not Donated Yet";

                            String rNameS = "";
                            String rAddressS= "";
                            String rdatetime= "";
                            String rphn= "";
                            String rAge= "";
                            String rbloodtype= "";

                            String rNoteS= "";

                            String rAcceptedS= "";



                            String rUid = mAuth.getCurrentUser().getUid();




                            Register register = new Register(uNameS, uAddressS, uFBlogo, uPhn, uAlrphn, uWeight, uReligion, uBirthdate, uMail, ucounts, uBloodType,uLastdonated);
                            databaseRefuser.child(mAuth.getCurrentUser().getUid()).setValue(register);


                            databaseRefuser2 = FirebaseDatabase.getInstance().getReference("users").child(mAuth.getCurrentUser().getUid()).child("currentREQ");

                            Requests requests = new Requests(rNameS,rAddressS,rdatetime,rphn,rAge,rbloodtype,rUid,rNoteS,rAcceptedS);
                            databaseRefuser2.child(mAuth.getCurrentUser().getUid()).setValue(requests);

                            Toast.makeText(SignupActivity.this, "Registered Successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignupActivity.this, ProfileActivity.class);
                            startActivity(intent);
                            finish();

                        } else {

                            bar.setVisibility(View.INVISIBLE);

                            Toast.makeText(SignupActivity.this, "Process ERROR", Toast.LENGTH_SHORT).show();


                        }

                    }
                });}else {
            Toast.makeText(this,"Please fill up all the sections",Toast.LENGTH_SHORT).show();
            bar.setVisibility(View.INVISIBLE);

        }
    }

}