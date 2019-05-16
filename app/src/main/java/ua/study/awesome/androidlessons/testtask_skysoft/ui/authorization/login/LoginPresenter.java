package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.login;

import android.support.design.widget.TextInputEditText;

public interface LoginPresenter {

    void loadAllData(TextInputEditText edtLogin, TextInputEditText edtLoginPassword);

    void saveAllData(TextInputEditText edtLogin, TextInputEditText edtLoginPassword);

    void atachView(LoginFragment loginFragment);

    void validateLogin(String login, String password);
}