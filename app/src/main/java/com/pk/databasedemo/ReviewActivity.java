package com.pk.databasedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pk.databasedemo.data_model.GenreInfo;
import com.pk.databasedemo.data_model.MovieInfo;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin, btnRegister;

    List<GenreInfo> infoList;

    SharedPreferences preferences;

    SQLiteDatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btnLogin = findViewById(R.id.btnLogIn);
        btnLogin.setOnClickListener(this);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        //preferences = getPreferences(MODE_PRIVATE);
        preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);
        //preferences = PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", "hello@example.com");
        editor.apply();


        databaseHelper = new SQLiteDatabaseHelper(ReviewActivity.this, "StudentDb", null, 1);

        MovieInfo info = new MovieInfo("MI", 2018, 30.5);

        databaseHelper.insertMovie(info);
    }



    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnLogIn){
            Intent i = new Intent(ReviewActivity.this, GenreActivity.class);
            i.putParcelableArrayListExtra("genreList", (ArrayList<? extends Parcelable>) infoList);
            i.putExtra("oneObj", infoList.get(0));
            startActivity(i);

        }
        else if(view.getId() == R.id.btnRegister){

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
