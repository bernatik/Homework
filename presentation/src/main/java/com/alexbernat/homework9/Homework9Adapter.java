package com.alexbernat.homework9;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alexbernat.homework.R;
import com.alexbernat.homework.databinding.ItemHomework9Binding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Александр on 13.08.2017.
 */
public class Homework9Adapter extends RecyclerView.Adapter<Homework9Adapter.Homework9ViewHolder> {

    ArrayList<Picture> picturesList;

    public Homework9Adapter(){
        picturesList = new ArrayList<>();
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/ee/cf/37/eecf37527700cce34dc313737203ccc2--comedy-movies-hd-movies.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/originals/b0/75/68/b07568db6c706ac6f0bb63c5dee21d5d.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/5b/bc/09/5bbc0921b795fb5a24a32404caf040a8--film-poster-movie-posters.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/3e/2a/2b/3e2a2b4f7eadd7d1ec403373438c549e--hd-movies-movies-free.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/27/09/2b/27092bbb5f20a43c7e04e46429de4964.jpg"));
        picturesList.add(new Picture("https://www.movie2free.com/wp-content/uploads/2015/05/SmallSoldiers1.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/originals/57/c4/8b/57c48b8dfde29e078ed46ed8a3dddadb.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/b5/11/6c/b5116cf85b309b39f201d780c1a235a7--ip-man-man-.jpg"));
        picturesList.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/13/81/30/138130c7ff0ee9da2a26e88935f49476--watch-free-movies-movies-free.jpg"));
        picturesList.add(new Picture("https://i.pinimg.com/236x/28/94/1f/28941fd4d1e50ba307b12cfdbce192bc--kung-fu-movies--movie.jpg"));
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
