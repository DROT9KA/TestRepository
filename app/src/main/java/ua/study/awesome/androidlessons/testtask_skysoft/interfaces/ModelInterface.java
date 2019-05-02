package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.RealmBankModelEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.RealmTimeWorkModelEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.TimeWorkResponse;

public interface ModelInterface {

    RealmBankModelEntity transformBank(BankResponse bankResponse);
    RealmTimeWorkModelEntity transformBankTimeWork(TimeWorkResponse timeWorkResponse);
    void addBrowse(List<RealmBankModelEntity> realmBanks);

}
