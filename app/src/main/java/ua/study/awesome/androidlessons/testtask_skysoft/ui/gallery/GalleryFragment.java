package ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.presenter.GalleryPresenterImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.recycler.GalleryAdapter;

public class GalleryFragment extends BaseFragment implements GalleryView {

    public static final String FRAGMENT_TAG = GalleryFragment.class.getSimpleName();

    @BindView(R.id.recycler_image)
    RecyclerView recyclerView;

    private List<String> images;

    GalleryPresenterImpl presenter;

    GalleryAdapter adapter;

    private static final String ARG_TITLE = "TITLE";

    private String title;

    public static GalleryFragment getInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        GalleryFragment galleryFragment = new GalleryFragment();
        galleryFragment.setArguments(bundle);

        return galleryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settingTitle();
        checkPermission();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_image;
    }

    @Override
    public void checkPermission() {
        int permissionStatusREAD = ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
                Manifest.permission.READ_EXTERNAL_STORAGE);

        int permissionStatusWRITE = ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionStatusREAD == PackageManager.PERMISSION_GRANTED && permissionStatusWRITE == PackageManager.PERMISSION_GRANTED) {

            presenter = new GalleryPresenterImpl();
            presenter.attachView(this);

            images = new ArrayList<>(presenter.getAllShownImagesPath());
            init();

        } else {
            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity())
                    , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , getTargetRequestCode());
        }
    }

    @Override
    public void init() {
        adapter = new GalleryAdapter(getContext());
        adapter.setImages(images);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
    }

    public void settingTitle(){
        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));
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