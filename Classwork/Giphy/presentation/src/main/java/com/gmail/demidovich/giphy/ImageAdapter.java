package com.gmail.demidovich.giphy;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.demidovich.domain.entity.ImageEntity;
import com.gmail.demidovich.giphy.databinding.ItemImgBinding;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ImageEntity> mImageEntityList = new ArrayList<>();

    public void setImageList(List<ImageEntity> list) {
        this.mImageEntityList.clear();
        this.mImageEntityList.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemImgBinding binding = ItemImgBinding.inflate(inflater, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("random tag", "onBindViewHolder");
        Holder myHolder = (Holder) holder;
        myHolder.itemImagesBinding.setImage(mImageEntityList.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageEntityList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ItemImgBinding itemImagesBinding;

        Holder(View itemView) {
            super(itemView);

            itemImagesBinding = DataBindingUtil.bind(itemView);
        }
    }
}
