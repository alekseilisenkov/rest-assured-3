package com.alexlis.models.lombok.user.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

    @JsonProperty("userID")
    String userId;
    @JsonProperty("username")
    String userName;
    private List<books> books;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class books {

        private String isbn;
        private String title;
        private String subTitle;
        private String author;
        @JsonProperty("publish_date")
        private String publishDate;
        private String publisher;
        private Integer pages;
        private String description;
        private String website;
    }
}
