package com.anningtex.searchtest.searche;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.anningtex.searchtest.R;

import java.util.ArrayList;

/**
 * @author Song
 */
public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> historys;

    public SearchHistoryAdapter(Context context, ArrayList<String> historys) {
        this.context = context;
        this.historys = historys;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_history, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.historyInfo.setText(historys.get(position));

        holder.historyInfo.setOnClickListener(view -> iOnItemClickListener.onItemClick(historys.get(position)));

        holder.delete.setOnClickListener(view -> iOnItemClickListener.onItemDeleteClick(historys.get(position)));
    }

    @Override
    public int getItemCount() {
        return historys.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView historyInfo;
        ImageView delete;

        public MyViewHolder(View view) {
            super(view);
            historyInfo = view.findViewById(R.id.tv_item_search_history);
            delete = view.findViewById(R.id.iv_item_search_delete);
        }
    }

    private IOnItemClickListener iOnItemClickListener;

    public void setOnItemClickListener(IOnItemClickListener iOnItemClickListener) {
        this.iOnItemClickListener = iOnItemClickListener;
    }
}
