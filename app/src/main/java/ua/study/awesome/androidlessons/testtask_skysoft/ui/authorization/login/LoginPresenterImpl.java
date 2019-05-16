package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.login;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;

import java.util.Objects;

import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class LoginPresenterImpl implements LoginPresenter {

    private SharedPreferences preferences;

    private LoginFragment view;

    @Override
    public void atachView(LoginFragment loginFragment) {
        this.view = loginFragment;
    }

    @Override
    public void validateLogin(String login, String password) {
        boolean isCancel = true;

        if (TextUtils.isEmpty(login)) {
            isCancel = false;
            view.onErrorLogin("Please enter login");
        } else {
            view.disableLoginError();
            if (equalsLogin(login) || equalsEmail(login)) {
                view.disableLoginError();
            } else {
                isCancel = false;
                view.onErrorLogin("wrong User name or Email");
            }
        }

        if (TextUtils.isEmpty(password)) {
            isCancel = false;
            view.onErrorPassword("Please enter login");
        } else {
            view.disablePasswordError();

            if (!equalsPassword(password)) {
                isCancel = false;
                view.onErrorPassword("wrong password");
            } else view.disablePasswordError();
        }

        if (isCancel) {
            view.onSuccessLogin();
        }
    }

    private String getRegisterLogin() {
        preferences = view.getActivity().getSharedPreferences(AppConstans.PREFERENCE_NAME,
                view.getActivity().MODE_PRIVATE);
        String userName = preferences.getString(AppConstans.REGISTER_USER_NAME, "");

        return userName;
    }

    private String getRegisterEmail() {
        preferences = view.getActivity().getSharedPreferences(AppConstans.PREFERENCE_NAME,
                view.getActivity().MODE_PRIVATE);
        String eMail = preferences.getString(AppConstans.REGISTER_E_MAIL, "");

        return eMail;
    }

    private String getRegisterPassword() {
        preferences = view.getActivity().getSharedPreferences(AppConstans.PREFERENCE_NAME,
                view.getActivity().MODE_PRIVATE);
        String password = preferences.getString(AppConstans.REGISTER_PASSWORD, "");

        return password;
    }

    private boolean equalsPassword(String password) {
        boolean bool = false;
        if (password.equals(getRegisterPassword())) {
            bool = true;
        }
        return bool;
    }

    private boolean equalsLogin(String login) {
        boolean bool = true;
        if (login.equals(getRegisterLogin())) {
            bool = false;
        }
        return bool;
    }

    private boolean equalsEmail(String email) {
        boolean bool = true;
        if (email.equals(getRegisterEmail())) {
            bool = false;
        }
        return bool;
    }

    @Override
    public void loadAllData(TextInputEditText edtLogin, TextInputEditText edtLoginPassword) {
        loadText(AppConstans.LOGIN_USERNAME_EMAIL, edtLogin);
        loadText(AppConstans.LOGIN_PASSWORD, edtLoginPassword);
    }

    @Override
    public void saveAllData(TextInputEditText edtLogin, TextInputEditText edtLoginPassword) {
        saveText(AppConstans.LOGIN_USERNAME_EMAIL, edtLogin);
        saveText(AppConstans.LOGIN_PASSWORD, edtLoginPassword);
    }

    private void saveText(String key, TextInputEditText editText) {
        preferences = Objects.requireNonNull(view.getActivity())
                .getSharedPreferences(AppConstans.PREFERENCE_NAME, view.getActivity().MODE_PRIVATE);
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString(key, Objects.requireNonNull(editText.getText()).toString());
        ed.apply();
    }

    private void loadText(String key, TextInputEditText editText) {
        preferences = Objects.requireNonNull(view.getActivity())
                .getSharedPreferences(AppConstans.PREFERENCE_NAME, view.getActivity().MODE_PRIVATE);
        String savedText = preferences.getString(key, "");
        editText.setText(savedText);
    }
}