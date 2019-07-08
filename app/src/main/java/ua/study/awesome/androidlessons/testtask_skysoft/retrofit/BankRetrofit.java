package ua.study.awesome.androidlessons.testtask_skysoft.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class BankRetrofit {

    private Retrofit retrofit;

    private static BankRetrofit instance;

    public Retrofit getRetrofit(){
        return retrofit;
    }

    private BankRetrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstans.BASE_BANK_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static BankRetrofit getInstance(){
        if (null == instance){
            instance = new BankRetrofit();
        }
        return instance;
    }

}