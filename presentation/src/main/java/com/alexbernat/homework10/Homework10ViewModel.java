package com.alexbernat.homework10;

import android.app.Activity;
import android.databinding.ObservableField;

import com.alexbernat.base.BaseViewModel;

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

    public ObservableField<String> currentNumber = new ObservableField<>();
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
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong%2==0;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        currentNumber.set(String.valueOf(aLong));
                    }
                });
    }

    @Override
    public void pause() {
        if (!mDisposable.isDisposed())
            mDisposable.dispose();
    }
}
