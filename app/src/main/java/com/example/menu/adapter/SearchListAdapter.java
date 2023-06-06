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

import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SearchListItem> searchListItems;
    /**城市搜索条目的监听，点击条目后获取城市id，请求天气数据*/
    private OnItemClickListener onItemClickListener = null;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }


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
        /**v就是被点击的view*/
        itemViewHolder.itemView.setOnClickListener(v->{
            if(onItemClickListener != null){
                onItemClickListener.onItemClick(position);
            }
        });
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
