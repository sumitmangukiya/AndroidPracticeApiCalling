package com.cysm.androidpractice.tvshow.tadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cysm.androidpractice.R;
import com.cysm.androidpractice.tvshow.tmodel.TvShowModel;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    Context context;
    ArrayList<TvShowModel> tvShowModels;

    public TvShowAdapter(Context context, ArrayList<TvShowModel> tvShowModels) {
        this.context = context;
        this.tvShowModels = tvShowModels;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TvShowViewHolder(LayoutInflater.from(context).inflate(R.layout.list_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        TvShowModel tvShowModel = tvShowModels.get(position);
        Glide.with(context).load(tvShowModel.show.image.original).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                holder.progress_bar.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.progress_bar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.image);
        holder.name.setText(tvShowModel.show.name);
        String[] daysArray = tvShowModel.show.schedule.days;
        String daysString = TextUtils.join(", ", daysArray);
        holder.day.setText(daysString);
    }

    @Override
    public int getItemCount() {
        return tvShowModels.size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {
        TextView name, day;
        ImageView image;
        ProgressBar progress_bar;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            day = itemView.findViewById(R.id.day);
            image = itemView.findViewById(R.id.image);
            progress_bar = itemView.findViewById(R.id.progress_bar);


        }
    }
}
