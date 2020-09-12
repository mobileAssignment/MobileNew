package com.example.mobileassignment.model;

public class HotSalesProduct {

    Integer id;
    int imageurl;

    public HotSalesProduct(Integer id, int imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public int getImageurl() {

        return imageurl;
    }

    public void setImageurl(Integer imageurl) {

        this.imageurl = imageurl;
    }
}
