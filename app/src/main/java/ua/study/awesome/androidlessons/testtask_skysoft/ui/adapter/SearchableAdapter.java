package ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;

public class SearchableAdapter extends DeviceAdapter implements Filterable {

    private ArrayList<Device> originalDevices;
    private ItemFilter filter = new ItemFilter();


    public SearchableAdapter(Context context, ArrayList<Device> data) {
        super(context);
        this.originalDevices = new ArrayList<>(data);
        setDevices(data);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private class ItemFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final ArrayList<Device> devices = new ArrayList<>();

            Device filterableDevice;

            for(Device device: originalDevices){
                filterableDevice = new Device(device);
                if (filterableDevice.getName().toLowerCase().contains(filterString)){
                    devices.add(filterableDevice);
                }
            }

            results.values = devices;
            results.count = devices.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            setDevices((ArrayList<Device>) results.values);
            notifyDataSetChanged();
        }
    }
}