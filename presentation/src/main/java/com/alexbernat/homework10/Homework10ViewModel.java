package com.alexbernat.homework10;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.TextView;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.homework.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Александр on 15.08.2017.
 */
public class Homework10ViewModel implements BaseViewModel {

    public ObservableField<Long> currentNumber = new ObservableField<>();
    public ObservableField<Long> currentOddNumber = new ObservableField<>();
    Disposable mDisposable;
    Activity mActivity;

    public Homework10ViewModel(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        mDisposable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        currentOddNumber.set(aLong);
                    }
                })
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong%2==0;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        currentNumber.set(aLong);
                    }
                });
    }

    @Override
    public void pause() {
        if (!mDisposable.isDisposed())
            mDisposable.dispose();
    }

    @BindingAdapter("bind:changeColor")
    public static void changeColor(TextView view, long number){
        if (number % 8 == 0){
            view.setTextColor(view.getContext().getResources().getColor(R.color.color_blue));
        } else if (number % 6 == 0){
            view.setTextColor(view.getContext().getResources().getColor(R.color.color_yellow));
        } else if (number % 2 == 0){
            view.setTextColor(view.getContext().getResources().getColor(R.color.color_green));
        } else if (number % 5 == 0){
            view.setTextColor(view.getContext().getResources().getColor(R.color.color_red));
        } else
            view.setTextColor(view.getContext().getResources().getColor(android.R.color.black));

    }
}
