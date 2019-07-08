package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Entity.BanksEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Entity.TimeWorkEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.BanksModel;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.TimeWorkModel;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.TimeWorkResponse;

public interface BanksMapper {

    BanksEntity transformResponseBankToEntity(BankResponse bankResponse, int hashCode);

    BanksModel transformEntityBankToModel(BanksEntity banksEntity);

    TimeWorkEntity transformResponseBankTimeWorkToEntity(TimeWorkResponse timeWorkResponse);

    TimeWorkModel transformEntityBankTimeWorkToModel(TimeWorkEntity timeWorkEntity);

}