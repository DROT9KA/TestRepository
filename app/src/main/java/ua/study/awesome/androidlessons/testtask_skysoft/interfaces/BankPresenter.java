package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankFragmentImpl;

public interface BankPresenter {
    void attachView(BankFragmentImpl bankFragmentImpl);
    void loadBank();
}