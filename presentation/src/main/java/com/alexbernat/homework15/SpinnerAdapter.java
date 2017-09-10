package com.alexbernat.homework15;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alexbernat.homework.R;

import java.util.ArrayList;

/**
 * Created by Александр on 09.09.2017.
 */
public class SpinnerAdapter extends BaseAdapter{

    private ArrayList<com.alexbernat.domain.entity.Country> countryList;
    private Context context;

    public SpinnerAdapter(Context context, ArrayList<com.alexbernat.domain.entity.Country> countries){
        this.context = context;
        countryList = countries;
    }

    @Override
    public int getCount() {
        if (countryList != null)
            return countryList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_homework14, parent, false);
        }

        // get current item to be displayed
        com.alexbernat.domain.entity.Country currentCountry = (com.alexbernat.domain.entity.Country) getItem(position);

        // get the TextView for country name
        TextView countryName = (TextView)
                convertView.findViewById(R.id.homework14_spinner_item);

        //sets the text for country name from the current item object
        countryName.setText(currentCountry.getName());

        // returns the view for the current row
        return convertView;
    }

}
