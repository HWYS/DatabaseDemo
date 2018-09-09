package com.pk.databasedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etName = findViewById(R.id.etName);

        preferences = getSharedPreferences("LOGIN", MODE_PRIVATE);

        if(preferences.contains("user_name")){
            Intent i = new Intent(LogInActivity.this, SocialActivity.class);
            startActivity(i);
            finish();
        }



    }

    public void logIn(View view) {
        if(TextUtils.isEmpty(etName.getText().toString().trim())){
            etName.setError("Enter User Name");
            return;
        }
        editor = preferences.edit();
        editor.putString("user_name", etName.getText().toString());
        editor.commit();

        Intent i = new Intent(LogInActivity.this, SocialActivity.class);
        startActivity(i);
        finish();
    }
}
