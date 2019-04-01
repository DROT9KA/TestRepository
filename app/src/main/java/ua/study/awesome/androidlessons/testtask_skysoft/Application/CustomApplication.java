package ua.study.awesome.androidlessons.testtask_skysoft.Application;

import android.app.Application;

import io.realm.Realm;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
