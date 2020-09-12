package com.example.mobileassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mobileassignment.adapter.AllCategoryAdapter;
import com.example.mobileassignment.adapter.CategoryAdapter;
import com.example.mobileassignment.model.AllCategory_model;
import com.example.mobileassignment.model.Category;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {

    RecyclerView allCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategory_model> allCategoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        allCategoryRecycler =findViewById(R.id.all_category);

        // adding data to model
        allCategoryModelList=new ArrayList<>();
        allCategoryModelList.add(new AllCategory_model(1,R.drawable.shoeicon));
        allCategoryModelList.add(new AllCategory_model(2,R.drawable.shorticon2));
        allCategoryModelList.add(new AllCategory_model(3,R.drawable.shirticon));
        allCategoryModelList.add(new AllCategory_model(4,R.drawable.gymicon));
        allCategoryModelList.add(new AllCategory_model(5,R.drawable.bicycleicon));
        allCategoryModelList.add(new AllCategory_model(6,R.drawable.snowboardicon));
        allCategoryModelList.add(new AllCategory_model(7,R.drawable.ballicon));
        allCategoryModelList.add(new AllCategory_model(8,R.drawable.racketicon));
        allCategoryModelList.add(new AllCategory_model(9,R.drawable.bottleicon));

        setCategoryRecycler(allCategoryModelList);
    }

    private void setCategoryRecycler(List<AllCategory_model>allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }
}