package com.alexbernat.classwork13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 21.08.2017.
 */
public class Classwork13Fragment extends Fragment {

    public static final String KEY_TEXT = "text";
    private String text;

    public static Classwork13Fragment newInstance(FragmentManager manager, String text){

        Fragment fragment = manager.findFragmentByTag(Classwork13Fragment.class.getName());

        Classwork13Fragment classwork13Fragment;
        if (fragment != null && fragment instanceof Classwork13Fragment){
            classwork13Fragment = (Classwork13Fragment) fragment;
        } else {
            classwork13Fragment = new Classwork13Fragment();
            Bundle bundle = new Bundle();
            bundle.putString(KEY_TEXT, text);
            classwork13Fragment.setArguments(bundle);
        }

        return classwork13Fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null)
            text = bundle.getString(KEY_TEXT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Здесь делать биндинг, возвращаем binding.getRoot().
        return inflater.inflate(R.layout.fragment_classwork13, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //здесь вешаются листенеры и прочая фигня
    }
}
