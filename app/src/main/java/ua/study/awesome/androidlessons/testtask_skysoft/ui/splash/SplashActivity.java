package ua.study.awesome.androidlessons.testtask_skysoft.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
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
        loginSuccess();
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, SignInUpActivity.class);
        startActivity(intent);
        finish();
    }

    private void delay() {
        try {
            Thread.sleep(500); //Приостанавливает поток на 0.5 секунд
        } catch (Exception e) {

        }
    }

    private void loginSuccess() {
        if (login()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else goToMainActivity();

    }

    private boolean login() {
        boolean isRegister = false;
        if (model.getUser(getREGISTER_USER_NAME()) != null) {
            if (validatePassword() && validateLoginWithName()) {
                isRegister = true;
            }

            if (validatePassword() && validateLoginWithEmail()) {
                isRegister = true;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please login", Toast.LENGTH_SHORT).show();
        }
        return isRegister;
    }

    private boolean validateLoginWithName() {
        boolean isValid = false;
        if (getREGISTER_USER_NAME().equals(model.getUser(getREGISTER_USER_NAME()).getUserName().trim())) {
            isValid = true;
        }
        return isValid;
    }

    private boolean validateLoginWithEmail() {
        boolean isValid = false;
        if (getREGISTER_E_MAIL().equals(model.getUser(getREGISTER_USER_NAME()).getEmail().trim())) {
            isValid = true;
        }
        return isValid;
    }

    private boolean validatePassword() {
        boolean isValid = false;
            if (getREGISTER_PASSWORD().equals(model.getUser(getREGISTER_USER_NAME()).getPassword().trim())) {
                isValid = true;
            }
        return isValid;
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
