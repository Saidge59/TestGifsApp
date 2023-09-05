package com.example.testgifsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testgifsapp.R;
import com.example.testgifsapp.domain.UrlImg;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context ctx;
    List<UrlImg> modelList;

    private OnItemClickListener onItemClickListener;

    public DataAdapter(Context ctx, List<UrlImg> modelList) {
        this.ctx = ctx;
        this.modelList = modelList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UrlImg data = modelList.get(position);
        Glide.with(ctx).load(data.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivGif);
            imageView.setOnClickListener(view -> onItemClickListener.onItemClick(getAdapterPosition()));
        }
    }
}
