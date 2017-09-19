package com.alexbernat.classwork21;

/**
 * Created by Александр on 19.09.2017.
 */
public interface RegisterView {
    public void showProgress();
    public void dismissProgress();
    public void showError(String error);
    public void goToMainActivity();
}
