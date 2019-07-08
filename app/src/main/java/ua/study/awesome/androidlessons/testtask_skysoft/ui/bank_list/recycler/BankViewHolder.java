package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.BanksModel;

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

    public void onBindBank(BanksModel banksModel){
        latitude.setText("Широта - " + banksModel.getLatitude());
        longitude.setText("Довгота - " + banksModel.getLongitude());
        placeUa.setText(banksModel.getPlaceUa());
        type.setText(banksModel.getType());
        fullAddressUa.setText(banksModel.getFullAddressUa());
    }

    @OnClick(R.id.bank_item)
    void onBankClick() {
        clickListener.onItemClick(getAdapterPosition());
//        new BanksEntity(){
//        };
    }

}