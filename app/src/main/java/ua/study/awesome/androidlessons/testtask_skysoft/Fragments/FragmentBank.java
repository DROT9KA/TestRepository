package ua.study.awesome.androidlessons.testtask_skysoft.Fragments;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.adapter.BankAdapter;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.PrivatBankAPI;
import ua.study.awesome.androidlessons.testtask_skysoft.models.BankList;
import ua.study.awesome.androidlessons.testtask_skysoft.retrofit.MainRetrofit;

public class FragmentBank extends Fragment {

    private Unbinder unbinder;

    @Nullable @BindView(R.id.recycler_banks)
    RecyclerView recyclerBanks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bank,container, false);

        unbinder = ButterKnife.bind(this, v);
        recyclerBanks.setLayoutManager(new LinearLayoutManager(getContext()));

        PrivatBankAPI privatBankAPI = MainRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);

        Call<BankList> call = privatBankAPI.getBanks();
        call.enqueue(new Callback<BankList>() {
            @Override
            public void onResponse(Call<BankList> call, Response<BankList> response) {
                BankList bankList = response.body();
                BankAdapter adapter = new BankAdapter(getContext());
                adapter.setBanks(bankList.getBankList());
                recyclerBanks.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BankList> call, Throwable t) {
                String str = new String();
            }
        });

        return v;
    }
}
