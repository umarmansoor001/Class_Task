package com.umarmansoor.class_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<MyModel> ls;
    Context c;
    public MyAdapter(List<MyModel> ls, Context c){
        this.ls = ls;
        this.c = c;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(c).inflate(R.layout.row,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder,  int position) {
        holder.name.setText(ls.get(position).getName());
        holder.num.setText(ls.get(position).getNum());
        holder.address.setText(ls.get(position).getAddress());

        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,ls.get(position).getAddress(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,num,address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            num = itemView.findViewById(R.id.num);
            address = itemView.findViewById(R.id.address);
        }
    }
}

