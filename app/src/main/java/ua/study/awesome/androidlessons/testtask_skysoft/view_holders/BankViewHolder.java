package ua.study.awesome.androidlessons.testtask_skysoft.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.models.Bank;

public class BankViewHolder extends RecyclerView.ViewHolder {

    private TextView type;
    private TextView fullAddressUa;
    private TextView placeUa;
    private TextView latitude;
    private TextView longitude;
    private TextView timeWork;

    public BankViewHolder (View itemView){
        super(itemView);

        timeWork = itemView.findViewById(R.id.tv_time_work);
        longitude = itemView.findViewById(R.id.tv_longtitude);
        latitude = itemView.findViewById(R.id.tv_latitude);
        placeUa = itemView.findViewById(R.id.tv_place_ua);
        type = itemView.findViewById(R.id.tv_type);
        fullAddressUa = itemView.findViewById(R.id.tv_address);
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
