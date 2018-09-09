package com.pk.databasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pk.databasedemo.data_model.CommentInfo;
import com.pk.databasedemo.data_model.StatusInfo;

import java.util.List;

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.MyViewHolder> {
    List<CommentInfo>infoList; Context context;

    public CommentRecyclerAdapter(List<CommentInfo> _infoList, Context _context){
        infoList = _infoList;
        context = _context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_item, viewGroup, false);

        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tvComment.setText(infoList.get(i).getComment());
        myViewHolder.tvName.setText(infoList.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvComment, tvName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvComment = itemView.findViewById(R.id.tvComment);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}


