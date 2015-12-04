package ru.malroy.tiomediatesttask.presentation.photos.tabs;

import java.util.List;

import ru.malroy.tiomediatesttask.domain.entity.Photo;
import ru.malroy.tiomediatesttask.domain.entity.PhotoResponseMeta;
import ru.malroy.tiomediatesttask.domain.use_case.LoadPhotosUseCase;
import ru.malroy.tiomediatesttask.presentation.mvp.BasePresenter;
import ru.malroy.tiomediatesttask.presentation.mvp.LoadingView;
import rx.Subscriber;

/**
 * Created by Dzmitry Lamaka on 04.12.2015.
 */
public abstract class BasePhotoPresenter extends BasePresenter<LoadingView<List<Photo>>> {

    private int nextPageNumber;
    protected LoadPhotosUseCase loadPopularPhotosUseCase;

    public BasePhotoPresenter(LoadPhotosUseCase loadPopularPhotosUseCase) {
        this.loadPopularPhotosUseCase = loadPopularPhotosUseCase;
    }

    public void loadFirstPage() {
        callShowLoading();
        callLoad(1);
    }

    public void loadNextPage() {
        callLoad(nextPageNumber);
    }

    private void callLoad(int pageNumber) {
        load(pageNumber);
    }

    protected abstract void load(int pageNumber);

    @Override
    public void destroy() {
        loadPopularPhotosUseCase.unsubscribe();
    }

    private void callShowLoading() {
        if (isViewAttached()) {
            getView().showLoading();
        }
    }

    private void callHideLoading() {
        if (isViewAttached()) {
            getView().hideLoading();
        }
    }

    private void callSetData(List<Photo> photos) {
        if (isViewAttached()) {
            getView().setData(photos);
        }
    }

    private void callShowContent() {
        if (isViewAttached()) {
            getView().showContent();
        }
    }

    private void callShowError(String errorMessage) {
        if (isViewAttached()) {
            getView().showError(errorMessage);
        }
    }

    public class PhotoSubscriber extends Subscriber<PhotoResponseMeta> {

        @Override
        public void onCompleted() {
            callHideLoading();
            callShowContent();

            if (!isUnsubscribed()) {
                unsubscribe();
            }
        }

        @Override
        public void onError(Throwable e) {
            callHideLoading();
            callShowError("Ошибка: " + e.getMessage());
        }

        @Override
        public void onNext(PhotoResponseMeta photoResponseMeta) {
            int loadedPage = photoResponseMeta.getCurrentPage();
            if (loadedPage != photoResponseMeta.getTotalPages()) {
                nextPageNumber++;
            }
            callSetData(photoResponseMeta.getPhotos());
        }
    }
}
