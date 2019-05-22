package ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public interface ImageDownloadAPI {

    @GET(AppConstans.IMAGE_URL)
    Call<ResponseBody> getImage();

}