package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data.TimeEntity;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmViewHolder> {

    List<TimeEntity> time;

    private Context context;

    private ClickListener clickListener;

    public AlarmAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_alarm, viewGroup, false);
        return new AlarmViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder alarmViewHolder, int i) {
        TimeEntity oneTime = time.get(i);
        alarmViewHolder.onBindItem(oneTime);

    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return time.size();
    }

    public List<TimeEntity> getTime() {
        return time;
    }

    public void setTime(List<TimeEntity> time) {
        this.time = time;
    }
}
