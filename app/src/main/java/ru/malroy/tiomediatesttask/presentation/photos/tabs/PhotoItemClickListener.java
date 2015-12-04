package ru.malroy.tiomediatesttask.presentation.photos.tabs;

import java.util.List;

import ru.malroy.tiomediatesttask.domain.entity.Photo;

/**
 * Created by Dzmitry Lamaka on 04.12.2015.
 */
public interface PhotoItemClickListener {
    void click(int clickedPosition, List<Photo> photos);
}
