package ua.study.awesome.androidlessons.testtask_skysoft.comparators;

import java.util.Comparator;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;

public class DeviceIdComparator implements Comparator<Device> {
    @Override
    public int compare(Device device1, Device device2) {
        Integer id1 = new Integer(device1.getId());
        Integer id2 = new Integer(device2.getId());
        return id1.compareTo(id2);
    }
}
