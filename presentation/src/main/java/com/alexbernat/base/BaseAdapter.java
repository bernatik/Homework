package com.alexbernat.base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 18.08.2017.
 */
public abstract class BaseAdapter<Model, ViewModel extends BaseItemViewModel<Model>>
        extends RecyclerView.Adapter<BaseItemViewHolder<Model, ViewModel, ?>> {

    private List<Model> items = new ArrayList<>();

    public BaseAdapter() {}

    public void setItems(List<Model> newItems) {
        items.clear();
        items.addAll(newItems);
        Log.e("BASE ADAPTER", "setItems()");
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder<Model, ViewModel, ?> holder, int position) {
        Model item = items.get(position);
        holder.bindTo(item, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
