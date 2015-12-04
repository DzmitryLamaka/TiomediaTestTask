package ru.malroy.tiomediatesttask.domain.use_case;

import javax.inject.Inject;

import ru.malroy.tiomediatesttask.domain.PhotoCloudDataSource;
import ru.malroy.tiomediatesttask.domain.entity.PhotoResponseMeta;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class LoadPhotosUseCase {

    private final Observable.Transformer<PhotoResponseMeta, PhotoResponseMeta> backgroundTransformer = photoResponseMeta ->
            photoResponseMeta.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    private PhotoCloudDataSource photoCloudDataSource;

    @Inject
    public LoadPhotosUseCase(PhotoCloudDataSource photoCloudDataSource) {
        this.photoCloudDataSource = photoCloudDataSource;
    }

    private CompositeSubscription subscriptions = new CompositeSubscription();

    public void loadPopular(int pageNumber, Subscriber<PhotoResponseMeta> subscriber) {
        Subscription subscription = photoCloudDataSource.fetchPopular(pageNumber)
                .compose(backgroundTransformer)
                .subscribe(subscriber);
        subscriptions.add(subscription);
    }

    public void loadToday(int pageNumber, Subscriber<PhotoResponseMeta> subscriber) {
        Subscription subscription = photoCloudDataSource.fetchToday(pageNumber)
                .compose(backgroundTransformer)
                .subscribe(subscriber);
        subscriptions.add(subscription);
    }

    public void unsubscribe() {
        if (!subscriptions.isUnsubscribed()) {
            subscriptions.unsubscribe();
        }

        subscriptions = new CompositeSubscription();
    }

}
