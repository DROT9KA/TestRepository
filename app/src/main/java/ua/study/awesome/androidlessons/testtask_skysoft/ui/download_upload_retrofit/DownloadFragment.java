package ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.presenter.DownloadPresenter;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.presenter.DownloadPresenterImpl;

public class DownloadFragment extends BaseFragment implements DownloadView {

    @BindView(R.id.btn_download)
    Button btnDownload;

    @BindView(R.id.btn_upload)
    Button btnUpload;

    @BindView(R.id.download_image_view)
    ImageView imageView;

    @BindView(R.id.download_image_progress_bar)
    ProgressBar progressBar;

    DownloadPresenter presenter;

    private static final String ARG_TITLE = "TITLE";

    private String title;

    public static DownloadFragment getInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        DownloadFragment downloadFragment = new DownloadFragment();
        downloadFragment.setArguments(bundle);

        return downloadFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    public static final String FRAGMENT_TAG = DownloadFragment.class.getSimpleName();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_retrofit;
    }

    @OnClick(R.id.btn_download)
    void onClickDownload(){
        progressBar.setVisibility(View.VISIBLE);
        presenter.downloadImage();
    }

    @OnClick(R.id.btn_upload)
    void onClickUpload(){
        progressBar.setVisibility(View.VISIBLE);
        presenter.uploadImage();
    }

    private void init(){
        presenter = new DownloadPresenterImpl();
        presenter.atachView(this);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));

    }

    @Override
    public void showPicture(Bitmap bmp){
        imageView.setImageBitmap(bmp);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String string, Response response) {
        Toast.makeText(getContext(), string + response, Toast.LENGTH_SHORT).show();
    }
}