package com.alexbernat.classwork17;

import com.alexbernat.HomeworkApplication;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Александр on 11.09.2017.
 */
public class UI {

    @Inject
    @Named("a")
    UseCase1 useCase1;

    public UI() {
        HomeworkApplication.appComponent.inject(this);
    }

    public void testUseCase1(){
        useCase1.getRestData();
    }
}
