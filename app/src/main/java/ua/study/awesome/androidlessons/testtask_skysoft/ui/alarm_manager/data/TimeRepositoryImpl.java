package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data;

import io.realm.Realm;

public class TimeRepositoryImpl implements TimeRepository {

    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void onAddTime(TimeEntity timeEntity) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(timeEntity);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void onRemoveTime() {

    }

    @Override
    public void getTime() {

    }
}