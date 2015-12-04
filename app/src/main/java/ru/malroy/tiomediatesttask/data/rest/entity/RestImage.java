
package ru.malroy.tiomediatesttask.data.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestImage {

    @JsonProperty("size")
    public int size;
    @JsonProperty("url")
    public String url;
    @JsonProperty("https_url")
    public String httpsUrl;
    @JsonProperty("format")
    public String format;

}
