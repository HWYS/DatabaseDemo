package com.pk.databasedemo;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pk.databasedemo.data_model.CommentInfo;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvStatus, tvName;
    TextInputEditText etComment; ImageView ivSend;
    RecyclerView rvComment; LinearLayoutManager layoutManager;
    DatabaseTest db; int id = 0;
    CommentRecyclerAdapter adapter; SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        db = new DatabaseTest(CommentActivity.this, "Social", null, 1);

        tvStatus = findViewById(R.id.tvStatus);
        tvStatus.setText(getIntent().getExtras().getString("status"));
        id = getIntent().getExtras().getInt("id");
        tvName = findViewById(R.id.tvName);
        tvName.setText(getIntent().getExtras().getString("name"));

        rvComment = findViewById(R.id.rvComment);
        layoutManager = new LinearLayoutManager(this);
        rvComment.setLayoutManager(layoutManager);
        adapter = new CommentRecyclerAdapter(db.getAllCommentById(id), CommentActivity.this);
        rvComment.setAdapter(adapter);

        etComment = findViewById(R.id.etComment);
        ivSend = findViewById(R.id.ivSend);
        ivSend.setOnClickListener(this);

        preferences = getSharedPreferences("LOGIN", MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(etComment.getText().toString().trim())){
            etComment.setError("Enter your comment");
            return;
        }

        if(db.insertComment(new CommentInfo(id, preferences.getString("user_name", ""), etComment.getText().toString()))){
            Toast.makeText(CommentActivity.this, "Your comment is posted", Toast.LENGTH_LONG).show();
            etComment.setText("");

            adapter = new CommentRecyclerAdapter(db.getAllCommentById(id), CommentActivity.this);
            rvComment.setAdapter(adapter);
        }

        else
            Toast.makeText(CommentActivity.this, "Failed to post your comment", Toast.LENGTH_LONG).show();

    }
}
