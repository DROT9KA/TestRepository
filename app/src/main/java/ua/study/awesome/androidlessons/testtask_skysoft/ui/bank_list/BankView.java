package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankListResponse;

public interface BankView {

    void onBanksLoaded(BankListResponse bankListResponse);
    void showDetailFrag(int number);
    void hideProgress();
    void showToast();
}