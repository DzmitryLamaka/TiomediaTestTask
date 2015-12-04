package ru.malroy.tiomediatesttask.data.rest;

import retrofit.http.GET;
import retrofit.http.Query;
import ru.malroy.tiomediatesttask.data.rest.entity.PhotoResponse;
import rx.Observable;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public interface RestService {

    @GET("photos?image_size=21")
    Observable<PhotoResponse> getPhotos(@Query("consumer_key") String consumerKey,
                                        @Query("feature") String feature,
                                         @Query("page") int pageNumber);

}
