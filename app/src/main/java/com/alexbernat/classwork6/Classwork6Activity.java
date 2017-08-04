package com.alexbernat.classwork6;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alexbernat.homework.R;

import java.util.ArrayList;

public class Classwork6Activity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);

        recyclerView = (RecyclerView)findViewById(R.id.classwork6_rv);

        /* need to know HOW to show elements in recycler view */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        for (int i = 1; i <= 100; i++){
            stringArrayList.add("Item " + i);
        }

        /* need to know WHAT data and HOW to show it in elements in recycler view */
        Classwork6Adapter adapter = new Classwork6Adapter(stringArrayList);
        recyclerView.setAdapter(adapter);
    }
}
