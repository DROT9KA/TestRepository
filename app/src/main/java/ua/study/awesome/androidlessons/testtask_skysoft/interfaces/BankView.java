package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankListResponse;

public interface BankView {

    void onBanksLoaded(BankListResponse bankListResponse);
    void showDetailFrag(int number);
    void hideProgress();
    void showToast();
}