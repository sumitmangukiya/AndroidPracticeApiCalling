package com.cysm.androidpractice.Gson.gadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cysm.androidpractice.Gson.gmodel.GFlags;
import com.cysm.androidpractice.R;

import java.util.ArrayList;

public class GFlagAdapter extends RecyclerView.Adapter<GFlagAdapter.FlagViewHolder> {
    Context context;
    ArrayList<GFlags> flags;

    public GFlagAdapter(Context context, ArrayList<GFlags> flags) {
        this.context = context;
        this.flags = flags;
    }

    @NonNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlagViewHolder(LayoutInflater.from(context).inflate(R.layout.list_flag_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlagViewHolder holder, int position) {
        GFlags flag = flags.get(position);
        Glide.with(context).load(flag.flag.png).centerCrop().into(holder.flag_image_view);
        holder.country_name.setText(flag.name.common);
    }

    @Override
    public int getItemCount() {
        return flags.size();
    }

    public class FlagViewHolder extends RecyclerView.ViewHolder {
        ImageView flag_image_view;
        TextView country_name;

        public FlagViewHolder(@NonNull View itemView) {
            super(itemView);
            flag_image_view = itemView.findViewById(R.id.flag_image_view);
            country_name = itemView.findViewById(R.id.country_name);
        }
    }
}
