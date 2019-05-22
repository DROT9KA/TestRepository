package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass(name = "Time")
public class TimeEntity extends RealmObject {

    @PrimaryKey
    private String hour;
    private String minute;

    public TimeEntity() {

    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}