package ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.presenter;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.GalleryFragment;

public interface GalleryPresenter {

    void attachView(GalleryFragment galleryFragment);
    List<String> getAllShownImagesPath();

}