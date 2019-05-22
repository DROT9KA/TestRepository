package ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.presenter;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.GalleryFragment;

public class GalleryPresenterImpl implements GalleryPresenter {

    private GalleryFragment view;

    @Override
    public void attachView(GalleryFragment galleryFragment) {
        view = galleryFragment;
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