package ua.study.awesome.clickbtnnewactivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class RoshanActivity extends AppCompatActivity {

    public Button stoptimer;
    public Button RoshanStart;
    public Chronometer Chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roshan_activity);

        RoshanStart = (findViewById(R.id.roshanstart));
        Chronometer = (findViewById(R.id.chronometer));
        stoptimer = (findViewById(R.id.stoptimer));

        RoshanStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chronometer.start();
            }
        });

        stoptimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chronometer.setBase(SystemClock.elapsedRealtime());
                Chronometer.stop();
            }
        });

    }
}
