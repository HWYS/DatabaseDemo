package com.pk.databasedemo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pk.databasedemo.data_model.StatusInfo;

import java.util.List;

public class StatusRecyclerAdapter extends RecyclerView.Adapter<StatusRecyclerAdapter.MyViewHolder> {
    List<StatusInfo>infoList; Context context;

    public StatusRecyclerAdapter(List<StatusInfo> _infoList, Context _context){
        infoList = _infoList;
        context = _context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);

        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.tvStatus.setText(infoList.get(i).getStatus());
        myViewHolder.tvName.setText(infoList.get(i).getName());

        myViewHolder.btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("id", infoList.get(i).getId());
                intent.putExtra("status", myViewHolder.tvStatus.getText().toString());
                intent.putExtra("name", myViewHolder.tvName.getText().toString());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvStatus, tvName; Button btnSeeMore;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvName = itemView.findViewById(R.id.tvName);
            btnSeeMore = itemView.findViewById(R.id.btnSeeMore);
        }
    }
}


