package ua.study.awesome.androidlessons.testtask_skysoft.presenters;

import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Model;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.RealmBankModel;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.Bank;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankList;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.PresenterInterface;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.PrivatBankAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.MainRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankFragment;

public class BankPresenter implements PresenterInterface {

    private BankFragment view;
    private Model model = new Model();

    @Override
    public void attachView(BankFragment bankFragment){
        view = bankFragment;
    }

    @Override
    public void loadBank() {
        PrivatBankAPI privatBankAPI = MainRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);

        Call<BankList> call = privatBankAPI.getBanks();
        call.enqueue(new Callback<BankList>() {
            @Override
            public void onResponse(@NonNull Call<BankList> call, @NonNull Response<BankList> response) {
                Realm mRealm = Realm.getDefaultInstance();
                mRealm.beginTransaction();

                BankList bankList = response.body();

                RealmList<RealmBankModel> realmBankModels = new RealmList<>();

                if (bankList != null) {
                    for (Bank banklist1: bankList.getBankList()) {
                        realmBankModels.add(model.transformBank(banklist1));
                    }
                }

                mRealm.insertOrUpdate(realmBankModels);
                mRealm.commitTransaction();
                mRealm.close();

                view.onBanksLoaded(bankList);
                view.hideProgress();


            }

            @Override
            public void onFailure(Call<BankList> call, Throwable t) {
                view.showToast();
            }
        });
    }

}