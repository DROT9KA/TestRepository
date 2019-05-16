package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration;

public interface RegisterView {

    void disableConfirmPassError();

    void disablePassEror();

    void disableEmailError();

    void disableUserNameError();

    void onErrorUsername(String error);

    void onErrorEmail(String error);

    void onErrorPassword(String error);

    void onErrorConfirmPassword(String error);

    void onSuccessRegistration();
}
