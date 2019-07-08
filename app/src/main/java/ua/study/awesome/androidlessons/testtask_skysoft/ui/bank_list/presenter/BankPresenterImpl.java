package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.presenter;

import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.BankRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.BankFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.api.PrivatBankAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.BankRepository;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.BankRepositoryImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.BanksMapperImpl;

public class BankPresenterImpl implements BankPresenter {

    private BankFragment view;
    private BanksMapperImpl banksMapperImpl;

    private CompositeDisposable mCompositeDisposable;

    BankRepository model;

    public BankPresenterImpl() {
        this.mCompositeDisposable = new CompositeDisposable();
        this.banksMapperImpl = new BanksMapperImpl();
        this.model = new BankRepositoryImpl();
    }

    @Override
    public void attachView(BankFragment bankFragment) {
        view = bankFragment;
    }

    @Override
    public void detachView() {
        this.view = null;
        mCompositeDisposable.dispose();
    }

    @Override
    public void loadBank() {
        PrivatBankAPI privatBankAPI = BankRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);

        Disposable disposable = privatBankAPI.getBanks2()
                .subscribeOn(Schedulers.io())
                .map(bankListResponse -> banksMapperImpl.transformResponseBankList(
                        bankListResponse.getBankResponseList()))
                .map(banksEntities -> banksMapperImpl.transformEntityBankList(banksEntities))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(banksModels -> {
                    view.onBanksLoaded(banksModels);
                    view.hideProgress();

                    Gson gson = new Gson();

                    String json = gson.toJson(banksModels);

                    view.showToast("1111111" + json);


                }, throwable -> view.showToast("error"));

        mCompositeDisposable.add(disposable);
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<BankListResponse>() {
//                    @Override
//                    public void accept(BankListResponse bankListResponse) throws Exception {
////                        Realm mRealm = Realm.getDefaultInstance();
////                        mRealm.beginTransaction();
////
//////                        BankListResponse bankListResponse = response.body();
////
////                        RealmList<BanksEntity> realmBankModelEntities = new RealmList<>();
////
////                        if (bankListResponse != null) {
////                            for (BankResponse banklist1 : bankListResponse.getBankResponseList()) {
////                                realmBankModelEntities.add(banksMapperImpl.transformResponseBankToEntity(banklist1, banklist1.hashCode()));
////                            }
////                        }
//
////                        mRealm.insertOrUpdate(realmBankModelEntities);
////                        mRealm.commitTransaction();
////                        mRealm.close();
//
//                        view.onBanksLoaded(bankListResponse);
//                        view.hideProgress();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable error) throws Exception {
//                        view.showToast();
//                    }
//                });


//        Call<BankListResponse> call = privatBankAPI.getBanks();
//        call.enqueue(new Callback<BankListResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<BankListResponse> call, @NonNull Response<BankListResponse> response) {
//                Realm mRealm = Realm.getDefaultInstance();
//                mRealm.beginTransaction();
//
//                BankListResponse bankListResponse = response.body();
//
//                RealmList<BanksEntity> realmBankModelEntities = new RealmList<>();
//
//                if (bankListResponse != null) {
//                    for (BankResponse banklist1: bankListResponse.getBankResponseList()) {
//                        realmBankModelEntities.add(banksMapperImpl.transformResponseBankToEntity(banklist1));
//                    }
//                }
//
//                mRealm.insertOrUpdate(realmBankModelEntities);
//                mRealm.commitTransaction();
//                mRealm.close();
//
//                view.onBanksLoaded(bankListResponse);
//                view.hideProgress();
//
//            }
//
//            @Override
//            public void onFailure(Call<BankListResponse> call, Throwable t) {
//                view.showToast();
//            }
//        });
    }

}