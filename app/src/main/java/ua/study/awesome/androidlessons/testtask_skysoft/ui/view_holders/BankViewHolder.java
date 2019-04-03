package ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.Bank;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.BankAdapter;

public class BankViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    BankAdapter bankAdapter = new BankAdapter(context);

//    @BindView(R.id.tv_time_work)
//    TextView timeWork;
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

    @Override
    public void onClick(View v) {
//        bankAdapter.getClickListener().onItemClick(getAdapterPosition(), v);
        clickListener.onItemClick(getAdapterPosition(), v);
    }

    public void onBindBank(Bank bank){
        latitude.setText("Широта - " + bank.getLatitude());
        longitude.setText("Довгота - " + bank.getLongitude());
        placeUa.setText(bank.getPlaceUa());
        type.setText(bank.getType());
        fullAddressUa.setText(bank.getFullAddressUa());
    }
//    timeWork.setText("Робочий час :"+ "\n"
//            + "Понеділок: " + bank.getTw().getMon() + "\n"
//            + "Вівторок: " + bank.getTw().getTue() + "\n"
//            + "Середа: " + bank.getTw().getWed() + "\n"
//            + "Четвер: " + bank.getTw().getThu() + "\n"
//            + "П'ятниця: " + bank.getTw().getFri() + "\n"
//            + "Субота: " + bank.getTw().getSat()  + "\n"
//            + "Неділя: " + bank.getTw().getSun()  + "\n"
//            + "Свята: " + bank.getTw().getHol());
}