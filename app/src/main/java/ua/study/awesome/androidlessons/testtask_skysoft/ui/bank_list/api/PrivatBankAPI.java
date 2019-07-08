package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.api;

import io.reactivex.Observable;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PrivatBankAPI {

    @GET("p24api/infrastructure?json&atm&city=Vinnytsia")
    Call<BankListResponse> getBanks();


    @GET("p24api/infrastructure?json&atm&city=Vinnytsia")
    Observable<BankListResponse> getBanks2();

}