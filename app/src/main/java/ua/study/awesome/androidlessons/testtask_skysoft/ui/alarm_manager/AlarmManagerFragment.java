package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.alert.AlarmBroadcast;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data.TimeEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.presenter.TimePresenter;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.presenter.TimePresenterImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.recycler.AlarmAdapter;

public class AlarmManagerFragment extends BaseFragment implements TimeView {

    public static final String FRAGMENT_TAG = AlarmManagerFragment.class.getSimpleName();

    List<TimeEntity> time;

    @BindView(R.id.recycler_time_picker)
    RecyclerView recyclerView;

    @BindView(R.id.tv_current_time)
    public TextView tvCurrentTime;

    @BindView(R.id.time_container)
    FrameLayout frameLayoutTime;

    AlarmAdapter adapter;

    TimePresenter presenter;

    private static final String ARG_TITLE = "TITLE";

    private String title;

    public static AlarmManagerFragment getInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        AlarmManagerFragment alarmManagerFragment = new AlarmManagerFragment();
        alarmManagerFragment.setArguments(bundle);

        return alarmManagerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.alarm_manager_fragment;
    }

    private void init() {
        time = new ArrayList<>();

        presenter = new TimePresenterImpl();
        presenter.atachView(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new AlarmAdapter(getContext());
        adapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position) {
                time.remove(position);
                updateRecycler();
            }
        });

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(calendar.getTime());

        tvCurrentTime.setText(time);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));
    }

    private void alarm(int hourOfDay, int minute, int currentHour, int currentMinute) {
        final Calendar c = Calendar.getInstance();

        int currentTime = (currentHour * 3600000) + (currentMinute * 60000);
        int pickerTime = (hourOfDay * 3600000) + (minute * 60000);
        long beginningDay = System.currentTimeMillis() - currentTime;

        Intent intent = new Intent(getContext(), AlarmBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);

        AlarmManager am = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

        am.set(AlarmManager.RTC_WAKEUP, beginningDay + pickerTime, pendingIntent);
    }

    @OnClick(R.id.time_container)
    public void onClick() {
        final Calendar c = Calendar.getInstance();
        final int mHour = c.get(Calendar.HOUR_OF_DAY);
        final int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                        presenter.onTimeLoaded(hourOfDay, minute);
                        alarm(hourOfDay, minute, mHour, mMinute);
                        updateRecycler();
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

    private void updateRecycler() {
        adapter.setTime(time);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showTime(TimeEntity timeEntity) {
        time.add(timeEntity);
        updateRecycler();
    }
}