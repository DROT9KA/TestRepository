package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.presenter;

import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.BankFragmentImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.api.PrivatBankAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankListResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.BankRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.ModelEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.RealmBankModelEntity;

public class BankPresenterImpl implements BankPresenter {

    private BankFragmentImpl view;
    private ModelEntity modelEntity = new ModelEntity();

    @Override
    public void attachView(BankFragmentImpl bankFragmentImpl){
        view = bankFragmentImpl;
    }

    @Override
    public void loadBank() {
        PrivatBankAPI privatBankAPI = BankRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);

        Call<BankListResponse> call = privatBankAPI.getBanks();
        call.enqueue(new Callback<BankListResponse>() {
            @Override
            public void onResponse(@NonNull Call<BankListResponse> call, @NonNull Response<BankListResponse> response) {
                Realm mRealm = Realm.getDefaultInstance();
                mRealm.beginTransaction();

                BankListResponse bankListResponse = response.body();

                RealmList<RealmBankModelEntity> realmBankModelEntities = new RealmList<>();

                if (bankListResponse != null) {
                    for (BankResponse banklist1: bankListResponse.getBankResponseList()) {
                        realmBankModelEntities.add(modelEntity.transformBank(banklist1));
                    }
                }

                mRealm.insertOrUpdate(realmBankModelEntities);
                mRealm.commitTransaction();
                mRealm.close();

                view.onBanksLoaded(bankListResponse);
                view.hideProgress();

            }

            @Override
            public void onFailure(Call<BankListResponse> call, Throwable t) {
                view.showToast();
            }
        });
    }

}