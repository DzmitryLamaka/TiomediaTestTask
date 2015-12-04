package ru.malroy.tiomediatesttask.presentation.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by Dzmitry Lamaka on 02.12.2015.
 */
public abstract class BasePresenter<V extends MvpView> implements Presenter<V> {

    private WeakReference<V> weakView;

    @Override
    public void attachView(V view) {
        weakView = new WeakReference<>(view);
    }

    public V getView() {
        return weakView.get();
    }

    public boolean isViewAttached() {
        return (weakView != null && weakView.get() != null);
    }

    @Override
    public void detachView() {
        if (isViewAttached()) {
            weakView.clear();
            weakView = null;
        }
    }
}
