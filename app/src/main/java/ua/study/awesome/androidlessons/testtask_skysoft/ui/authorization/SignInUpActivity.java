package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class SignInUpActivity extends BaseActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginSuccess();

        addFragment(new SignInUpFragment(), R.id.login_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_sign_in_up;
    }

    private void loginSuccess() {
        if (login()) {
            startActivity(new Intent(this, MainActivity.class));

            finish();
        }
    }

    private boolean login() {
        boolean bool = false;

        if (validatePassword() && validateLoginWithName()) {
            bool = true;
        }

        if (validatePassword() && validateLoginWithEmail()) {
            bool = true;
        }

        return bool;
    }

    private boolean validateLoginWithName() {
        boolean bool = false;

        if (getLOGIN_USERNAME_EMAIL().equals(getREGISTER_USER_NAME())) {
            bool = true;
        }
        return bool;
    }

    private boolean validateLoginWithEmail() {
        boolean bool = false;

        if (getLOGIN_USERNAME_EMAIL().equals(getREGISTER_E_MAIL())) {
            bool = true;
        }
        return bool;
    }

    private boolean validatePassword() {
        boolean bool = false;

        if (getLOGIN_PASSWORD().equals("")) {

        } else {
            if (getLOGIN_PASSWORD().equals(getREGISTER_PASSWORD())) {
                bool = true;
            }
        }
        return bool;
    }

    private String getREGISTER_PASSWORD() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.REGISTER_PASSWORD, "").trim();
    }

    private String getLOGIN_PASSWORD() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.LOGIN_PASSWORD, "").trim();
    }

    private String getLOGIN_USERNAME_EMAIL() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.LOGIN_USERNAME_EMAIL, "").trim();
    }

    private String getREGISTER_USER_NAME() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.REGISTER_USER_NAME, "").trim();
    }

    private String getREGISTER_E_MAIL() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.REGISTER_E_MAIL, "").trim();
    }
}