package com.alexlis.tests.lombok;

import com.alexlis.helper.EndPoints;
import com.alexlis.models.lombok.book.LombokBooksData;
import com.alexlis.specs.Specs;
import com.alexlis.tests.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LombokSimpleTests extends TestBase {

    @Test
    void getAllBooksWithModelBody() {
        LombokBooksData lombokBooksData =
                Specs.requestSpecification
                        .when()
                        .get(EndPoints.CONTEXT_PATH_BOOK + "Books")
                        .then()
                        .log().body()
                        .extract().as(LombokBooksData.class);
        Assertions.assertAll(
                () -> assertEquals("9781449325862", lombokBooksData.getBooks().get(0).getIsbn()),
                () -> assertEquals("2020-06-04T08:48:39.000Z", lombokBooksData.getBooks().get(0).getPublishDate()),
                () -> assertEquals("Git Pocket Guide", lombokBooksData.getBooks().get(0).getTitle())
        );
    }

    @Test
    void getByIdWithModelBody() {
        LombokBooksData lombokBooksData =
                Specs.requestSpecification
                        .when()
                        .get(EndPoints.CONTEXT_PATH_BOOK + "Book?ISBN=9781449325862")
                        .then()
                        .log().body()
                        .extract().as(LombokBooksData.class);

        Assertions.assertAll(
                () -> assertEquals("9781449325862", lombokBooksData.getIsbn()),
                () -> assertEquals("Git Pocket Guide", lombokBooksData.getTitle())
        );
    }
}
