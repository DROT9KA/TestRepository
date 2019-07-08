package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.BanksModel;

public class BankAdapter extends RecyclerView.Adapter<BankViewHolder> {

    private ClickListener clickListener;

    private List<BanksModel> banksModels;

    private Context context;

    public BankAdapter(Context context) {
        this.context = context;
        banksModels = new ArrayList<>();
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_bank, viewGroup, false);
        return new BankViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder bankViewHolder, int i) {
        BanksModel banksModel = banksModels.get(i);

        bankViewHolder.onBindBank(banksModel);
    }

    @Override
    public int getItemCount() {
        return banksModels.size();
    }

    public void setBanksModels(List<BanksModel> banksModels) {
        this.banksModels = banksModels;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}