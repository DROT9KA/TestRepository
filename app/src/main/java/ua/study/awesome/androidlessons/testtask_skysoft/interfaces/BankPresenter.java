package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankImpl;

public interface BankPresenter {
    void attachView(BankImpl bankFragmentImpl);
    void loadBank();
}