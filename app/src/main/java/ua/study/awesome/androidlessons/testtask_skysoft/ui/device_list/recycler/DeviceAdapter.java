package ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.data.DeviceEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.SpannableUtils;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> implements Filterable {

    private List<DeviceEntity> devices;
    private List<DeviceEntity> devicesFiltered;

    private ClickListener clickListener;

    private DeviceFilter filter = new DeviceFilter(this);

    public List<DeviceEntity> getDevicesFiltered() {
        return devicesFiltered;
    }

    private Context context;

    public DeviceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_device, viewGroup, false);
        return new DeviceViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder deviceViewHolder, int i) {
        DeviceEntity device = devicesFiltered.get(i);
        deviceViewHolder.onBindDevice(device);
        SpannableString span = SpannableUtils.createSpan(device.getName(), filter.getCharString());
        deviceViewHolder.name.setText(span);
    }

    @Override
    public int getItemCount() {
        return devicesFiltered.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public List<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDeviceEntities(List<DeviceEntity> devices) {
        this.devices = devices;
        this.devicesFiltered = devices;
        notifyDataSetChanged();
    }

    public void setDevicesFiltered(List<DeviceEntity> devicesFiltered) {
        this.devicesFiltered = devicesFiltered;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return this.filter;
    }

}