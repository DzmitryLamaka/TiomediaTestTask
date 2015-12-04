
package ru.malroy.tiomediatesttask.data.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestAvatars {

    @JsonProperty("default")
    public Default _default;
    @JsonProperty("large")
    public Large large;
    @JsonProperty("small")
    public Small small;
    @JsonProperty("tiny")
    public Tiny tiny;

}
