package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.presenter;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.AlarmManagerFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data.TimeEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data.TimeRepository;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data.TimeRepositoryImpl;

public class TimePresenterImpl implements TimePresenter {

    AlarmManagerFragment view;

    TimeRepository model = new TimeRepositoryImpl();

    @Override
    public void atachView(AlarmManagerFragment alarmManagerFragment) {
        this.view = alarmManagerFragment;
    }

    @Override
    public void onTimeLoaded(int hourOfDay, int minute) {
        TimeEntity timeEntity = new TimeEntity();
        timeEntity.setHour(String.valueOf(hourOfDay));
        timeEntity.setMinute(String.valueOf(minute));
        view.showTime(timeEntity);
        model.onAddTime(timeEntity);
    }
}