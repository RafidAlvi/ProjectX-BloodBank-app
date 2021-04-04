package com.rafidalvi.projectxbloodbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<Requests,myAdapter.myviewholder> {
    public myAdapter(@NonNull FirebaseRecyclerOptions<Requests> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Requests model) {

        holder.name.setText(model.getrNameS());
        holder.address.setText(model.getrAddressS());
        holder.bloodtype.setText(model.getRbloodtype());
        holder.age.setText(model.getrAge());
        holder.uid = (model.getrUid());
        holder.phn.setText(model.getRphn());
        holder.note.setText(model.getrNoteS());
        holder.posttime.setText(model.getRdatetime());




    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_template,parent,false);

       return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView name,age,posttime,address,phn,bloodtype,note;
        String uid;
        LinearLayout reqL;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name= (TextView)itemView.findViewById(R.id.nameReq);
            age= (TextView)itemView.findViewById(R.id.ageReq);
            posttime= (TextView)itemView.findViewById(R.id.postTime);
            address= (TextView)itemView.findViewById(R.id.adrsReq);
            phn= (TextView)itemView.findViewById(R.id.phnReq);
            bloodtype= (TextView)itemView.findViewById(R.id.bloodReq);
            note= (TextView)itemView.findViewById(R.id.noteReq);
            reqL = (LinearLayout)itemView.findViewById(R.id.reqLayout);


        }
    }
}
