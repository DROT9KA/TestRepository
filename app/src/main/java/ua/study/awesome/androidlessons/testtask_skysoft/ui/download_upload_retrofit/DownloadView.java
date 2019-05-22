package ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit;

import android.graphics.Bitmap;

import retrofit2.Response;

public interface DownloadView {

    void showPicture(Bitmap bmp);
    void hideProgress();

    void showToast(String string, Response response);
}