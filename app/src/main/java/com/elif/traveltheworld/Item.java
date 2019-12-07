package com.elif.traveltheworld;

public class Item {
    private int mImgResource;
    private String mCountryName;

    public Item(int imgResource, String country){

        mImgResource= imgResource;
        mCountryName= country;

    }

    public int getmImgResource(){
        return mImgResource;
    }

    public String getmName(){
        return mCountryName;
    }


}
