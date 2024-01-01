package com.cysm.androidpractice.task.tadapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cysm.androidpractice.R;
import com.cysm.androidpractice.task.tmodel.Data;

import java.util.ArrayList;
import java.util.List;

public class YourAdapter extends RecyclerView.Adapter<YourAdapter.ViewHolder> {

    private List<Data> dataList;
    public static final String TAG = "YourAdapter";

    public YourAdapter() {
        this.dataList = new ArrayList<>();
    }

    public void setData(List<Data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.txtName.setText(data.name);
        Glide.with(holder.itemView).load(data.airline.get(0).logo).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        ImageView logo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            logo = itemView.findViewById(R.id.logo);
        }
    }
}
