package ru.malroy.tiomediatesttask.presentation.photos.tabs.today;

import ru.malroy.tiomediatesttask.presentation.photos.tabs.BasePhotosFragment;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class TodayPhotosFragment extends BasePhotosFragment {

    private TodayPhotosPresenter presenter;

    public static TodayPhotosFragment newInstance() {
        return new TodayPhotosFragment();
    }

    @Override
    protected TodayPhotosPresenter getPresenter() {
        if (presenter == null) {
            presenter = getPhotosComponent().todayPhotosPresenter();
        }
        return presenter;
    }
}
