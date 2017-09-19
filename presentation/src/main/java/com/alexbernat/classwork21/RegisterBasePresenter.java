package com.alexbernat.classwork21;

/**
 * Created by Александр on 19.09.2017.
 */
public interface RegisterBasePresenter {

    public void onResume();
    public void onPause();
    public void onRegisterButtonClick(String username, String password);

}
