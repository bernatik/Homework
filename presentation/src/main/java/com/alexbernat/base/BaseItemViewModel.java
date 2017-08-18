package com.alexbernat.base;

/**
 * Created by Александр on 18.08.2017.
 */
public abstract class BaseItemViewModel<Model> implements BaseViewModel {

    abstract public void setItem(Model item, int position);

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
