package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration;

import android.support.design.widget.TextInputEditText;

public interface RegisterPresenter {
    void atachView(RegistrationFragment registrationFragment);

    void savedAllData(TextInputEditText edtUserName, TextInputEditText edtEmail,
                      TextInputEditText edtPassword, TextInputEditText edtConfirmPassword);

    void loadAllData(TextInputEditText edtUserName, TextInputEditText edtEmail,
                     TextInputEditText edtPassword, TextInputEditText edtConfirmPassword);

    void validateRegistration(String username, String email, String password, String confirmPassword);
}