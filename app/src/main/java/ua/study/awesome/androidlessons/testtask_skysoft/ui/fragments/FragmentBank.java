package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.study.awesome.androidlessons.testtask_skysoft.presenters.BankPresenter;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankList;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.BankAdapter;

public class FragmentBank extends Fragment {

    private BankPresenter presenter;

    private Unbinder unbinder;
    private String title;

    @Nullable @BindView(R.id.recycler_banks)
    RecyclerView recyclerBanks;

    public static FragmentBank newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", title);

        FragmentBank fragmentBank = new FragmentBank();
        fragmentBank.setArguments(bundle);

        return fragmentBank;
    }

    private void readBundle(Bundle bundle){
        if(bundle != null){
            title = bundle.getString("TITLE");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bank,container, false);

        unbinder = ButterKnife.bind(this, v);

        init();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(String.format("%s", title));

        return v;
    }

    public void onBanksLoaded(BankList bankList){
        BankAdapter adapter = new BankAdapter(getContext());
        adapter.setBanks(bankList.getBankList());
        recyclerBanks.setAdapter(adapter);
    }

    public void init(){

        presenter = new BankPresenter();
        presenter.attachView(this);

        presenter.loadBank();

        recyclerBanks.setLayoutManager(new LinearLayoutManager(getContext()));

        readBundle(getArguments());
    }

}