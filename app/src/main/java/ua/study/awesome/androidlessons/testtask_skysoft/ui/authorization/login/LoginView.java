package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.login;

public interface LoginView {

    void onSuccessLogin();

    void onErrorLogin(String error);

    void onErrorPassword(String error);

    void disableLoginError();

    void disablePasswordError();
}