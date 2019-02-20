package com.example.task_from_matway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvPassword = findViewById(R.id.tv_password);
        Button btnLogout = findViewById(R.id.btn_logout);

        tvEmail.setText(getIntent().getStringExtra("Email"));
        tvPassword.setText(getIntent().getStringExtra("Password"));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }
        });
    }

}