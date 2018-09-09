package com.pk.databasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemoActivity extends AppCompatActivity {
    List<String> fruits = new ArrayList<>();
    RecyclerView rvFruits;
    LinearLayoutManager layoutManager;

    MyRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);


        fruits.add("Apple");fruits.add("Orange");fruits.add("Lemon");

        layoutManager = new LinearLayoutManager(this);
        rvFruits = findViewById(R.id.rvFruits);
        rvFruits.setLayoutManager(layoutManager);

        adapter = new MyRecyclerAdapter(fruits);
        rvFruits.setAdapter(adapter);
    }


    public void addMore(View view) {
        fruits.add("Banana");
        adapter.notifyItemInserted(fruits.size()-1);
    }
}
