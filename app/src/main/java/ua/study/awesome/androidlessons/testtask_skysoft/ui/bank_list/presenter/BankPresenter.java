package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.presenter;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.BankFragmentImpl;

public interface BankPresenter {
    void attachView(BankFragmentImpl bankFragmentImpl);
    void loadBank();
}