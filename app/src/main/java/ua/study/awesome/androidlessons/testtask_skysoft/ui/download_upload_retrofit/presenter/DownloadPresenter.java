package ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.presenter;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.DownloadFragment;

public interface DownloadPresenter {

    void atachView(DownloadFragment downloadFragment);
    void downloadImage();
    void uploadImage();

}