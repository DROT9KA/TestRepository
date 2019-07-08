package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.BanksModel;

public interface BankView {

    void onBanksLoaded(List<BanksModel> bankListResponse);
    void showDetailFrag(int number);
    void hideProgress();
    void showToast(String string);
}