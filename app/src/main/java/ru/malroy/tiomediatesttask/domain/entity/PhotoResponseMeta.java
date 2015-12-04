package ru.malroy.tiomediatesttask.domain.entity;

import java.util.Collections;
import java.util.List;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class PhotoResponseMeta {

    private List<Photo> photos = Collections.emptyList();
    private int currentPage;
    private int totalPages;

    public List<Photo> getPhotos() {
        return photos;
    }

    public PhotoResponseMeta setPhotos(List<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PhotoResponseMeta setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public PhotoResponseMeta setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }
}
