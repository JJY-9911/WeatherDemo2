package com.example.menu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.item.HourlyItem;

import org.w3c.dom.Text;

import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<HourlyItem> hourlyList;

    public HourlyAdapter(Context context, List<HourlyItem> hourlyList) {
        this.context = context;
        this.hourlyList = hourlyList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.hourly_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (position == 0) {
            viewHolder.hour.setText("现在");
        }else {
            viewHolder.hour.setText(hourlyList.get(position).hour);
        }
        viewHolder.temperature.setText(hourlyList.get(position).temp);

        if (hourlyList.get(position).text.contains("云")){
            viewHolder.icon.setBackgroundResource(R.drawable.cloudy);
        }
        if (hourlyList.get(position).text.contains("雨")){
            viewHolder.icon.setBackgroundResource(R.drawable.yu);
        }
        if (hourlyList.get(position).text.contains("晴")){
            viewHolder.icon.setBackgroundResource(R.drawable.sunny);
        }
    }

    @Override
    public int getItemCount() {
        return hourlyList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView hour;
        TextView icon;
        TextView temperature;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hour = itemView.findViewById(R.id.hour_item_hour);
            icon = itemView.findViewById(R.id.hour_item_icon);
            temperature = itemView.findViewById(R.id.hour_item_temp);
        }
    }
}
