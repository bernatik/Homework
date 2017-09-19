package com.alexbernat.domain.entity;

/**
 * Created by Александр on 19.09.2017.
 */
public class AuthState {

    private boolean isSigned;

    public AuthState(boolean isSigned) {
        this.isSigned = isSigned;
    }

    public boolean isSigned() {
        return isSigned;
    }
}
