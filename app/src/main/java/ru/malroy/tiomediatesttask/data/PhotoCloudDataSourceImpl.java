package ru.malroy.tiomediatesttask.data;

import javax.inject.Inject;

import ru.malroy.tiomediatesttask.BuildConfig;
import ru.malroy.tiomediatesttask.data.rest.RestService;
import ru.malroy.tiomediatesttask.data.rest.entity.RestUser;
import ru.malroy.tiomediatesttask.domain.PhotoCloudDataSource;
import ru.malroy.tiomediatesttask.domain.entity.Photo;
import ru.malroy.tiomediatesttask.domain.entity.PhotoResponseMeta;
import rx.Observable;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class PhotoCloudDataSourceImpl implements PhotoCloudDataSource {

    private RestService restService;

    @Inject
    public PhotoCloudDataSourceImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Observable<PhotoResponseMeta> fetchPopular(int pageNumber) {
        return fetchPhotos("popular", pageNumber);
    }

    @Override
    public Observable<PhotoResponseMeta> fetchToday(int pageNumber) {
        return fetchPhotos("fresh_today", pageNumber);
    }

    private Observable<PhotoResponseMeta> fetchPhotos(String feature, int pageNumber) {
        return restService.getPhotos(BuildConfig.CONSUMER_KEY, feature, pageNumber).flatMap(photoResponse -> {
            return Observable.from(photoResponse.photos)
                    .map(restPhoto -> {
                        RestUser restUser = restPhoto.user;
                        return new Photo().setAuthorName(restUser.firstname + " " + restUser.lastname)
                                .setCountryName(restUser.country)
                                .setDescription(restPhoto.description)
                                .setImageUrl(restPhoto.imageUrl)
                                .setName(restPhoto.name)
                                .setRemoteId(restPhoto.id);
                    }).toList();
        }, (photoResponse, restPhotos) -> {
            return new PhotoResponseMeta().setCurrentPage(photoResponse.currentPage)
                    .setTotalPages(photoResponse.totalPages)
                    .setPhotos(restPhotos);
        });
    }
}
