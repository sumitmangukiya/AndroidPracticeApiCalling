package com.cysm.androidpractice.Gsonobject.gadapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cysm.androidpractice.Gsonobject.gmodel.Data;
import com.cysm.androidpractice.Gsonobject.gmodel.User;
import com.cysm.androidpractice.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.VolleyFlageViewHolder> {

    Context context;
    ArrayList<Data> volleyFlags;

    public UserAdapter(Context context, ArrayList<Data> volleyFlags) {
        this.context = context;
        this.volleyFlags = volleyFlags;
    }

    @NonNull
    @Override
    public UserAdapter.VolleyFlageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VolleyFlageViewHolder(LayoutInflater.from(context).inflate(R.layout.list_flag_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.VolleyFlageViewHolder holder, int position) {
        Glide.with(context).load(volleyFlags.get(position).avatar).into(holder.flagimage);
        holder.flagtitle.setText(volleyFlags.get(position).email);
    }

    @Override
    public int getItemCount() {
        return volleyFlags.size();
    }

    public class VolleyFlageViewHolder extends RecyclerView.ViewHolder {
        ImageView flagimage;
        TextView flagtitle;

        public VolleyFlageViewHolder(@NonNull View itemView) {
            super(itemView);
            flagimage = itemView.findViewById(R.id.flag_image_view);
            flagtitle = itemView.findViewById(R.id.country_name);
        }
    }
}