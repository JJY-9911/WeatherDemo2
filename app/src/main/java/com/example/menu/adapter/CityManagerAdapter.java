package com.example.menu.adapter;

import android.content.Context;
import android.hardware.lights.LightsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.item.CityManagerItem;

import java.util.List;


public class CityManagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    List<CityManagerItem> cityManagerData;

    public CityManagerAdapter(Context context, List<CityManagerItem> cityManagerData) {
        this.context = context;
        this.cityManagerData = cityManagerData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.city_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.cityName.setText(cityManagerData.get(position).getCityName());
    }

    @Override
    public int getItemCount() {
        return cityManagerData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cityName = itemView.findViewById(R.id.city_name);
        }
    }

}
