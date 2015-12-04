package ru.malroy.tiomediatesttask.domain.entity;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */
public class Photo {

    private double remoteId;
    private String name;
    private String description;
    private String imageUrl;
    private String authorName;
    private String countryName;

    public double getRemoteId() {
        return remoteId;
    }

    public Photo setRemoteId(double remoteId) {
        this.remoteId = remoteId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Photo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Photo setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Photo setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Photo setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public Photo setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }
}
