package com.alexbernat.domain.interaction.base;

/**
 * Created by Александр on 11.08.2017.
 */
public abstract class UseCase<InParam, OutParam> {

    abstract protected OutParam buildUseCase();

    public OutParam execute(InParam param){
        return buildUseCase();
    }


}
