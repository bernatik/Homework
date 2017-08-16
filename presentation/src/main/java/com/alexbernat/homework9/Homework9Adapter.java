package com.alexbernat.homework9;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ItemHomework9Binding;
import com.bumptech.glide.Glide;

/**
 * Created by Александр on 13.08.2017.
 */
public class Homework9Adapter extends RecyclerView.Adapter<Homework9Adapter.Homework9ViewHolder> {

    ItemViewModel mItemViewModel;

    public Homework9Adapter(ItemViewModel viewModel){
        mItemViewModel = viewModel;
        Log.e("Adapter", "Create Adapter");
    }

    @Override
    public Homework9ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemHomework9Binding pictureBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                        R.layout.item_homework9,
                        parent,
                        false);
        return new Homework9ViewHolder(pictureBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(Homework9ViewHolder holder, int position) {
        ItemViewModel itemViewModel = mItemViewModel.getPictureFromArray(position);
        holder.pictureBinding.setModel(itemViewModel);
    }

    @Override
    public int getItemCount() {
        return mItemViewModel.getPicturesCount();
    }

    @BindingAdapter("bind:loadImage")
    public static void setImageUrl(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    class Homework9ViewHolder extends RecyclerView.ViewHolder{

        ItemHomework9Binding pictureBinding;

        public Homework9ViewHolder(View view){
            super(view);
            pictureBinding = DataBindingUtil.bind(view);
        }


    }


}
