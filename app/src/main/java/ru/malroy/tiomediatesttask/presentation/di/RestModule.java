package ru.malroy.tiomediatesttask.presentation.di;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import dagger.Module;
import dagger.Provides;
import retrofit.CallAdapter;
import retrofit.Converter;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import ru.malroy.tiomediatesttask.data.rest.RestService;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */

@Module
public class RestModule {

    @AppScope @Provides
    RestService provideRestService(Converter.Factory converterFactory,
                                                       CallAdapter.Factory callAdapterFactory,
                                                       OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.500px.com/v1/")
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(okHttpClient)
                .build()
                .create(RestService.class);
    }

    @AppScope @Provides Converter.Factory provideConverterFactory() {
        return JacksonConverterFactory.create();
    }

    @AppScope @Provides CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @AppScope @Provides OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.interceptors().add(httpLoggingInterceptor);

        return client;
    }


}
