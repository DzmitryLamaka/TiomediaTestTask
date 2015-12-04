
package ru.malroy.tiomediatesttask.data.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestUser {

    @JsonProperty("id")
    public int id;
    @JsonProperty("username")
    public String username;
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("usertype")
    public int usertype;
    @JsonProperty("fullname")
    public String fullname;
    @JsonProperty("userpic_url")
    public String userpicUrl;
    @JsonProperty("userpic_https_url")
    public String userpicHttpsUrl;
    @JsonProperty("cover_url")
    public String coverUrl;
    @JsonProperty("upgrade_status")
    public int upgradeStatus;
    @JsonProperty("store_on")
    public boolean storeOn;
    @JsonProperty("affection")
    public int affection;
    @JsonProperty("avatars")
    public RestAvatars avatars;

}
