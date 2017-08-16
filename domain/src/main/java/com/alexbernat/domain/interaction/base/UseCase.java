package com.alexbernat.domain.interaction.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Александр on 11.08.2017.
 */
public abstract class UseCase<InParam, OutParam> {

    private Disposable disposable; //сылка на подписчика (раньше был Subscriber)

    abstract protected Observable<OutParam> buildUseCase(InParam param); //возвращаем поток информации

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver){ //Observer - подписчик
        disposable = buildUseCase(param)
                .observeOn(AndroidSchedulers.mainThread()) //инфа будет приходить в UI поток (наблюдаем в UI)
                .subscribeOn(Schedulers.newThread()) //запрос и обработка в отдельном потоке (выполняем в другом)
                .subscribeWith(disposableObserver);  //подписываем подписчика + ЗАПУСК этого кода
    }

    public void dispose(){   //отписка
        if (!disposable.isDisposed()){
            disposable.dispose();
        }
    }

}
