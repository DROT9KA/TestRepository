package ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter;

import android.widget.Filter;

import java.util.ArrayList;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;

public class DeviceFilter extends Filter {

    private ArrayList<Device> originalDevices;
    private ArrayList<Device> filterableDevices;
    private String spannableStr = "";
    private DeviceAdapter adapter;

    public DeviceFilter(DeviceAdapter adapter, ArrayList<Device> data) {
        this.adapter = adapter;
        this.originalDevices = new ArrayList<>(data);
        this.filterableDevices = new ArrayList<>(data);
    }

    public ArrayList<Device> getOriginalDevices() {
        return originalDevices;
    }

    public void setOriginalDevices(ArrayList<Device> originalDevices) {
        this.originalDevices = originalDevices;
    }

    public ArrayList<Device> getFilterableDevices() {
        return filterableDevices;
    }

    public void setFilterableDevices(ArrayList<Device> filterableDevices) {
        this.filterableDevices = filterableDevices;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        this.spannableStr = constraint.toString();

        String filterString = constraint.toString().toLowerCase();

        FilterResults results = new FilterResults();

        final ArrayList<Device> devices = new ArrayList<>();

        for(Device device: originalDevices){
            if (device.getName().toLowerCase().contains(filterString)){
                devices.add(device);
            }
        }

        results.values = devices;
        results.count = devices.size();

        return results;
    }

    public String getSpannableStr() {
        return spannableStr;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        setFilterableDevices((ArrayList<Device>) results.values);
        adapter.setDevices(filterableDevices);
    }

}