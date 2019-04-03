package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.FragmentBank;

public interface PresenterInterface {
    void attachView(FragmentBank fragmentBank);
    void loadBank();
}