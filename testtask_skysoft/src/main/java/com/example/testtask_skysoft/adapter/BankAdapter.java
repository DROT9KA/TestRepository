package com.example.testtask_skysoft.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testtask_skysoft.models.Bank;
import com.example.testtask_skysoft.R;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>{

    private ArrayList<Bank> banks = new ArrayList<>();

    public BankAdapter(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_bank, viewGroup, false);
        return new BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder bankViewHolder, int i) {
        Bank bank = banks.get(i);

        bankViewHolder.timeWork.setText("Робочий час :"+ "\n"
                + "Понеділок: " + bank.getTw().getMon() + "\n"
                + "Вівторок: " + bank.getTw().getTue() + "\n"
                + "Середа: " + bank.getTw().getWed() + "\n"
                + "Четвер: " + bank.getTw().getThu() + "\n"
                + "П'ятниця: " + bank.getTw().getFri() + "\n"
                + "Субота: " + bank.getTw().getSat()  + "\n"
                + "Неділя: " + bank.getTw().getSun()  + "\n"
                + "Свята: " + bank.getTw().getHol());
        bankViewHolder.latitude.setText("Широта - " + bank.getLatitude());
        bankViewHolder.longitude.setText("Довгота - " + bank.getLongitude());
        bankViewHolder.placeUa.setText(bank.getPlaceUa());
        bankViewHolder.type.setText(bank.getType());
        bankViewHolder.fullAddressUa.setText(bank.getFullAddressUa());
    }

    @Override
    public int getItemCount() {
        return banks.size();
    }

    class BankViewHolder extends RecyclerView.ViewHolder {

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
    }
}
