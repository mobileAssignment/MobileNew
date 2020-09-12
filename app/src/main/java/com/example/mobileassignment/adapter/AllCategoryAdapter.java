package com.example.mobileassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileassignment.AllCategory;
import com.example.mobileassignment.R;
import com.example.mobileassignment.model.AllCategory_model;
import com.example.mobileassignment.model.Category;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {

    Context context;
    List<AllCategory_model> categoryList;

    public AllCategoryAdapter(Context context, List<AllCategory_model> categoryList) {
        this.context = context;
        this.categoryList= categoryList;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category,parent,false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.categoryImage.setImageResource(categoryList.get(position).getImageurl());


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class AllCategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView categoryImage;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage=itemView.findViewById(R.id.categoryImage);
        }
    }
}
