package ru.malroy.tiomediatesttask.domain;

import ru.malroy.tiomediatesttask.domain.entity.PhotoResponseMeta;
import rx.Observable;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public interface PhotoCloudDataSource {
    Observable<PhotoResponseMeta> fetchPopular(int pageNumber);
    Observable<PhotoResponseMeta> fetchToday(int pageNumber);
}
