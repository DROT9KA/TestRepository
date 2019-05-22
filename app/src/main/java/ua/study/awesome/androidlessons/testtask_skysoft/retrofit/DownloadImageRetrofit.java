package ua.study.awesome.androidlessons.testtask_skysoft.retrofit;

import retrofit2.Retrofit;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class DownloadImageRetrofit {

    private Retrofit retrofit;

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private static DownloadImageRetrofit instance;

    private DownloadImageRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstans.BASE_IMAGE_URL)
                .build();
    }

    public static DownloadImageRetrofit getInstance(){
        if (instance == null){
            instance = new DownloadImageRetrofit();
        }
        return instance;
    }
}