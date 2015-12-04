package ru.malroy.tiomediatesttask.data.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * Created by Dzmitry Lamaka on 03.12.2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoResponse {

    @JsonProperty("current_page")
    public int currentPage;

    @JsonProperty("total_pages")
    public int totalPages;

    @JsonProperty("total_items")
    public int totalItems;

    @JsonProperty("photos")
    public List<RestPhoto> photos = Collections.emptyList();

    @JsonProperty("feature")
    public String feature;

}
