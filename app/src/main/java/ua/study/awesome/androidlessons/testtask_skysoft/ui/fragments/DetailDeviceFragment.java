package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;

public class DetailDeviceFragment extends BaseFragment {

    public static final String FRAGMENT_TAG = DetailDeviceFragment.class.getSimpleName();

    @BindView(R.id.detail_device_info)
    TextView tvDetailInfo;



    private static final String ARG_ID = "ID";
    private static final String ARG_NAME = "NAME";
    private static final String ARG_DESCRIPTION = "DESCRIPTION";

    public static DetailDeviceFragment newInstance(int id, String name, String description){
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_ID, id);
        bundle.putString(ARG_NAME, name);
        bundle.putString(ARG_DESCRIPTION, description);

        DetailDeviceFragment fragment = new DetailDeviceFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    private int id;
    private String name;
    private String description;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            id = getArguments().getInt(ARG_ID);
            name = getArguments().getString(ARG_NAME);
            description = getArguments().getString(ARG_DESCRIPTION);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        showDeviceDetails();

    }

    @Override
    public int provideView() {
        return R.layout.detail_device_fragment;
    }

    @Override
    public Object butterKnifeBind() {
        return this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Objects.requireNonNull(getActivity()).onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void init(){

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle("Detail Info");

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    void showDeviceDetails(){
        tvDetailInfo.setText("Id : " + id + "\n"
                + "Name: " + name + "\n"
                + "Description: " + description);

    }
}