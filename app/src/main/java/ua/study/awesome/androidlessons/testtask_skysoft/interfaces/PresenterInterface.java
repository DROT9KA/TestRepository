package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankFragment;

public interface PresenterInterface {
    void attachView(BankFragment bankFragment);
    void loadBank();
}