package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
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
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.BankView;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.data.presenters.BankPresenterImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.BankAdapter;

public class BankFragmentImpl extends BaseFragment implements BankView {

    public static final String FRAGMENT_TAG = BankFragmentImpl.class.getSimpleName();

    private BankPresenterImpl presenter;

    private String title;

    private BankAdapter adapter;

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_banks)
    RecyclerView recyclerBanks;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private static final String ARG_TITLE = "TITLE";

    public static BankFragmentImpl newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        BankFragmentImpl bankFragmentImpl = new BankFragmentImpl();
        bankFragmentImpl.setArguments(bundle);

        return bankFragmentImpl;
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

        setHasOptionsMenu(true);

        Realm mRealm = Realm.getDefaultInstance();
        final RealmResults<RealmBankModelEntity> result = mRealm.where(RealmBankModelEntity.class).findAll();

        adapter = new BankAdapter(getContext());
        adapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position) {
                showDetailFrag(position);
            }
        });

        init();
        presenter.loadBank();

    }

    @Override
    public int provideView() {
        return R.layout.fragment_bank;
    }

    @Override
    public Object butterKnifeBind() {
        return this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            ((MainActivity) Objects.requireNonNull(getActivity())).drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void init() {
        presenter = new BankPresenterImpl();
        presenter.attachView(this);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadBank();
            }
        });

        recyclerBanks.setLayoutManager(new LinearLayoutManager(getContext()));

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));
    }

    @Override
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

    @Override
    public void showDetailFrag(int number) {
        ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(DetailBankFragment
                .newInstance(number), DetailBankFragment.FRAGMENT_TAG,  R.id.fragm_container);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showToast() {
        Toast.makeText(getContext(), "Loading error", Toast.LENGTH_LONG).show();
    }
}