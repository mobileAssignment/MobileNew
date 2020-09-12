package com.example.mobileassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Setting extends AppCompatActivity {

    private ImageView homeImage;
    private ImageView allprodImage;
    private ImageView purhisImage;
    private ImageView settImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);



        homeImage=findViewById(R.id.homeImage);
        homeImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openHome();
            }
            public void openHome(){
                Intent intent = new Intent(Setting.this,MainActivity.class);
                startActivity(intent);
            }
        });

        allprodImage=findViewById(R.id.allProductImage);
        allprodImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openAllProd();
            }
            public void openAllProd(){
                Intent intent = new Intent(Setting.this,AllProduct.class);
                startActivity(intent);
            }
        });

        purhisImage=findViewById(R.id.purchaseHistoryImage);
        purhisImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openPurchase();
            }
            public void openPurchase(){
                Intent intent = new Intent(Setting.this,PurchaseHistory.class);
                startActivity(intent);
            }
        });

        settImage=findViewById(R.id.settingImage);
        settImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openSetting();
            }
            public void openSetting(){
                Intent intent = new Intent(Setting.this,Setting.class);
                startActivity(intent);
            }
        });
    }
}