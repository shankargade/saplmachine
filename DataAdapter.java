package com.appsplanet.test.saplmachine;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Viewholder> {
    private Context mcontext;
    private ArrayList<Data> mdata;


    public DataAdapter(Context mcontext, ArrayList<Data> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Toast.makeText(mcontext,"OnCrreateView",Toast.LENGTH_SHORT).show();
        View view=LayoutInflater.from(mcontext).inflate(R.layout.data,parent,false);
        return new Viewholder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Toast.makeText(mcontext,"OnBind",Toast.LENGTH_SHORT).show();
        Log.e("OnBind",mdata.get(position).getFirstname());
        holder.id1.setText(mdata.get(position).getId());
        holder.firstname.setText(mdata.get(position).getFirstname());
        holder.lastname.setText(mdata.get(position).getLastname());
        holder.avatar.setText(mdata.get(position).getAvatar());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView id1,firstname,lastname,avatar;

        public Viewholder(View itemView) {
            super(itemView);
            id1=itemView.findViewById(R.id.dataid);
            firstname=itemView.findViewById(R.id.dataname);
            lastname=itemView.findViewById(R.id.datalastname);
            avatar=itemView.findViewById(R.id.dataavtar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext,Main3Activity.class);
                    intent.putExtra("dataid",id1.getText().toString());
                    intent.putExtra("dataname",firstname.getText().toString());
                    intent.putExtra("lastname",lastname.getText().toString());
                    intent.putExtra("avatar",avatar.getText().toString());
                    mcontext.startActivity(intent);

                }
            });
        }
    }
}
