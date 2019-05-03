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
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.view_holders.DeviceViewHolder;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> implements Filterable {

    private String charString ="";

    private ArrayList<DeviceEntity> devices;
    private ArrayList<DeviceEntity> devicesFiltered;

    private ClickListener clickListener;

    public ArrayList<DeviceEntity> getDevicesFiltered() {
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

        SpannableString spannableString = new SpannableString(device.getName());

        int start = device.getName().toLowerCase().indexOf(charString);
        int end = start + charString.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        deviceViewHolder.onBindDevice(device);

        deviceViewHolder.name.setText(spannableString);
    }

    @Override
    public int getItemCount() {
        return devicesFiltered.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public ArrayList<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDeviceEntities(ArrayList<DeviceEntity> devices) {
        this.devices = devices;
        this.devicesFiltered = devices;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                charString = constraint.toString();

                if(charString.isEmpty()){
                    devicesFiltered = devices;
                } else {

                    ArrayList<DeviceEntity> filterList = new ArrayList<>();

                    for (DeviceEntity device: devices){
                        if(device.getName().toLowerCase().contains(charString.toLowerCase())){
                            filterList.add(device);
                        }
                    }
                    devicesFiltered = filterList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = devicesFiltered;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }
}