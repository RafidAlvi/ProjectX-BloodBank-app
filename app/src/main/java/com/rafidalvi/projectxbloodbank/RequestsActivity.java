package com.rafidalvi.projectxbloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RequestsActivity extends AppCompatActivity {
RecyclerView recyclerreq;
myAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        recyclerreq = findViewById(R.id.recyclerReq);
        recyclerreq.setLayoutManager(new LinearLayoutManager(this));



        FirebaseRecyclerOptions<Requests> options =
                new FirebaseRecyclerOptions.Builder<Requests>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("requests"), Requests.class)
                        .build();

        adapter = new myAdapter(options);

        recyclerreq.setAdapter(adapter);




    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}