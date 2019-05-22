package ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalaryViewHolder> {

    private List<String> images;

    private Context context;

    public GalleryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GalaryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_image, viewGroup, false);
        return new GalaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalaryViewHolder galaryViewHolder, int i) {
        String singleImage = images.get(i);

        if (singleImage != null){
            Glide.with(context).load(singleImage).into(galaryViewHolder.imageView);
        } else {
            Toast.makeText(context, "Images Empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}