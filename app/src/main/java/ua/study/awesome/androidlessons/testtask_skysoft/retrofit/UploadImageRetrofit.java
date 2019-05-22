package ua.study.awesome.androidlessons.testtask_skysoft.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class UploadImageRetrofit {

    private Retrofit retrofit;

    private static UploadImageRetrofit instance;

    public Retrofit getRetrofit(){
        return retrofit;
    }

    private UploadImageRetrofit(){
       OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstans.BASE_UPLOAD_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static UploadImageRetrofit getInstance(){
        if (null == instance){
            instance = new UploadImageRetrofit();
        }
        return instance;
    }

}