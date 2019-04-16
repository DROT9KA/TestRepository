package ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders.DeviceViewHolder;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> {

    private ArrayList<Device> devices;

    private Context context;

    public DeviceAdapter(Context context) {
        this.context = context;
        devices = new ArrayList<>();
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
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public void removeDevices(){
        this.devices.clear();

    }

    public void filterList(ArrayList<Device> filteredList){
        devices = filteredList;
        notifyDataSetChanged();
    }
}