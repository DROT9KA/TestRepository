package ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;

public class SecondDeviceFilter extends Filter {

    private String charString = "";

    private DeviceAdapter adapter;

    public SecondDeviceFilter(DeviceAdapter adapter) {
        this.adapter = adapter;
    }

    public String getCharString() {
        return charString;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        charString = constraint.toString();

        List<DeviceEntity> devicesFiltered;
        if(charString.isEmpty()){
            devicesFiltered = adapter.getDevices();
        } else {

            List<DeviceEntity> filterList = new ArrayList<>();

            for (DeviceEntity device: adapter.getDevices()){
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
        adapter.setDevicesFiltered((List<DeviceEntity>) results.values);
    }
}