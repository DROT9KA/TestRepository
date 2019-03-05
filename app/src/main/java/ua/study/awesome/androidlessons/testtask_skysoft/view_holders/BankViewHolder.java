package ua.study.awesome.androidlessons.testtask_skysoft.view_holders;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.models.Bank;

public class BankViewHolder extends RecyclerView.ViewHolder {

    @Nullable @BindView(R.id.tv_time_work)
    TextView timeWork;
    @Nullable @BindView(R.id.tv_longtitude)
    TextView longitude;
    @Nullable @BindView(R.id.tv_latitude)
    TextView latitude;
    @Nullable @BindView(R.id.tv_place_ua)
    TextView placeUa;
    @Nullable @BindView(R.id.tv_type)
    TextView type;
    @Nullable @BindView(R.id.tv_address)
    TextView fullAddressUa;

    public BankViewHolder (View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBindBank(Bank bank){
        timeWork.setText("Робочий час :"+ "\n"
                + "Понеділок: " + bank.getTw().getMon() + "\n"
                + "Вівторок: " + bank.getTw().getTue() + "\n"
                + "Середа: " + bank.getTw().getWed() + "\n"
                + "Четвер: " + bank.getTw().getThu() + "\n"
                + "П'ятниця: " + bank.getTw().getFri() + "\n"
                + "Субота: " + bank.getTw().getSat()  + "\n"
                + "Неділя: " + bank.getTw().getSun()  + "\n"
                + "Свята: " + bank.getTw().getHol());
        latitude.setText("Широта - " + bank.getLatitude());
        longitude.setText("Довгота - " + bank.getLongitude());
        placeUa.setText(bank.getPlaceUa());
        type.setText(bank.getType());
        fullAddressUa.setText(bank.getFullAddressUa());
    }
}