package ua.study.awesome.androidlessons.testtask_skysoft.comparators;

import java.util.Comparator;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;

public class DeviceNameComparator implements Comparator<Device> {
    @Override
    public int compare(Device device1, Device device2) {
        return device1.getName().compareTo(device2.getName());
    }
}