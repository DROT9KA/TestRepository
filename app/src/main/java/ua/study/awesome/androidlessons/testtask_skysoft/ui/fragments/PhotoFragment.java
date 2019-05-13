package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.BuildConfig;
import ua.study.awesome.androidlessons.testtask_skysoft.R;

import static android.app.Activity.RESULT_OK;

public class PhotoFragment extends BaseFragment {

    public static final String FRAGMENT_TAG = PhotoFragment.class.getSimpleName();

    File directory;
    File photoDirectory;

    @BindView(R.id.btn_Photo)
    Button btnPhoto;

    @BindView(R.id.iv_Photo)
    ImageView ivPhoto;

    private final int TYPE_PHOTO = 1;

    private final int REQUEST_CODE_PHOTO = 1;

    final String TAG = "myLogs";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createDirectory();
    }

    @Override
    public int provideView() {
        return R.layout.fragment_photo;
    }

    @Override
    public Object butterKnifeBind() {
        return this;
    }

    @OnClick(R.id.btn_Photo)
    public void onClickPhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        intent.putExtra(MediaStore.EXTRA_OUTPUT, generateFileUri(TYPE_PHOTO));
        startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_PHOTO) {
            if (resultCode == RESULT_OK) {
                if (intent == null) {
                } else {
                    Bundle bndl = intent.getExtras();
                    if (bndl != null) {
                        Object obj = intent.getExtras().get("data");
                        if (obj instanceof Bitmap) {
                            Bitmap bitmap = (Bitmap) obj;
                            ivPhoto.setImageBitmap(bitmap);
                        }
                    }
                }
            }
        }
    }

    private Uri generateFileUri(int type) {
        Uri outputFileUri = null;
        File file = null;
        if (type == TYPE_PHOTO) {
            file = new File(photoDirectory, "photo_"
                    + System.currentTimeMillis() + ".jpg");
            outputFileUri = FileProvider.getUriForFile(Objects.requireNonNull(getContext()), BuildConfig.APPLICATION_ID + ".provider", file);
        }
        return outputFileUri;
    }

    private void createDirectory() {
        directory = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
                "TestTask_SkySoft");
        if (!directory.exists())
            directory.mkdirs();

        photoDirectory = new File(directory, "Photo");
        if (!photoDirectory.exists())
            photoDirectory.mkdirs();
    }
}