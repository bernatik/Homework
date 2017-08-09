package com.alexbernat.classwork6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexbernat.homework.R;

import java.util.ArrayList;

/**
 * Created by Александр on 04.08.2017.
 */

public class Classwork6Adapter extends RecyclerView.Adapter<Classwork6Adapter.Holder> {

    private ArrayList<String> items;

    public Classwork6Adapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_classwork6_rv, parent, false);
        Log.e("AAA", "onCreateViewHolder()");
        return new Holder(rootView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("AAA", "onBindViewHolder()");
        String item = items.get(position);
        holder.imageView.setImageResource(R.drawable.money);
        holder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }
    }
}
