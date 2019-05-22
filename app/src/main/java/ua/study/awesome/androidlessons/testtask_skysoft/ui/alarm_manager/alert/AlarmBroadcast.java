package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.alert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.AlarmManagerFragment;

public class AlarmBroadcast extends BroadcastReceiver {

    AlarmManagerFragment view = new AlarmManagerFragment();

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
        Toast.makeText(context, "weqeqweqeqw", Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(10000);
    }
}