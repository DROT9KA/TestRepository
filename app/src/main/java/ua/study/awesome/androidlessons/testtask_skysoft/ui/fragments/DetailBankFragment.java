package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.RealmBankModel;
import ua.study.awesome.androidlessons.testtask_skysoft.presenters.DetailBankPresenter;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;

public class DetailBankFragment extends Fragment {

    DetailBankPresenter presenter;

    private int number;

    public static DetailBankFragment newInstance (int number){
        Bundle bundle = new Bundle();
        bundle.putInt("Number", number);

        DetailBankFragment detailBankFragment = new DetailBankFragment();
        detailBankFragment.setArguments(bundle);

        return detailBankFragment;
    }

    private void readBundle(Bundle bundle){
        if(bundle != null){
            number = bundle.getInt("Number");
        }
    }

    @BindView(R.id.detail_info)
    TextView tvDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_bank_fragment, container, false);
        Unbinder unbinder = ButterKnife.bind(this,v);

        init();
        showDetails();

        return v;
    }

    void init(){
        presenter = new DetailBankPresenter();
        presenter.attachView(this);

        readBundle(getArguments());

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle("Detail Info");
    }

    void showDetails(){
        Realm mRealm = Realm.getDefaultInstance();
        final RealmResults<RealmBankModel> result = mRealm.where(RealmBankModel.class).findAll();

        tvDetail.setText("Тип " + result.get(number).getType() + "\n"
                + result.get(number).getFullAddressEn() + "\n"
                + result.get(number).getFullAddressRu() + "\n"
                + result.get(number).getFullAddressUa() + "\n"
                + result.get(number).getPlaceRu() + "\n"
                + result.get(number).getPlaceUa() + "\n"
                + "Широта - : " + result.get(number).getLatitude() + "\n"
                + "Довгота - : " + result.get(number).getLongitude() + "\n"
                + "Робочий час : "  + "\n" + result.get(number).getTw().getMon() + "\n"
                + "Понеділок: " + result.get(number).getTw().getTue() + "\n"
                + "Вівторок: " + result.get(number).getTw().getWed() + "\n"
                + "Середа: " + result.get(number).getTw().getThu() + "\n"
                + "Четвер: " + result.get(number).getTw().getWed() + "\n"
                + "П'ятниця: " + result.get(number).getTw().getFri() + "\n"
                + "Субота: " + result.get(number).getTw().getSat() + "\n"
                + "Неділя: " + result.get(number).getTw().getSun() + "\n"
                + "Свята: " + result.get(number).getTw().getHol() + "\n");
    }
}