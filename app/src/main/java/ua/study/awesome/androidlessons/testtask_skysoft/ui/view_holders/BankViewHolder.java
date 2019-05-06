package ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;

public class BankViewHolder extends RecyclerView.ViewHolder{

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
    }

    public void onBindBank(BankResponse bankResponse){
        latitude.setText("Широта - " + bankResponse.getLatitude());
        longitude.setText("Довгота - " + bankResponse.getLongitude());
        placeUa.setText(bankResponse.getPlaceUa());
        type.setText(bankResponse.getType());
        fullAddressUa.setText(bankResponse.getFullAddressUa());
    }

    @OnClick(R.id.bank_item)
    void onBankClick() {
        clickListener.onItemClick(getAdapterPosition());
    }

}