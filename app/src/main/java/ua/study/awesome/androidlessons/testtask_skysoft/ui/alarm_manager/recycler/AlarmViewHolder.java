package ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.data.TimeEntity;

public class AlarmViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image_clear_item)
    public ImageView imageView;

    @BindView(R.id.tv_time_item)
    TextView textView;

    private ClickListener clickListener;

    public AlarmViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        ButterKnife.bind(this, itemView);
    }

    public void onBindItem(TimeEntity timeEntity){
        textView.setText(timeEntity.getHour() + ":" + timeEntity.getMinute());
        imageView.setImageAlpha(R.drawable.ic_clear_black_24dp);
    }

    @OnClick(R.id.time_item)
    void onClickItem(){
        clickListener.onItemClick(getAdapterPosition());
    }
}