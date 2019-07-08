package ua.study.awesome.androidlessons.testtask_skysoft.ui.rx_search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import butterknife.BindView;
import io.reactivex.Observable;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;

public class RxSearchFragment extends BaseFragment {

    @BindView(R.id.edt_text_rx)
    EditText editText;

    public static final String FRAGMENT_TAG = RxSearchFragment.class.getSimpleName();

    private static final String ARG_TITLE = "TITLE";

    private String title;

    public static RxSearchFragment getInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        RxSearchFragment rxSearchFragment = new RxSearchFragment();
        rxSearchFragment.setArguments(bundle);

        return rxSearchFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .subscribe(s -> editText.setHint(s));

        ontesting(s -> ffffff(s));

        ontesting(new OnTestLambda2() {
            @Override
            public void onTest2() {

            }

            @Override
            public void onTest3() {

            }
        });
    }

    private void ffffff(String s){}

    private void ontesting(OnTestLambda testLambda) {

    }

    private void ontesting(OnTestLambda2 testLambda) {

    }

    private void init(){
        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rx_search;
    }

//    public void updateAccount(UserAccount.Personal personal) {
//        if (!getMvpView().isNetworkConnected()) {
//            handleError(new Throwable(), R.string.error_connectivity);
//            return;
//        }
//
//        if (isAvatarUpdated) {
//            personal.setAvatar(encodedBase64Image);
//        }
//
//        Disposable disposable = RestClient.getApiService()
//                .updateAccount(personal)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        response -> {
//                            AccountController.saveAccount(response);
//                            new AppPrefsHelper().putBoolean(PrefsKeys.IS_REGISTERED, true);
//                            getMvpView().onSuccessAccountUpdate();
//
//                        },
//                        error -> getMvpView().onErrorAccountUpdate());
//        addDisposable(disposable);
//    }
}