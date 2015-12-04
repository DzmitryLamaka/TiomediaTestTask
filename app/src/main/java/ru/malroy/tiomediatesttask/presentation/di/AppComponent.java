package ru.malroy.tiomediatesttask.presentation.di;

import dagger.Component;
import ru.malroy.tiomediatesttask.domain.PhotoCloudDataSource;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */

@AppScope
@Component(modules = {AppModule.class, RestModule.class})
public interface AppComponent {
    PhotoCloudDataSource photoCloudDataSource();
}
