package com.example.menu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.item.SearchListItem;

import java.util.ArrayList;
import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SearchListItem> searchListItems = new ArrayList<>();

    public SearchListAdapter(Context context, List<SearchListItem> searchListItems) {
        this.context = context;
        this.searchListItems = searchListItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.search_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder)holder;
        itemViewHolder.searchListText.setText(searchListItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return searchListItems.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView searchListText;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.searchListText = itemView.findViewById(R.id.search_city_text);
        }
    }
}
