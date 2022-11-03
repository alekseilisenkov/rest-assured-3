package com.alexlis.models.lombok.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokBooksData {

    @JsonProperty("books")
    private List<LombokBooks> books;

    private String isbn;
    private String title;
}
