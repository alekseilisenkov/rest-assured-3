package com.alexlis.models.simple;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksData {

    @JsonProperty("books")
    private List<Books> books;
    private String isbn;
    private String title;
    private String author;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<Books> getBooks() {
        return books;
    }

    public String getAuthor() {
        return author;
    }
}
