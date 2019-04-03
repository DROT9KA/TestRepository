package ua.study.awesome.androidlessons.testtask_skysoft.presenters;

import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.DetailBankPresenterInterface;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.DetailBankFragment;

public class DetailBankPresenter implements DetailBankPresenterInterface {

    private DetailBankFragment view;

    @Override
    public void attachView(DetailBankFragment detailBankFragment){
        view = detailBankFragment;
    }
}