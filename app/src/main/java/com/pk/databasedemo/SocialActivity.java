package com.pk.databasedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SocialActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    TabLayout tlSocial; FragmentTransaction ft;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        preferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
        editor = preferences.edit();
        ft = getSupportFragmentManager().beginTransaction();
        tlSocial = findViewById(R.id.tlSocial);
        tlSocial.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                ft = getSupportFragmentManager().beginTransaction();
                if(tab.getPosition() == 0){
                    fragment = new PostStatusFragment();

                }

                else
                    fragment = new CheckStatusFragment();

                ft.replace(R.id.flContainer, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ft.replace(R.id.flContainer, new PostStatusFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout){
            editor.clear();
            editor.commit();

            Intent i = new Intent(SocialActivity.this, LogInActivity.class);
            startActivity(i);
            finish();

        }
        else
            return super.onOptionsItemSelected(item);

        return true;
    }
}
