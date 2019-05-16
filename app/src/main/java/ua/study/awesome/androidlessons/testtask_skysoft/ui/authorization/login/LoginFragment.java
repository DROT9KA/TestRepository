package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.login;

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

public class LoginFragment extends BaseFragment implements LoginView {

    public static final String FRAGMENT_TAG = LoginFragment.class.getSimpleName();

    LoginPresenter presenter;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.edt_login_user_name_email)
    TextInputEditText edtLogin;

    @BindView(R.id.edt_login_password)
    TextInputEditText edtLoginPassword;

    @BindView(R.id.input_layout_login_user_name)
    TextInputLayout userNameLayout;

    @BindView(R.id.input_layout_login_password)
    TextInputLayout passwordLayout;

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadAllData(edtLogin, edtLoginPassword);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.saveAllData(edtLogin, edtLoginPassword);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int provideView() {
        return R.layout.fragment_login;
    }

    public void init(){
        presenter = new LoginPresenterImpl();
        presenter.atachView(this);

        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        String title = "Login";
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_login)
    public void clickLogin(){
        String login = Objects.requireNonNull(edtLogin.getText()).toString().trim();
        String password = Objects.requireNonNull(edtLoginPassword.getText()).toString().trim();

        presenter.validateLogin(login, password);
    }

    @Override
    public void onErrorLogin(String error) {
        userNameLayout.setError(error);
    }

    @Override
    public void onErrorPassword(String error) {
        passwordLayout.setError(error);
    }

    @Override
    public void disableLoginError() {
        userNameLayout.setErrorEnabled(false);
    }

    @Override
    public void disablePasswordError() {
        passwordLayout.setErrorEnabled(false);
    }

    @Override
    public void onSuccessLogin() {
        startActivity(new Intent(getContext(), MainActivity.class));
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}