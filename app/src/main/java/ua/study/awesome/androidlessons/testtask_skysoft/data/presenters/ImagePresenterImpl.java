package ua.study.awesome.androidlessons.testtask_skysoft.data.presenters;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ImagePresenter;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.ImageFragmentImpl;

public class ImagePresenterImpl implements ImagePresenter {

    private ImageFragmentImpl view;

    @Override
    public void attachView(ImageFragmentImpl imageFragment) {
        view = imageFragment;
    }

    @Override
    public List<String> getAllShownImagesPath() {
        Uri uri;
        Cursor cursor;
        int column_index_data;
        List<String> listOfAllImages = new ArrayList<>();
        String absolutePathOfImage;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        cursor = Objects.requireNonNull(view.getActivity()).getContentResolver().query(uri, projection, null,
                null, null);

        if (cursor != null) {
            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            while (cursor.moveToNext()) {
                absolutePathOfImage = cursor.getString(column_index_data);

                listOfAllImages.add(absolutePathOfImage);
            }
        }
        return listOfAllImages;
    }
}