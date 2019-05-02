package ua.study.awesome.androidlessons.testtask_skysoft.data.comparators;

import java.util.Comparator;

import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;

public class DeviceIdComparator implements Comparator<DeviceEntity> {
    @Override
    public int compare(DeviceEntity deviceEntity1, DeviceEntity deviceEntity2) {
        Integer id1 = new Integer(deviceEntity1.getId());
        Integer id2 = new Integer(deviceEntity2.getId());
        return id1.compareTo(id2);
    }
}
