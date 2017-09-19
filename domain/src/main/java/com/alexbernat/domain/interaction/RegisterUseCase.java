package com.alexbernat.domain.interaction;

import com.alexbernat.data.entity.AccessTokenData;
import com.alexbernat.data.entity.RegisterData;
import com.alexbernat.data.net.RestService;
import com.alexbernat.domain.entity.RegisterDomain;
import com.alexbernat.domain.entity.ResponseDomain;
import com.alexbernat.domain.interaction.base.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Александр on 19.09.2017.
 */
public class RegisterUseCase extends UseCase<RegisterDomain, ResponseDomain> {

    private AuthService service;

    @Inject
    public RegisterUseCase(AuthService authService) {
        this.service = authService;
    }

    @Override
    protected Observable<ResponseDomain> buildUseCase(RegisterDomain register) {

        return RestService.getInstance().register(convert(register))
                .doOnNext(new Consumer<AccessTokenData>() {
                    @Override
                    public void accept(AccessTokenData accessTokenData) throws Exception {
                        service.saveAccessToken(accessTokenData.getAccessToken());
                    }
                })
                .map(new Function<AccessTokenData, ResponseDomain>() {
                    @Override
                    public ResponseDomain apply(@NonNull AccessTokenData accessTokenData) throws Exception {
                        return new ResponseDomain();
                    }
                });
    }

    private RegisterData convert(RegisterDomain registerDomain){

        RegisterData registerData = new RegisterData();
        registerData.setUsername(registerDomain.getUsername());
        registerData.setPassword(registerDomain.getPassword());

        return registerData;
    }
}
