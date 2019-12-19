package com.elif.traveltheworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class totalAdapter extends RecyclerView.Adapter<totalAdapter.ViewHolder> {
    private ArrayList<Item> mExampleList;
    public  String value;




    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mCountryName;


        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img);
            mCountryName = itemView.findViewById(R.id.countryName);

        }
    }

    public totalAdapter(ArrayList<Item> exampleList){
        mExampleList = exampleList;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vholder = new ViewHolder(view);
        return  vholder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {



        Item currentItem= mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getmImgResource());
        holder.mCountryName.setText(currentItem.getmName());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
