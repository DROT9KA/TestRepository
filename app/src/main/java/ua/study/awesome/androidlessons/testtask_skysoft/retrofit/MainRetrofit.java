package ua.study.awesome.androidlessons.testtask_skysoft.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class MainRetrofit {

    private Retrofit retrofit;

    private static MainRetrofit instance;

    public Retrofit getRetrofit(){
        return retrofit;
    }

    private MainRetrofit (){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstans.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MainRetrofit getInstance(){
        if (null == instance){
            instance = new MainRetrofit();
        }
        return instance;
    }

}
