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

public class RegistrationFragment extends BaseFragment {

    public static final String FRAGMENT_TAG = RegistrationFragment.class.getSimpleName();
    private final String title = "Registration";

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int provideView() {
        return R.layout.fragment_registration;
    }

    @Override
    public Object butterKnifeBind() {
        return this;
    }

    public void init(){
        Objects.requireNonNull(((SignInUpActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle(title);
    }
}
