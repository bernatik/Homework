package com.alexbernat.datainjection;

import com.alexbernat.classwork17.UI;
import com.alexbernat.homework11.Homework11DetailActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Александр on 11.09.2017.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    public void inject(UI ui);

    public void inject(Homework11DetailActivityViewModel vm);

}
