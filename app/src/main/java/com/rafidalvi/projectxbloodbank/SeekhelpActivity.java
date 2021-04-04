package com.rafidalvi.projectxbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class SeekhelpActivity extends AppCompatActivity {
    DatabaseReference databaseRefuser1,databaseRefuser,databaseRefuser2;
    private FirebaseAuth mAuth;
    TextInputLayout emailEDs,name,phn,altphn,address,weight,notes,age,fb;
    Spinner blood;
    TextView namep,addressp,agep,phnp,notesp,bloodp,timep,accepter;
    Button seek,remove,done;
    LinearLayout seekL,pendingL;
    String dateid;

    @Override
    protected void onStart() {
        super.onStart();

        if (!(timep.length() == 0)) {
            seekL.setVisibility(View.GONE);
            pendingL.setVisibility(View.VISIBLE);

        }
        else {
            seekL.setVisibility(View.VISIBLE);
            pendingL.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekhelp);
        mAuth = FirebaseAuth.getInstance();
        databaseRefuser1 = FirebaseDatabase.getInstance().getReference("users");
        accepter = findViewById(R.id.accepterTV);


        seekL = findViewById(R.id.seekingLayout);
        pendingL = findViewById(R.id.pendingLayout);

        DateFormat df1 = new SimpleDateFormat("d MMM yyyy h mm a");
         dateid = df1.format(Calendar.getInstance().getTime());

        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, h:mm a");
        String date = df.format(Calendar.getInstance().getTime());

        TextView time = findViewById(R.id.timetable);
        time.setText(date);

        done = findViewById(R.id.doneBt);



        name = findViewById(R.id.nameSeekED);
        address = findViewById(R.id.adrssSeekED);
        phn = findViewById(R.id.phnSeekED);
        age = findViewById(R.id.ageSeekED);
        blood = findViewById(R.id.bloodtypeProSPseek);
        blood = findViewById(R.id.bloodtypeProSPseek);
        notes = findViewById(R.id.noteSeekED);

        seek = findViewById(R.id.seekBt);

        namep = findViewById(R.id.pendingName);
        addressp = findViewById(R.id.pendingAddress);
        phnp = findViewById(R.id.pendingPhn);
        agep = findViewById(R.id.pendingAge);
        bloodp = findViewById(R.id.pendingBloodtype);
        timep= findViewById(R.id.postTime);
        notesp = findViewById(R.id.pendingNotes);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(mAuth.getCurrentUser().getUid());



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String,String> map = (Map<String,String>) snapshot.getValue();
                String name1 = map.get("uNameS");
                String addrss = map.get("uAddressS");
                String phn1 = map.get("uPhn");
                String altphn1 = map.get("uAlrphn");
                String bloodtype = map.get("uBloodType");
                String age1 = map.get("uBirthdate");
                String accepterS = map.get("rAcceptedS");

                String[] baths = getResources().getStringArray(R.array.BloodType);

                blood.setSelection(Arrays.asList(baths).indexOf(bloodtype));
                name.getEditText().setText(name1);
                phn.getEditText().setText(phn1);
                address.getEditText().setText(addrss);
                age.getEditText().setText(age1);
                accepter.setText(accepterS);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database2.getInstance().getReference("users").child(mAuth.getCurrentUser().getUid()).child("currentREQ").child(mAuth.getCurrentUser().getUid());



        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String,String> map = (Map<String,String>) snapshot.getValue();
                String name1 = map.get("rNameS");
                String addrss = map.get("rAddressS");
                String phn1 = map.get("rphn");
                String note = map.get("rNoteS");
                String bloodtype = map.get("rbloodtype");
                String age1 = map.get("rAge");
                String time = map.get("rdatetime");


                namep.setText(name1);
                phnp.setText(phn1);
                addressp.setText(addrss);
                notesp.setText(note);
                agep.setText(age1);
                timep.setText(time);
                bloodp.setText(bloodtype);

                if (!(timep.length() == 0)) {
                    seekL.setVisibility(View.GONE);
                    pendingL.setVisibility(View.VISIBLE);

                }
                else {
                    seekL.setVisibility(View.VISIBLE);
                    pendingL.setVisibility(View.GONE);
                }







            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });













        //change kore done button r delete button er kaj korbo
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseRefuser = FirebaseDatabase.getInstance().getReference("history");

                String rNameS= name.getEditText().getText().toString();
                String rAddressS=  address.getEditText().getText().toString();
                String rdatetime = date;
                String rphn =  phn.getEditText().getText().toString();
                String rAge =  age.getEditText().getText().toString();
                String rbloodtype = blood.getSelectedItem().toString();
                String rUid = mAuth.getCurrentUser().getUid();
                String rNoteS = notes.getEditText().getText().toString();
                String rAcceptedS = "Not Accepted yet";
                String rStatus ="Done";
                String rDoneby = accepter.getText().toString();

                databaseRefuser2 = FirebaseDatabase.getInstance().getReference("requests");
                DatabaseReference databaseRefuser3 = FirebaseDatabase.getInstance().getReference("users").child(mAuth.getCurrentUser().getUid()).child("currentREQ");




                RequestHistory requestsH = new RequestHistory(rNameS,rAddressS,rdatetime,rphn,rAge,rbloodtype,rUid,rNoteS,rStatus,rDoneby);
                databaseRefuser.child(dateid).setValue(requestsH);
                rdatetime = "";
                Requests requests = new Requests(rNameS,rAddressS,rdatetime,rphn,rAge,rbloodtype,rUid,rNoteS,rAcceptedS);


                databaseRefuser3.child(mAuth.getCurrentUser().getUid()).setValue(requests);
                Toast.makeText(SeekhelpActivity.this,"Done",Toast.LENGTH_SHORT).show();
             //   databaseRefuser2.setValue(null);
                databaseRefuser2.child(mAuth.getCurrentUser().getUid()).setValue(null);

            }
        });

        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseRefuser = FirebaseDatabase.getInstance().getReference("history");

                String rNameS= name.getEditText().getText().toString();
                String rAddressS=  address.getEditText().getText().toString();;
                String rdatetime = date;
                String rphn =  phn.getEditText().getText().toString();;
                String rAge =  age.getEditText().getText().toString();;
                String rbloodtype = blood.getSelectedItem().toString();
                String rUid = mAuth.getCurrentUser().getUid();
                String rNoteS = notes.getEditText().getText().toString();;
                String rStatus ="Pending";
                String rDoneby = "";
                String rAcceptedS = "Not Accepted yet";

                databaseRefuser2 = FirebaseDatabase.getInstance().getReference("requests");
               DatabaseReference databaseRefuser3 = FirebaseDatabase.getInstance().getReference("users").child(mAuth.getCurrentUser().getUid()).child("currentREQ");

                Requests requests = new Requests(rNameS,rAddressS,rdatetime,rphn,rAge,rbloodtype,rUid,rNoteS,rAcceptedS);
                databaseRefuser2.child(mAuth.getCurrentUser().getUid()).setValue(requests);
                databaseRefuser3.child(mAuth.getCurrentUser().getUid()).setValue(requests);


                RequestHistory requestsH = new RequestHistory(rNameS,rAddressS,rdatetime,rphn,rAge,rbloodtype,rUid,rNoteS,rStatus,rDoneby);
                databaseRefuser.child(dateid).setValue(requestsH);

                Toast.makeText(SeekhelpActivity.this,"Request Submitted",Toast.LENGTH_SHORT).show();

            }
        });






    }








}