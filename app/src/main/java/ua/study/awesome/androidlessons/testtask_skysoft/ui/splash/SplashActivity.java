package ua.study.awesome.androidlessons.testtask_skysoft.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.SignInUpActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserRepository;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserRepositoryImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    private UserRepository model = new UserRepositoryImpl();

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

    private String getREGISTER_USER_NAME() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.REGISTER_USER_NAME, "").trim();
    }
}
