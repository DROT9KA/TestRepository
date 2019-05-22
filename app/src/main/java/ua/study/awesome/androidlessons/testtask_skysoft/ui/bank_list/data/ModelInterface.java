package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.TimeWorkResponse;

public interface ModelInterface {

    RealmBankModelEntity transformBank(BankResponse bankResponse);
    RealmTimeWorkModelEntity transformBankTimeWork(TimeWorkResponse timeWorkResponse);

}