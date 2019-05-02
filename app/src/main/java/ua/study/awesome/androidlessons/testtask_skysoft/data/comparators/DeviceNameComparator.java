package ua.study.awesome.androidlessons.testtask_skysoft.data.comparators;

import java.util.Comparator;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;

public class DeviceNameComparator implements Comparator<DeviceEntity> {
    @Override
    public int compare(DeviceEntity deviceEntity1, DeviceEntity deviceEntity2) {
        return deviceEntity1.getName().compareTo(deviceEntity2.getName());
    }
}