package ru.malroy.tiomediatesttask.presentation.mvp;

/**
 * Created by Dzmitry Lamaka on 02.12.2015.
 */
public interface Presenter<V extends MvpView> {
    void attachView(V view);
    void detachView();
    void destroy();
}
