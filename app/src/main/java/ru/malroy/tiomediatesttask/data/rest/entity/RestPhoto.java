
package ru.malroy.tiomediatesttask.data.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestPhoto {

    @JsonProperty("id")
    public double id;
    @JsonProperty("user_id")
    public double userId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("camera")
    public String camera;
    @JsonProperty("lens")
    public Object lens;
    @JsonProperty("focal_length")
    public String focalLength;
    @JsonProperty("iso")
    public String iso;
    @JsonProperty("shutter_speed")
    public String shutterSpeed;
    @JsonProperty("aperture")
    public String aperture;
    @JsonProperty("times_viewed")
    public int timesViewed;
    @JsonProperty("rating")
    public float rating;
    @JsonProperty("status")
    public int status;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("category")
    public int category;
    @JsonProperty("location")
    public Object location;
    @JsonProperty("latitude")
    public float latitude;
    @JsonProperty("longitude")
    public float longitude;
    @JsonProperty("taken_at")
    public String takenAt;
    @JsonProperty("hi_res_uploaded")
    public int hiResUploaded;
    @JsonProperty("for_sale")
    public boolean forSale;
    @JsonProperty("width")
    public int width;
    @JsonProperty("height")
    public int height;
    @JsonProperty("votes_count")
    public int votesCount;
    @JsonProperty("favorites_count")
    public int favoritesCount;
    @JsonProperty("comments_count")
    public int commentsCount;
    @JsonProperty("nsfw")
    public boolean nsfw;
    @JsonProperty("sales_count")
    public int salesCount;
    @JsonProperty("for_sale_date")
    public Object forSaleDate;
    @JsonProperty("highest_rating")
    public float highestRating;
    @JsonProperty("highest_rating_date")
    public String highestRatingDate;
    @JsonProperty("license_type")
    public int licenseType;
    @JsonProperty("converted")
    public int converted;
    @JsonProperty("collections_count")
    public int collectionsCount;
    @JsonProperty("crop_version")
    public int cropVersion;
    @JsonProperty("privacy")
    public boolean privacy;
    @JsonProperty("image_url")
    public String imageUrl;
    @JsonProperty("images")
    public List<RestImage> images = new ArrayList<>();
    @JsonProperty("url")
    public String url;
    @JsonProperty("positive_votes_count")
    public int positiveVotesCount;
    @JsonProperty("converted_bits")
    public int convertedBits;
    @JsonProperty("watermark")
    public boolean watermark;
    @JsonProperty("image_format")
    public String imageFormat;
    @JsonProperty("user")
    public RestUser user;
    @JsonProperty("licensing_requested")
    public boolean licensingRequested;

}
