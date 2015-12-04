package ru.malroy.tiomediatesttask.presentation.mvp;

/**
 * Created by Dzmitry Lamaka on 02.12.2015.
 */
public interface LoadingView<E> extends MvpView {
    void showLoading();
    void hideLoading();
    void showError(String errorMessage);
    void showContent();
    void setData(E data);
}
