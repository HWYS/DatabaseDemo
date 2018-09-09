package com.pk.databasedemo;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostStatusFragment extends Fragment implements View.OnClickListener{

    EditText etStatus;
    Button btnShare;
    Context context;
    DatabaseTest db;
    SharedPreferences preferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post_status, container, false);
        context = container.getContext();
        db = new DatabaseTest(context, "Social", null, 1);

        etStatus = v.findViewById(R.id.etStatus);
        btnShare = v.findViewById(R.id.btnShare);

        preferences = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        btnShare.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(etStatus.getText().toString().trim())){
            etStatus.setError("Enter your status");
            return;
        }

        if(db.insertPost(etStatus.getText().toString(), preferences.getString("user_name", ""))){
            Toast.makeText(context, "Your status is uploaded", Toast.LENGTH_LONG).show();
            etStatus.setText("");
        }

        else
            Toast.makeText(context, "Your status is failed to upload", Toast.LENGTH_LONG).show();
    }
}
