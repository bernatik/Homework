package com.alexbernat.classwork21;

import com.alexbernat.HomeworkApplication;
import com.alexbernat.domain.entity.AuthState;
import com.alexbernat.domain.entity.RegisterDomain;
import com.alexbernat.domain.entity.ResponseDomain;
import com.alexbernat.domain.interaction.AuthService;
import com.alexbernat.domain.interaction.RegisterUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 19.09.2017.
 */
public class RegisterPresenter implements RegisterBasePresenter{

    @Inject
    public RegisterUseCase useCase;

    @Inject
    public AuthService authService;

    public Disposable authDisposable;

    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        HomeworkApplication.appComponent.inject(this);
        this.view = view;
    }

    public void onRegisterButtonClick(String username, String password){
        view.showProgress();

        RegisterDomain registerDomain = new RegisterDomain();
        registerDomain.setUsername(username);
        registerDomain.setPassword(password);
        useCase.execute(registerDomain, new DisposableObserver<ResponseDomain>() {
            @Override
            public void onNext(@NonNull ResponseDomain responseDomain) {
                view.dismissProgress();
                view.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError("error");

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void onResume() {
        authService.observeState().subscribeWith(new DisposableObserver<AuthState>() {
            @Override
            public void onNext(@NonNull AuthState authState) {
                //get authState
                if (authState.isSigned())
                    view.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void onPause() {
        if (authDisposable != null && !authDisposable.isDisposed())
            authDisposable.dispose();
    }
}
