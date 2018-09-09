package com.pk.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToGenre(View view) {
        Intent i = new Intent(MainActivity.this, GenreActivity.class);
        startActivity(i);
    }

    public void goToMovie(View view) {

        //Edited in MainActivity.java
    }
}
