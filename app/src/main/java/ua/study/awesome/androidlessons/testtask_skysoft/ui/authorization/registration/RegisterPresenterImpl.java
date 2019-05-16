package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.Objects;
import java.util.regex.Pattern;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegistrationFragment view;

    private SharedPreferences preferences;

    private UserRepositoryImpl model = new UserRepositoryImpl();

    @Override
    public void atachView(RegistrationFragment registrationFragment) {
        view = registrationFragment;
    }

    @Override
    public void validateRegistration(String username, String email, String password, String confirmPassword) {
        boolean isCancel = true;

        if (TextUtils.isEmpty(username)) {
            isCancel = false;
            view.onErrorUsername("Please enter User name");
        } else {
            view.disableUserNameError();

            if (!validUserName(username)) {
                isCancel = false;
                view.onErrorUsername("Wrong User Name");
            } else view.disableUserNameError();
        }

        if (TextUtils.isEmpty(email)) {
            isCancel = false;
            view.onErrorEmail("Please enter email");
        } else {
            view.disableEmailError();

            if (!validEmail(email)) {
                isCancel = false;
                view.onErrorEmail("Wrong email");
            } else view.disableEmailError();
        }

        if (TextUtils.isEmpty(password)) {
            isCancel = false;
            view.onErrorPassword("Please enter password");
        } else {
            view.disablePassEror();

            if (!validPassword(password)) {
                isCancel = false;
                view.onErrorPassword("Password must contain at least 6 characters");
            } else view.disablePassEror();
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            isCancel = false;
            view.onErrorConfirmPassword("Please enter confirm Password");
        } else {
            view.disableConfirmPassError();

            if (!equalsPass(password, confirmPassword)) {
                isCancel = false;
                view.onErrorConfirmPassword("Passwords do not match");
            } else view.disableConfirmPassError();
        }

        if (isCancel) {
            view.onSuccessRegistration();
            model.onAddUser(new UserEntity(username, email, password));
        }
    }

    private boolean equalsPass(String password, String confirmPassword) {
        boolean bool = false;
        if (password.equals(confirmPassword)) {
            bool = true;
        }
        return bool;
    }

    private boolean validPassword(String password) {
        boolean bool = false;
        if (isValidPassword(password)) {
            bool = true;
        }
        return bool;
    }

    private boolean validEmail(String email) {
        boolean bool = false;
        if (isValidEmail(email)) {
            bool = true;
        }
        return bool;
    }

    private boolean validUserName(String userName) {
        boolean bool = false;
        if (isValidUsername(userName)) {
            bool = true;
        }
        return bool;
    }

    private boolean isValidUsername(String s) {
        Pattern USER_NAME_PATTERN
                = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{4,24}");

        return !TextUtils.isEmpty(s) && USER_NAME_PATTERN.matcher(s).matches();
    }


    private boolean isValidEmail(String s) {
        return !TextUtils.isEmpty(s) && Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }


    private boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN
                = Pattern.compile(
                "[a-zA-Z0-9\\!\\@\\#\\$]{6,24}");

        return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
    }

    @Override
    public void loadAllData(TextInputEditText edtUserName, TextInputEditText edtEmail,
                            TextInputEditText edtPassword, TextInputEditText edtConfirmPassword) {
        loadText(AppConstans.REGISTER_USER_NAME, edtUserName);
        loadText(AppConstans.REGISTER_E_MAIL, edtEmail);
        loadText(AppConstans.REGISTER_PASSWORD, edtPassword);
        loadText(AppConstans.REGISTER_CONFIRM_PASSWORD, edtConfirmPassword);
    }

    @Override
    public void savedAllData(TextInputEditText edtUserName, TextInputEditText edtEmail,
                             TextInputEditText edtPassword, TextInputEditText edtConfirmPassword) {
        saveText(AppConstans.REGISTER_USER_NAME, edtUserName);
        saveText(AppConstans.REGISTER_E_MAIL, edtEmail);
        saveText(AppConstans.REGISTER_PASSWORD, edtPassword);
        saveText(AppConstans.REGISTER_CONFIRM_PASSWORD, edtConfirmPassword);
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