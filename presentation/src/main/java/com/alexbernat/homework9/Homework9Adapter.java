package com.alexbernat.homework9;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alexbernat.domain.entity.Picture;
import com.alexbernat.domain.interaction.PictureArrayUseCase;
import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ItemHomework9Binding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 13.08.2017.
 */
public class Homework9Adapter extends RecyclerView.Adapter<Homework9Adapter.Homework9ViewHolder> {

    ArrayList<Picture> picturesList;

    public Homework9Adapter(){
//        ItemViewModel itemViewModel = new ItemViewModel();
//        picturesList = itemViewModel.getPicturesArray();
        Log.e("Adapter", "Write new ArrayList into Adapter");
        new PictureArrayUseCase().execute(10, new DisposableObserver<ArrayList<Picture>>() {
            @Override
            public void onNext(@NonNull ArrayList<Picture> pictures) {
                picturesList = pictures;
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }); //create use case to receive an array of pictures
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
        Picture picture = picturesList.get(position);
        holder.pictureBinding.setModel(picture);
    }

    @Override
    public int getItemCount() {
        return picturesList != null ? picturesList.size() : 0;
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
