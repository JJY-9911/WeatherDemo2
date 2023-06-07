package com.example.menu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.item.DailyItem;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<DailyItem> dailyList;

    public DailyAdapter(Context context, List<DailyItem> dailyList) {
        this.context = context;
        this.dailyList = dailyList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.daliy_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.date.setText(dailyList.get(position).getDate());
        viewHolder.tempMax.setText(dailyList.get(position).getTempMax());
        viewHolder.tempMin.setText(dailyList.get(position).getTempMin());

    }

    @Override
    public int getItemCount() {
        return dailyList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView tempMax;
        TextView tempMin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.daily_date);
            tempMax = itemView.findViewById(R.id.daily_max);
            tempMin = itemView.findViewById(R.id.daily_min);
        }
    }
}
