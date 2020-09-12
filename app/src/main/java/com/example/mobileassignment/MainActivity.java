package com.example.mobileassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mobileassignment.adapter.CategoryAdapter;
import com.example.mobileassignment.adapter.HotSalesProductAdapter;
import com.example.mobileassignment.model.Category;
import com.example.mobileassignment.model.HotSalesProduct;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button lbutton;
    private Button rbutton;

    private ImageView homeImage;
    private ImageView allprodImage;
    private ImageView purhisImage;
    private ImageView settImage;
    RecyclerView hotSalesRecycleView,categoryRecycleView;
    HotSalesProductAdapter hotSalesProductAdapter;
    List<HotSalesProduct> hotSalesProductList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    ImageView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryRecycleView =findViewById(R.id.categoryRecycler);
        allCategory =findViewById(R.id.allCategoryImage);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openCategory();
            }
            public void openCategory(){
                Intent intent = new Intent(MainActivity.this,AllCategory.class);
                startActivity(intent);
            }
        });

        //adding data to model
        hotSalesProductList=new ArrayList<>();
        hotSalesProductList.add(new HotSalesProduct(1,R.drawable.legging));
        hotSalesProductList.add(new HotSalesProduct(2,R.drawable.bottle));
        hotSalesProductList.add(new HotSalesProduct(3,R.drawable.dumbell));
        hotSalesProductList.add(new HotSalesProduct(4,R.drawable.shoes));
        hotSalesProductList.add(new HotSalesProduct(5,R.drawable.shirt));
        hotSalesProductList.add(new HotSalesProduct(6,R.drawable.shorts));

        //adding data to model
        categoryList=new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.shoeicon));
        categoryList.add(new Category(2,R.drawable.shorticon2));
        categoryList.add(new Category(3,R.drawable.shirticon));
        categoryList.add(new Category(4,R.drawable.gymicon));
        categoryList.add(new Category(5,R.drawable.bicycleicon));
        categoryList.add(new Category(6,R.drawable.snowboardicon));
        categoryList.add(new Category(7,R.drawable.ballicon));
        categoryList.add(new Category(8,R.drawable.racketicon));
        categoryList.add(new Category(9,R.drawable.bottleicon));
        setHotSalesRecycler(hotSalesProductList);
        setCategoryRecycler(categoryList);



        lbutton=findViewById(R.id.button2);
        lbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openLogin();
            }
            public void openLogin(){
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

        rbutton=findViewById(R.id.button4);
        rbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openRegister();
            }
            public void openRegister(){
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        homeImage=findViewById(R.id.homeImage);
        homeImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openHome();
            }
            public void openHome(){
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        allprodImage=findViewById(R.id.allProductImage);
        allprodImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openAllProd();
            }
            public void openAllProd(){
                Intent intent = new Intent(MainActivity.this,AllProduct.class);
                startActivity(intent);
            }
        });

        purhisImage=findViewById(R.id.purchaseHistoryImage);
        purhisImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openPurchase();
            }
            public void openPurchase(){
                Intent intent = new Intent(MainActivity.this,PurchaseHistory.class);
                startActivity(intent);
            }
        });

        settImage=findViewById(R.id.settingImage);
        settImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openSetting();
            }
            public void openSetting(){
                Intent intent = new Intent(MainActivity.this,Setting.class);
                startActivity(intent);
            }
        });



    }

    private void setHotSalesRecycler(List<HotSalesProduct>hotSalesProductList) {
        hotSalesRecycleView =findViewById(R.id.hotSalesRecycler);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        hotSalesRecycleView.setLayoutManager(layoutManager);
        hotSalesProductAdapter = new HotSalesProductAdapter(this,hotSalesProductList);
        hotSalesRecycleView.setAdapter(hotSalesProductAdapter);
    }

    private void setCategoryRecycler(List<Category>categoryList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecycleView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycleView.setAdapter(categoryAdapter);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

}