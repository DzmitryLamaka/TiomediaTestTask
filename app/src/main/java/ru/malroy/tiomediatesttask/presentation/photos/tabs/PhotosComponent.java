package ru.malroy.tiomediatesttask.presentation.photos.tabs;

import dagger.Component;
import ru.malroy.tiomediatesttask.presentation.di.ActivityScope;
import ru.malroy.tiomediatesttask.presentation.di.AppComponent;
import ru.malroy.tiomediatesttask.presentation.photos.tabs.popular.PopularPhotosPresenter;
import ru.malroy.tiomediatesttask.presentation.photos.tabs.today.TodayPhotosPresenter;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface PhotosComponent {
    PopularPhotosPresenter popularPhotosPresenter();
    TodayPhotosPresenter todayPhotosPresenter();
}
