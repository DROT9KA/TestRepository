package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.SignInUpActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BaseFragment;

public class RegistrationFragment extends BaseFragment implements RegisterView {

    public static final String FRAGMENT_TAG = RegistrationFragment.class.getSimpleName();

    RegisterPresenter presenter;

    @BindView(R.id.edt_registration_user_name)
    TextInputEditText edtUserName;

    @BindView(R.id.edt_registration_email)
    TextInputEditText edtEmail;

    @BindView(R.id.edt_registration_password)
    TextInputEditText edtPassword;

    @BindView(R.id.edt_registration_confirm_password)
    TextInputEditText edtConfirmPassword;

    @BindView(R.id.btn_register)
    Button btnRegister;

    @BindView(R.id.input_layout_registration_user_name)
    TextInputLayout userNameLayout;

    @BindView(R.id.input_layout_registration_email)
    TextInputLayout emailLayout;

    @BindView(R.id.input_layout_registration_password)
    TextInputLayout passwordLayout;

    @BindView(R.id.input_layout_registration_confirm_password)
    TextInputLayout confirmPassLayout;

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadAllData(edtUserName, edtEmail, edtPassword, edtConfirmPassword);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.savedAllData(edtUserName, edtEmail, edtPassword, edtConfirmPassword);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int provideView() {
        return R.layout.fragment_registration;
    }

    private void init() {
        presenter = new RegisterPresenterImpl();
        presenter.atachView(this);

        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        String title = "Registration";
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Objects.requireNonNull(getActivity()).onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_register)
    public void clickRegister() {
        String userName = Objects.requireNonNull(edtUserName.getText()).toString().trim();
        String email = Objects.requireNonNull(edtEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(edtPassword.getText()).toString().trim();
        String confirmPassword = Objects.requireNonNull(edtConfirmPassword.getText()).toString().trim();

        presenter.validateRegistration(userName, email, password, confirmPassword);
    }

    @Override
    public void onSuccessRegistration() {
        startActivity(new Intent(getContext(), MainActivity.class));
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override
    public void onErrorUsername(String error) {
        userNameLayout.setError(error);
    }

    @Override
    public void onErrorEmail(String error) {
        emailLayout.setError(error);
    }

    @Override
    public void onErrorPassword(String error) {
        passwordLayout.setError(error);
    }

    @Override
    public void onErrorConfirmPassword(String error) {
        confirmPassLayout.setError(error);
    }

    @Override
    public void disableUserNameError(){
        userNameLayout.setErrorEnabled(false);
    }

    @Override
    public void disableEmailError(){
        emailLayout.setErrorEnabled(false);
    }

    @Override
    public void disablePassEror(){
        passwordLayout.setErrorEnabled(false);
    }

    @Override
    public void disableConfirmPassError(){
        confirmPassLayout.setErrorEnabled(false);
    }
}