package com.pk.databasedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public  class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    List<String> fruitsList;

    public MyRecyclerAdapter(List<String >fruitsList){
        this.fruitsList = fruitsList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.tvFruits.setText(fruitsList.get(i));
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFruits;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFruits = itemView.findViewById(R.id.tvFruits);
        }
    }
}
