package ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.data;

import java.util.Comparator;

public class DeviceNameComparator implements Comparator<DeviceEntity> {
    @Override
    public int compare(DeviceEntity deviceEntity1, DeviceEntity deviceEntity2) {
        return deviceEntity1.getName().compareTo(deviceEntity2.getName());
    }
}