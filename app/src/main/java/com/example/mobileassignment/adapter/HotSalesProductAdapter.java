package com.example.mobileassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileassignment.MainActivity;
import com.example.mobileassignment.R;
import com.example.mobileassignment.model.HotSalesProduct;

import java.util.List;

public class HotSalesProductAdapter extends RecyclerView.Adapter<HotSalesProductAdapter.HotSalesProductViewHolder> {

    Context context;
    List<HotSalesProduct> hotProductList;

    public HotSalesProductAdapter(Context context, List<HotSalesProduct> hotProductList) {
        this.context = context;
        this.hotProductList = hotProductList;
    }

    @NonNull
    @Override
    public HotSalesProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_sales_items,parent,false);
        return new HotSalesProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotSalesProductViewHolder holder, int position) {

        holder.hotSalesImageView.setImageResource(hotProductList.get(position).getImageurl());
    }

    @Override
    public int getItemCount() {
        return hotProductList.size();
    }

    public static class HotSalesProductViewHolder extends RecyclerView.ViewHolder{

        ImageView hotSalesImageView;

        public HotSalesProductViewHolder(@NonNull View itemView) {
            super(itemView);
            hotSalesImageView = itemView.findViewById(R.id.hotSalesImage);
        }
    }
}
