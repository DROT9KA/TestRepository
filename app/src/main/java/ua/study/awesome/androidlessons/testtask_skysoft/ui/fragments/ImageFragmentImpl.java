package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.presenters.ImagePresenterImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ImageView;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.ImageAdapter;

public class ImageFragmentImpl extends BaseFragment implements ImageView {

    public static final String FRAGMENT_TAG = ImageFragmentImpl.class.getSimpleName();

    @BindView(R.id.recycler_image)
    RecyclerView recyclerView;

    private List<String> images;

    ImagePresenterImpl presenter;

    ImageAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settingTitle();
        checkPermission();
    }

    @Override
    public int provideView() {
        return R.layout.fragment_image;
    }

    @Override
    public Object butterKnifeBind() {
        return this;
    }

    @Override
    public void checkPermission() {
        int permissionStatusREAD = ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
                Manifest.permission.READ_EXTERNAL_STORAGE);

        int permissionStatusWRITE = ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionStatusREAD == PackageManager.PERMISSION_GRANTED && permissionStatusWRITE == PackageManager.PERMISSION_GRANTED) {

            presenter = new ImagePresenterImpl();
            presenter.attachView(this);

            images = new ArrayList<>(presenter.getAllShownImagesPath());
            init();

        } else {
            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity())
                    , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , getTargetRequestCode());
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//            case 100:
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//
//                    presenter = new ImagePresenterImpl();
//                    presenter.attachView(this);
//
//                    images = new ArrayList<>(presenter.getAllShownImagesPath());
//                    init();
//
//                } else {
//                    int asd;
//                    // permission denied
//                }
//                return;
//        }
//
//    }

    @Override
    public void init() {
        adapter = new ImageAdapter(getContext());
        adapter.setImages(images);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
    }

    public void settingTitle(){
        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle("Images from gallery");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((MainActivity) Objects.requireNonNull(getActivity())).drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}