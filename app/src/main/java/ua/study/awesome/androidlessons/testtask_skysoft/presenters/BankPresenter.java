package ua.study.awesome.androidlessons.testtask_skysoft.presenters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankList;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.PrivatBankAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.MainRetrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.FragmentBank;

public class BankPresenter implements PresenterInterface {

    private FragmentBank view;

    @Override
    public void attachView(FragmentBank fragmentBank){
        view = fragmentBank;
    }

    @Override
    public void loadBank(){
        PrivatBankAPI privatBankAPI = MainRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);

        Call<BankList> call = privatBankAPI.getBanks();
        call.enqueue(new Callback<BankList>() {
            @Override
            public void onResponse(Call<BankList> call, Response<BankList> response) {
                BankList bankList = response.body();
                view.onBanksLoaded(bankList);
                view.makeItInvisibleProgressBar();
            }

            @Override
            public void onFailure(Call<BankList> call, Throwable t) {
                view.showToast();
            }

        });
    }
}