package com.pk.databasedemo;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pk.databasedemo.data_model.GenreInfo;

import java.util.ArrayList;
import java.util.List;

public class GenreActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    List<GenreInfo> genreInfos;

    List<Fragment> fragmentList = new ArrayList<>();

    Fragment fragment;
    FragmentTransaction transaction;

    SharedPreferences preferences;

    RecyclerView rvGenre;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        //dbHelper = new DatabaseHelper(GenreActivity.this, "MovieDb", null, 1);

        //genreInfos = dbHelper.getAllGenre();

        //rvGenre = findViewById(R.id.rvGenre);
        //layoutManager = new LinearLayoutManage(GenreActivity.this, HOr)




        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList);

        Toast.makeText(GenreActivity.this, "On Create", Toast.LENGTH_LONG).show();

        preferences = getSharedPreferences("ReviewActivity", MODE_PRIVATE);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(GenreActivity.this, "On Start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(GenreActivity.this, "On Resume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(GenreActivity.this, "On Pause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(GenreActivity.this, "On Stop", Toast.LENGTH_LONG).show();
        super.onStop();


    }

    @Override
    protected void onRestart() {
        Toast.makeText(GenreActivity.this, "On Restart", Toast.LENGTH_LONG).show();
        super.onRestart();


    }

    @Override
    protected void onDestroy() {

        Toast.makeText(GenreActivity.this, "On Destory", Toast.LENGTH_LONG).show();
        super.onDestroy();


    }
}
