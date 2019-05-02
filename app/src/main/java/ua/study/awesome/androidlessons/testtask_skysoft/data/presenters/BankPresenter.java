package ua.study.awesome.androidlessons.testtask_skysoft.data.presenters;

import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.ModelEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.RealmBankModelEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankListResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.PresenterInterface;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.PrivatBankAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.MainRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankFragment;

public class BankPresenter implements PresenterInterface {

    private BankFragment view;
    private ModelEntity modelEntity = new ModelEntity();

    @Override
    public void attachView(BankFragment bankFragment){
        view = bankFragment;
    }

    @Override
    public void loadBank() {
        PrivatBankAPI privatBankAPI = MainRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);

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