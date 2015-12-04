package ru.malroy.tiomediatesttask.presentation.photos.tabs.popular;

import ru.malroy.tiomediatesttask.presentation.photos.tabs.BasePhotosFragment;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class PopularPhotosFragment extends BasePhotosFragment {

    private PopularPhotosPresenter presenter;

    public static PopularPhotosFragment newInstance() {
        return new PopularPhotosFragment();
    }

    @Override
    protected PopularPhotosPresenter getPresenter() {
        if (presenter == null) {
            presenter = getPhotosComponent().popularPhotosPresenter();
        }
        return presenter;
    }
}
