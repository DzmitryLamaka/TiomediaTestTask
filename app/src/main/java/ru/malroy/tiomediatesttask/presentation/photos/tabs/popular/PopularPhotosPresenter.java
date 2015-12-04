package ru.malroy.tiomediatesttask.presentation.photos.tabs.popular;

import javax.inject.Inject;

import ru.malroy.tiomediatesttask.domain.use_case.LoadPhotosUseCase;
import ru.malroy.tiomediatesttask.presentation.photos.tabs.BasePhotoPresenter;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class PopularPhotosPresenter extends BasePhotoPresenter {

    @Inject
    public PopularPhotosPresenter(LoadPhotosUseCase loadPopularPhotosUseCase) {
        super(loadPopularPhotosUseCase);
    }

    protected void load(int pageNumber) {
        loadPopularPhotosUseCase.loadPopular(pageNumber, new PhotoSubscriber());
    }
}
