package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.presenter;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.BankFragment;

public interface BankPresenter {
    void attachView(BankFragment bankFragment);
    void detachView();
    void loadBank();
}