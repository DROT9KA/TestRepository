package com.example.myapplication.qweqweqwe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public  class PagerFragment extends Fragment {

    @BindView(R.id.tv_pager)
    TextView textView;
    int pageNumber;

    Unbinder unbinder;

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    public static PagerFragment newInstance(int page) {
        PagerFragment pageFragment = new PagerFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);

        unbinder = ButterKnife.bind(this, view);

        textView.setText("Page" + pageNumber);

        return view;
    }
}