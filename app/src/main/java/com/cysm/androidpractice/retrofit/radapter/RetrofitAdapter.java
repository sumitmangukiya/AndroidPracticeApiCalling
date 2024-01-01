package com.cysm.androidpractice.retrofit.radapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cysm.androidpractice.R;
import com.cysm.androidpractice.retrofit.rmodel.RetrofitModel;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.RetrofitViewHolder> {
    List<RetrofitModel> retrofitModels;
    Context context;

    public RetrofitAdapter(List<RetrofitModel> retrofitModels, Context context) {
        this.retrofitModels = retrofitModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RetrofitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RetrofitViewHolder(LayoutInflater.from(context).inflate(R.layout.list_retrofit_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RetrofitViewHolder holder, int position) {
        Picasso.get().load(retrofitModels.get(position).thumbnailUrl).into(holder.image_one);
        Picasso.get().load(retrofitModels.get(position).url).into(holder.image_two);
    }

    @Override
    public int getItemCount() {
        return retrofitModels.size();
    }

    public class RetrofitViewHolder extends RecyclerView.ViewHolder {
        ImageView image_two, image_one;

        public RetrofitViewHolder(@NonNull View itemView) {
            super(itemView);
            image_one = itemView.findViewById(R.id.image_one);
            image_two = itemView.findViewById(R.id.image_two);
        }
    }
}
