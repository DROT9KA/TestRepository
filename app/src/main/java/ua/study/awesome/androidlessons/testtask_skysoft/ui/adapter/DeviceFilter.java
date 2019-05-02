package ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter;

import android.widget.Filter;

import java.util.ArrayList;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;

public class DeviceFilter extends Filter {

    private ArrayList<DeviceEntity> originalDeviceEntities;
    private ArrayList<DeviceEntity> filterableDeviceEntities;
    private String spannableStr = "";
    private DeviceAdapter adapter;

    public DeviceFilter(DeviceAdapter adapter, ArrayList<DeviceEntity> data) {
        this.adapter = adapter;
        this.originalDeviceEntities = new ArrayList<>(data);
        this.filterableDeviceEntities = new ArrayList<>(data);
    }

    public ArrayList<DeviceEntity> getOriginalDeviceEntities() {
        return originalDeviceEntities;
    }

    public void setOriginalDeviceEntities(ArrayList<DeviceEntity> originalDeviceEntities) {
        this.originalDeviceEntities = originalDeviceEntities;
    }

    public ArrayList<DeviceEntity> getFilterableDeviceEntities() {
        return filterableDeviceEntities;
    }

    public void setFilterableDeviceEntities(ArrayList<DeviceEntity> filterableDeviceEntities) {
        this.filterableDeviceEntities = filterableDeviceEntities;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        this.spannableStr = constraint.toString();

        String filterString = constraint.toString().toLowerCase();

        FilterResults results = new FilterResults();

        final ArrayList<DeviceEntity> deviceEntities = new ArrayList<>();

        for(DeviceEntity deviceEntity : originalDeviceEntities){
            if (deviceEntity.getName().toLowerCase().contains(filterString)){
                deviceEntities.add(deviceEntity);
            }
        }

        results.values = deviceEntities;
        results.count = deviceEntities.size();

        return results;
    }

    public String getSpannableStr() {
        return spannableStr;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        setFilterableDeviceEntities((ArrayList<DeviceEntity>) results.values);
        adapter.setDeviceEntities(filterableDeviceEntities);
    }

}