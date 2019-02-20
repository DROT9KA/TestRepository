package com.example.task_from_matway;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText edtEmail, edtPassword;
//    CheckBox save;

//    Keys Preferences
    private final String KEY_LOG = "key_log";
    private final String KEY_PASS = "key_pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getPreferences(MODE_PRIVATE);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnRegister = findViewById(R.id.btn_register);
        edtEmail = findViewById(R.id.edt_login);
        edtPassword = findViewById(R.id.edt_password);
//      save = findViewById(R.id.savePass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEmail();
                savePassword();
                if (isValidEmail()&& isValidPassword()) {
                    Toast.makeText( LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                    sendEmailAndPass();
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Email or Password is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadEmail();
                loadPassword();
            }
        });
    }

//  Validation Email Address and password
    private boolean isValidEmail(){
        return !TextUtils.isEmpty(edtEmail.getText()) && Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText()).matches();
    }

    private boolean isValidPassword(){
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]{4,20}");
        return !TextUtils.isEmpty(edtPassword.getText()) && PASSWORD_PATTERN.matcher(edtPassword.getText()).matches();
    }

//    private boolean passwordValid(){
//        return ;
//    }

//    save and load text login and password
    private void saveEmail() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LOG, edtEmail.getText().toString());
        editor.apply();
    }

    private void savePassword() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_PASS, edtPassword.getText().toString());
        editor.apply();
    }

    private void loadEmail() {
        edtEmail.setText(preferences.getString(KEY_LOG, ""));
    }

    private void loadPassword() {
        edtPassword.setText(preferences.getString(KEY_PASS,""));
    }

    private void sendEmailAndPass(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Email", edtEmail.getText().toString());
        intent.putExtra("Password", edtPassword.getText().toString());
        startActivity(intent);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        saveEmail();
//        savePassword();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        loadEmail();
//        loadPassword();
//    }

}