package ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.recycler;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.data.DeviceEntity;

public class DeviceFilter extends Filter {

    private String charString = "";

    private DeviceAdapter adapter;

    public DeviceFilter(DeviceAdapter adapter) {
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