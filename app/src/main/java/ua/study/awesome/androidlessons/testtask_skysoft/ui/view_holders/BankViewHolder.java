package ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.Bank;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;

public class BankViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_longtitude)
    TextView longitude;
    @BindView(R.id.tv_latitude)
    TextView latitude;
    @BindView(R.id.tv_place_ua)
    TextView placeUa;
    @BindView(R.id.tv_type)
    TextView type;
    @BindView(R.id.tv_address)
    TextView fullAddressUa;

    private ClickListener clickListener;

    public BankViewHolder (View itemView, ClickListener clickListener){
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
    }

    public void onBindBank(Bank bank){
        latitude.setText("Широта - " + bank.getLatitude());
        longitude.setText("Довгота - " + bank.getLongitude());
        placeUa.setText(bank.getPlaceUa());
        type.setText(bank.getType());
        fullAddressUa.setText(bank.getFullAddressUa());
    }

    @Override
    public void onClick(View v) {
        clickListener.onItemClick(getAdapterPosition(), v);
    }

}