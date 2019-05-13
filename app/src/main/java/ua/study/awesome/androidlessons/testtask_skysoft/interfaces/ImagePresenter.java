package ua.study.awesome.androidlessons.testtask_skysoft.interfaces;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.ImageFragmentImpl;

public interface ImagePresenter {

    void attachView(ImageFragmentImpl imageFragment);
    List<String> getAllShownImagesPath();

}