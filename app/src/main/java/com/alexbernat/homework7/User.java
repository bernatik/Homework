package com.alexbernat.homework7;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.alexbernat.homework.BR;
import com.bumptech.glide.Glide;

/**
 * Created by Александр on 09.08.2017.
 */
public class User extends BaseObservable {

    String imageUrl;
    String name;
    String surname;
    int age;
    int sex; // 0 - man, 1 - woman

    public User(String imageUrl, String name, String surname, int age, int sex) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }


    @BindingAdapter("app:src")
    public static void setImageUrl(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        notifyPropertyChanged(BR.surname);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

}
