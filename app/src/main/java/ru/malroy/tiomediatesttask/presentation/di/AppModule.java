package ru.malroy.tiomediatesttask.presentation.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ru.malroy.tiomediatesttask.data.PhotoCloudDataSourceImpl;
import ru.malroy.tiomediatesttask.domain.PhotoCloudDataSource;
import ru.malroy.tiomediatesttask.presentation.TiomediaApplication;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(TiomediaApplication context) {
        this.context = context;
    }

    @AppScope @Provides Context getAppContext() {
        return context;
    }

    @AppScope @Provides
    PhotoCloudDataSource providePhotoCloudDataSource(PhotoCloudDataSourceImpl placesCloudDataSource) {
        return placesCloudDataSource;
    }
}
