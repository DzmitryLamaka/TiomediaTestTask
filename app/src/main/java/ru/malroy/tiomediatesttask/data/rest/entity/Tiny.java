
package ru.malroy.tiomediatesttask.data.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tiny {

    @JsonProperty("https")
    public String https;

}
