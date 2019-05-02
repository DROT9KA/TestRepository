package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.RealmBankModelEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankListResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.data.presenters.BankPresenter;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.BankAdapter;

public class BankFragment extends Fragment {

    private BankPresenter presenter;

    private String title;

    private BankAdapter adapter;

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_banks)
    RecyclerView recyclerBanks;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public static BankFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", title);

        BankFragment bankFragment = new BankFragment();
        bankFragment.setArguments(bundle);

        return bankFragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            title = bundle.getString("TITLE");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bank, container, false);
        Unbinder unbinder = ButterKnife.bind(this, v);

        setHasOptionsMenu(true);

        Realm mRealm = Realm.getDefaultInstance();
        final RealmResults<RealmBankModelEntity> result = mRealm.where(RealmBankModelEntity.class).findAll();

        adapter = new BankAdapter(getContext());
        adapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                showDetailFrag(position);
            }
        });

        init();
        presenter.loadBank();

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((MainActivity) Objects.requireNonNull(getActivity())).drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void init() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadBank();
            }
        });

        presenter = new BankPresenter();
        presenter.attachView(this);

        recyclerBanks.setLayoutManager(new LinearLayoutManager(getContext()));

        readBundle(getArguments());

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);
        //    R.drawable.point_vert_white_24dp

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));
    }

    public void onBanksLoaded(BankListResponse bankListResponse) {
        adapter.setBankResponses(bankListResponse.getBankResponseList());
        recyclerBanks.setAdapter(adapter);
        refreshLayout.setRefreshing(false);

        /*random background colors*/
//        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
//        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
//
//        recyclerBanks.setBackgroundColor(randomAndroidColor);
        /*random background colors*/
    }

    void showDetailFrag(int number) {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragm_container, DetailBankFragment.newInstance(number))
                .addToBackStack(null)
                .commit();
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void showToast() {
        Toast.makeText(getContext(), "Loading error", Toast.LENGTH_LONG).show();
    }
}