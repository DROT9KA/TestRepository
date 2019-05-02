package ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders.DeviceViewHolder;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> implements Filterable {

    private ArrayList<DeviceEntity> deviceEntities;

    private Context context;

    private DeviceFilter deviceFilter;

    public DeviceAdapter(Context context) {
        this.context = context;
//        this.deviceEntities = new ArrayList<>(dev);
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_device, viewGroup, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder deviceViewHolder, int i) {
        DeviceEntity deviceEntity = deviceEntities.get(i);

        deviceViewHolder.onBindDevice(deviceEntity);

        TextView textView = deviceViewHolder.name;
        String letter = deviceFilter.getSpannableStr();
        String stName = deviceEntity.getName();

        SpannableString span = new SpannableString(stName);

        int start = stName.toLowerCase().indexOf(letter);
        int end = start + letter.length();

        span.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(span);
        deviceViewHolder.name.setText(span);

    }

    @Override
    public int getItemCount() {
        return deviceEntities.size();
    }

    public void setDeviceEntities(ArrayList<DeviceEntity> deviceEntities) {
        this.deviceEntities = new ArrayList<>(deviceEntities);
        deviceFilter = new DeviceFilter(this, deviceEntities);
        notifyDataSetChanged();
    }

    public void updateAdapter() {

    }

    public ArrayList<DeviceEntity> getDeviceEntities() {
        return deviceEntities;
    }

    public void removeDevices(){
        this.deviceEntities.clear();
        notifyDataSetChanged();
    }

    public void filterList(ArrayList<DeviceEntity> filteredList){
        deviceEntities = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return deviceFilter;
    }
}