package com.alexbernat.homework11;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.alexbernat.base.BaseItemViewModel;
import com.alexbernat.domain.entity.Homework11ProfileModel;

/**
 * Created by Александр on 20.08.2017.
 */
public class Homework11ItemViewModel extends BaseItemViewModel<Homework11ProfileModel>{

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> objectId = new ObservableField<>("");
    private Context context;


    @Override
    public void setItem(Homework11ProfileModel item, int position) {
        name.set(item.getName());
        objectId.set(item.getStringId());

    }

    public void onClickItem(View view){
        Intent intent = new Intent(context, Homework11DetailActivity.class);
        intent.putExtra(Homework11DetailActivityViewModel.KEY_ITEM_TO_EDIT, objectId.get()); //id of an item to edit
        context.startActivity(intent);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
