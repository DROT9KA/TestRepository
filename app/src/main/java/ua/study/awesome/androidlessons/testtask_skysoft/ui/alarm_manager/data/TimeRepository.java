package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data;

public interface TimeRepository {

    void onAddTime(TimeEntity timeEntity);

    void onRemoveTime();

    void getTime();

}