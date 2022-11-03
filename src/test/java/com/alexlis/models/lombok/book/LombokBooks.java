package com.alexlis.models.lombok.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokBooks {

    private String isbn;
    private String title;
    private String author;
    @JsonProperty("publish_date")
    private String publishDate;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}
