package ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.data;

import java.util.Comparator;

public class DeviceDescriptionComparator implements Comparator<DeviceEntity> {
    @Override
    public int compare(DeviceEntity deviceEntity1, DeviceEntity deviceEntity2) {
        return deviceEntity1.getDescription().compareTo(deviceEntity2.getDescription());
    }
}