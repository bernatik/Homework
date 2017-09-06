package com.alexbernat.domain.entity;

import android.content.Context;

/**
 * Created by Александр on 06.09.2017.
 */
public class AddUserBundle {
    private Context mContext;
    private User mUser;

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
