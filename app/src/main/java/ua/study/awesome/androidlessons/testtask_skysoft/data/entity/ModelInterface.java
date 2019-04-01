package ua.study.awesome.androidlessons.testtask_skysoft.data.entity;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.data.response.Bank;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.TimeWork;

public interface ModelInterface {

    RealmBankModel transformBank(Bank bank);
    RealmTimeWorkModel transformBankTimeWork(TimeWork timeWork);
    void addBrowse(List<RealmBankModel> realmBanks);

}
