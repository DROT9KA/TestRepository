package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;

public interface BankRepository {

    void onAddBanks(BankResponse response);

    void onRemoveBank(String username);

    UserEntity getBanks(String username);
}
