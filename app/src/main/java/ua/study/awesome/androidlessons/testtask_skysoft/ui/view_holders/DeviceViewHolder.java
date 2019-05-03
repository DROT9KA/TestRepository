package ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;

public class DeviceViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_id)
    TextView id;

    @BindView(R.id.tv_name)
    public TextView name;

    @BindView(R.id.tv_description)
    TextView description;

    private ClickListener clickListener;

    public DeviceViewHolder(View itemView, ClickListener clickListener){
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListener = clickListener;
    }

    public void onBindDevice(DeviceEntity deviceEntity){
        id.setText("Id: " + deviceEntity.getId());
        name.setText("Name: "+ deviceEntity.getName());
        description.setText("Description: " + deviceEntity.getDescription());
    }

    @OnClick(R.id.device_item)
    void onDeviceItem() {
        clickListener.onItemClick(getAdapterPosition());
    }
}