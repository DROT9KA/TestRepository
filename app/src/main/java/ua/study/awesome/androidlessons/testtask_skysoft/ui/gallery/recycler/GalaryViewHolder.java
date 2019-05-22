package ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;

public class GalaryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image_view)
    public ImageView imageView;

    public GalaryViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}