package ru.malroy.tiomediatesttask.presentation.photos.tabs;

import java.util.List;

import ru.malroy.tiomediatesttask.domain.entity.Photo;
import ru.malroy.tiomediatesttask.presentation.mvp.LoadingView;

/**
 * Created by Dzmitry Lamaka on 04.12.2015.
 */
public class PhotosViewState {

    private static final int STATE_SHOW_LOADING = 0;
    private static final int STATE_SHOW_CONTENT = 1;
    private static final int STATE_SHOW_ERROR = -1;

    private int currentState;
    private List<Photo> photos;
    private String errorMessage;

    public void setStateShowContent(List<Photo> photos) {
        currentState = STATE_SHOW_CONTENT;
        this.photos = photos;
    }

    public void setStateShowLoading() {
        currentState = STATE_SHOW_LOADING;
    }

    public void setStateShowError(String errorMessage) {
        currentState = STATE_SHOW_ERROR;
        this.errorMessage = errorMessage;
    }

    public void apply(LoadingView<List<Photo>> view) {
        switch (currentState) {
            default:
            case STATE_SHOW_LOADING: {
                view.showLoading();
                break;
            }
            case STATE_SHOW_CONTENT: {
                view.setData(photos);
                view.hideLoading();
                view.showContent();
                break;
            }
            case STATE_SHOW_ERROR: {
                view.showError(errorMessage);
                break;
            }
        }
    }

}
