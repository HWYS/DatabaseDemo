package com.pk.databasedemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CheckStatusFragment extends Fragment {
    RecyclerView rvStatus; LinearLayoutManager layoutManager;
    DatabaseTest db;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check_status, container, false);
        context = container.getContext();
        rvStatus = v.findViewById(R.id.rvStatus);
        layoutManager = new LinearLayoutManager(context);
        rvStatus.setLayoutManager(layoutManager);
        db = new DatabaseTest(context, "Social", null, 1);

        rvStatus.setAdapter(new StatusRecyclerAdapter(db.getAllStatus(), context));
        return  v;
    }
}
