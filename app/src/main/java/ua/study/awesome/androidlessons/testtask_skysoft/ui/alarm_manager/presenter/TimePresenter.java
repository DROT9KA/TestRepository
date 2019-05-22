package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.presenter;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.AlarmManagerFragment;

public interface TimePresenter {

    void atachView(AlarmManagerFragment alarmManagerFragment);

    void onTimeLoaded(int hourOfDay, int minute);

}