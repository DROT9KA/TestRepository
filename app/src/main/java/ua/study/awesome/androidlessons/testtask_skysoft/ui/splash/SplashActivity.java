package ua.study.awesome.androidlessons.testtask_skysoft.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.LoginScreen.SignInUpActivity;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delay();
        goToMainActivity();
    }

    private void goToMainActivity(){
        Intent intent = new Intent(this, SignInUpActivity.class);
        startActivity(intent);
        finish();
    }

    private void delay(){
        try {
            Thread.sleep(500); //Приостанавливает поток на 0.5 секунд
        } catch (Exception e) {

        }
    }
}
