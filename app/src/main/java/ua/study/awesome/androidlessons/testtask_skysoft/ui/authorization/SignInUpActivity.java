package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseActivity;

public class SignInUpActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(new SignInUpFragment(), R.id.login_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_sign_in_up;
    }

}