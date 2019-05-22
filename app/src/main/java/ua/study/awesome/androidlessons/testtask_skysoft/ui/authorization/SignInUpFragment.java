package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration.RegistrationFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.login.LoginFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseFragment;

public class SignInUpFragment extends BaseFragment {

    public static final String FRAGMENT_TAG = SignInUpFragment.class.getSimpleName();
    private final String title = "Authorization";

    @BindView(R.id.btn_sign_in)
    Button btnSignIn;

    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    @BindView(R.id.btn_quick_login)
    Button btnQuick;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragmnent_sign_in_up;
    }

    @OnClick(R.id.btn_quick_login)
    public void quickLogin(){
        startActivity(new Intent(getContext(), MainActivity.class));
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @OnClick(R.id.btn_sign_in)
    public void signIn(){
        ((SignInUpActivity) Objects.requireNonNull(getActivity())).replaceFragment(new LoginFragment(),
                LoginFragment.FRAGMENT_TAG , R.id.login_container);
    }

    @OnClick(R.id.btn_sign_up)
    public void signUp(){
        ((SignInUpActivity) Objects.requireNonNull(getActivity())).replaceFragment(new RegistrationFragment(),
                RegistrationFragment.FRAGMENT_TAG, R.id.login_container);
    }

    public void init(){
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(title);
    }
}
