package com.cysm.androidpractice.Https.hadapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cysm.androidpractice.Https.hmodel.Todos;
import com.cysm.androidpractice.R;

import java.util.ArrayList;

public class HAdapter extends RecyclerView.Adapter<HAdapter.MyViewHolder> {
    Context context;
    ArrayList<Todos> todosArrayList;

    public HAdapter(Context context, ArrayList<Todos> todosArrayList) {
        this.context = context;
        this.todosArrayList = todosArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_todos, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.todos_id.setText(String.valueOf(todosArrayList.get(position).id));
        holder.todos_title.setText(todosArrayList.get(position).title);
//        holder.todos_completed.setText(String.valueOf(todosArrayList.get(position).isCompleted()));

        if (todosArrayList.get(position).completed) {
            holder.todos_completed.setChecked(true);
            holder.todos_completed.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#FF0202")));
            holder.todos_completed.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#284E06")));
        } else {
            holder.todos_completed.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return todosArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView todos_id, todos_title;
        Switch todos_completed;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            todos_id = itemView.findViewById(R.id.todos_id);
            todos_title = itemView.findViewById(R.id.todos_title);
            todos_completed = itemView.findViewById(R.id.todos_completed);
        }
    }
}
