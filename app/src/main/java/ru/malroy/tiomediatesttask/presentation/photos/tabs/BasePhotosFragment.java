package ru.malroy.tiomediatesttask.presentation.photos.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import ru.malroy.tiomediatesttask.R;
import ru.malroy.tiomediatesttask.domain.entity.Photo;
import ru.malroy.tiomediatesttask.presentation.di.HasComponent;
import ru.malroy.tiomediatesttask.presentation.mvp.LoadingView;
import ru.malroy.tiomediatesttask.presentation.photos.detail.DetailActivity;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public abstract class BasePhotosFragment extends Fragment implements LoadingView<List<Photo>> {

    protected View rootContainer;
    protected RecyclerView photos;
    protected ProgressBar progress;
    private PhotoAdapter photoAdapter;
    private PhotosViewState photosViewState;
    private boolean isLoading;

    private final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

            if (dy > 0 && !isLoading) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount / 3
                        && firstVisibleItemPosition >= 0) {
                    isLoading = true;
                    getPresenter().loadNextPage();
                }
            }

        }
    };

    protected abstract <T extends BasePhotoPresenter> T getPresenter();

    protected PhotosComponent getPhotosComponent() {
        HasComponent<PhotosComponent> hasComponent = (HasComponent<PhotosComponent>) getActivity();
        return hasComponent.getComponent();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        photosViewState = new PhotosViewState();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_photos, container, false);
        rootContainer = view;
        photos = (RecyclerView) view.findViewById(R.id.photos);
        progress = (ProgressBar) view.findViewById(R.id.progress);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().attachView(this);

        photoAdapter = new PhotoAdapter(getActivity(), (clickedPosition, photos) ->
                DetailActivity.start(getActivity(), clickedPosition, photos));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        photos.setLayoutManager(linearLayoutManager);
        photos.addOnScrollListener(onScrollListener);
        photos.setAdapter(photoAdapter);

        photosViewState.apply(this);

        if (savedInstanceState == null) {
            getPresenter().loadFirstPage();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    @Override
    public void showLoading() {
        photosViewState.setStateShowLoading();
        photos.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        isLoading = false;
        photosViewState.setStateShowError(errorMessage);
        Snackbar.make(rootContainer, errorMessage, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showContent() {
        photosViewState.setStateShowContent(photoAdapter.getPhotos());
        photos.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(List<Photo> data) {
        isLoading = false;
        photoAdapter.addPhotos(data);
    }

}
