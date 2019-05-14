package ua.study.awesome.androidlessons.testtask_skysoft.ui.LoginScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import butterknife.BindView;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BaseFragment;

public class LoginFragment extends BaseFragment {

    public static final String FRAGMENT_TAG = LoginFragment.class.getSimpleName();
    private final String title = "Login";

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.edt_login_user_name_email)
    TextInputEditText edtUserName;

    @BindView(R.id.edt_login_password)
    TextInputEditText edtPassword;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int provideView() {
        return R.layout.fragment_login;
    }

    @Override
    public Object butterKnifeBind() {
        return this;
    }

    public void init(){
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle(title);
    }
}