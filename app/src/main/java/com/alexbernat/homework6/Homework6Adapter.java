package com.alexbernat.homework6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.alexbernat.homework.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

/**
 * Created by Александр on 06.08.2017.
 */
public class Homework6Adapter extends RecyclerView.Adapter<Homework6Adapter.Homework6ViewHolder> {

    ArrayList<String> urls;
    Context context;
    OnItemClickListener clickListener;

    public Homework6Adapter(ArrayList<String> urls, Context context) {
        this.urls = urls;
        this.context = context;
    }

    @Override
    public Homework6ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_homework6, parent, false);
        return new Homework6ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final Homework6ViewHolder holder, int position) {
        final String item = urls.get(position);
        Glide.with(context)
                .load(urls.get(position))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.image.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return urls == null ? 0 : urls.size();
    }

    public class Homework6ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        ProgressBar progressBar;

        public Homework6ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image_homework6);
            progressBar = (ProgressBar)itemView.findViewById(R.id.progress_bar_homework6);
        }
    }


    interface OnItemClickListener{
        public void onItemClick(String item);
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
