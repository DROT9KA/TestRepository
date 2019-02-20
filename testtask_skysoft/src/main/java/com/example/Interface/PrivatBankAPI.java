package com.example.Interface;

import com.example.testtask_skysoft.BankList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PrivatBankAPI {

    @GET("infrastructure?json&atm&city=Vinnytsia")
    Call<BankList> getBanks();

}