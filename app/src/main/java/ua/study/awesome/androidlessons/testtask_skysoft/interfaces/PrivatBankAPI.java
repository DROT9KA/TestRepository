package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PrivatBankAPI {

    @GET("p24api/infrastructure?json&atm&city=Vinnytsia")
    Call<BankList> getBanks();

}