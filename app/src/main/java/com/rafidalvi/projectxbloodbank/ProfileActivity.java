package com.rafidalvi.projectxbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextInputLayout emailEDs,name,phn,altphn,address,weight,religion,birthday,fb;
    ProgressBar bar;
    DatabaseReference databaseRefuser1;
    Spinner blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button logout = findViewById(R.id.logoutBT);
        Button update = findViewById(R.id.updatebt);

        TextView tvUID = findViewById(R.id.tvUid);
        TextView tvlastBD = findViewById(R.id.lastdonTV);

        emailEDs = findViewById(R.id.emailProED);
        databaseRefuser1 = FirebaseDatabase.getInstance().getReference("users");
        fb = findViewById(R.id.imglinkProED);

        name = findViewById(R.id.nameProED);
        address = findViewById(R.id.addrssProED);
        phn = findViewById(R.id.phnProED);
        altphn = findViewById(R.id.altphnProED);
        weight = findViewById(R.id.weightProED);
        religion = findViewById(R.id.religionProED);
        birthday = findViewById(R.id.birthProED);

        blood = findViewById(R.id.bloodtypeProSP);
        mAuth = FirebaseAuth.getInstance();
        ImageView img = findViewById(R.id.profileLogo);


        if (!mAuth.getCurrentUser().getEmail().isEmpty()) {
            emailEDs.getEditText().setText(mAuth.getCurrentUser().getEmail());
            tvUID.setText("UID: "+mAuth.getCurrentUser().getUid());
        }



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(mAuth.getCurrentUser().getUid());



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String,String>map = (Map<String,String>) snapshot.getValue();
                String name1 = map.get("uNameS");
                String addrss = map.get("uAddressS");
                String phn1 = map.get("uPhn");
                String altphn1 = map.get("uAlrphn");
                String prologo = map.get("uFBlogo");
                String bloodtype = map.get("uBloodType");
                String weight1 = map.get("uWeight");
                String religion1 = map.get("uReligion");
                String age = map.get("uBirthdate");
                String lastblooddnated = map.get("uLastdonated");

                String[] baths = getResources().getStringArray(R.array.BloodType);

                blood.setSelection(Arrays.asList(baths).indexOf(bloodtype));

                //edittext e shob set korte hobe

               name.getEditText().setText(name1);
               phn.getEditText().setText(phn1);
               altphn.getEditText().setText(altphn1);
               address.getEditText().setText(addrss);
               weight.getEditText().setText(weight1);
               religion.getEditText().setText(religion1);
               birthday.getEditText().setText(age);
               fb.getEditText().setText(prologo);
               // String value = snapshot.getValue(String.class);
                if (!prologo.isEmpty()) {
                    Glide.with(img).load(prologo).into(img);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseRefuser1 = FirebaseDatabase.getInstance().getReference("users");

                String uBloodType = blood.getSelectedItem().toString();
                String uNameS = name.getEditText().getText().toString().trim();
                String uAddressS= address.getEditText().getText().toString().trim();
                String uFBlogo= fb.getEditText().getText().toString().trim();
                String uPhn= phn.getEditText().getText().toString().trim();
                String uAlrphn= altphn.getEditText().getText().toString().trim();
                String uWeight= weight.getEditText().getText().toString().trim();
                String uReligion= religion.getEditText().getText().toString().trim();
                String uBirthdate= birthday.getEditText().getText().toString().trim();
                String uMail= emailEDs.getEditText().getText().toString().trim();
                String ucounts = "0";
                String uLastdonated = tvlastBD.getText().toString().trim();



                String rNameS = "";
                String rAddressS= "";
                String rdatetime= "";
                String rphn= "";
                String rAge= "";
                String rbloodtype= "";

                String rNoteS= "";
                String rUid = mAuth.getCurrentUser().getUid();

                String rAcceptedS= "";

                Register register = new Register(uNameS, uAddressS, uFBlogo, uPhn, uAlrphn, uWeight, uReligion, uBirthdate, uMail, ucounts, uBloodType,uLastdonated);
                databaseRefuser1.child(mAuth.getCurrentUser().getUid()).setValue(register);


               DatabaseReference databaseRefuser2 = FirebaseDatabase.getInstance().getReference("users").child(mAuth.getCurrentUser().getUid()).child("currentREQ");

                Requests requests = new Requests(rNameS,rAddressS,rdatetime,rphn,rAge,rbloodtype,rUid,rNoteS,rAcceptedS);
                databaseRefuser2.child(mAuth.getCurrentUser().getUid()).setValue(requests);

                Toast.makeText(ProfileActivity.this,"User info Updated",Toast.LENGTH_SHORT).show();
            }
        });








    }


}