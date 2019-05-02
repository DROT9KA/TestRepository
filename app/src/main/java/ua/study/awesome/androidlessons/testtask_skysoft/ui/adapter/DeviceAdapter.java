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
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders.DeviceViewHolder;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> implements Filterable {

    private ArrayList<Device> devices;

    private Context context;

    private DeviceFilter deviceFilter;

    public DeviceAdapter(Context context) {
        this.context = context;
//        this.devices = new ArrayList<>(dev);
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_device, viewGroup, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder deviceViewHolder, int i) {
        Device device = devices.get(i);

        deviceViewHolder.onBindDevice(device);

        TextView textView = deviceViewHolder.name;
        String letter = deviceFilter.getSpannableStr();
        String stName = device.getName();

        SpannableString span = new SpannableString(stName);

        int start = stName.toLowerCase().indexOf(letter);
        int end = start + letter.length();

        span.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(span);
        deviceViewHolder.name.setText(span);

    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = new ArrayList<>(devices);
        deviceFilter = new DeviceFilter(this, devices);
        notifyDataSetChanged();
    }

    public void updateAdapter() {

    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void removeDevices(){
        this.devices.clear();
        notifyDataSetChanged();
    }

    public void filterList(ArrayList<Device> filteredList){
        devices = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return deviceFilter;
    }
}