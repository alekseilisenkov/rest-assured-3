package com.alexlis.tests.simple;

import com.alexlis.helper.EndPoints;
import com.alexlis.models.simple.BooksData;
import com.alexlis.specs.Specs;
import com.alexlis.tests.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsWithSpecs extends TestBase {

    @Test
    void getAllBooksWithRequestSpec() {
        Specs.requestSpecification
                .when()
                .get(EndPoints.CONTEXT_PATH_BOOK + "Books")
                .then()
                .log().all();
    }

    @Test
    void getAllBooksWithModelBody() {
        BooksData booksData = Specs.requestSpecification
                .when()
                .get(EndPoints.CONTEXT_PATH_BOOK + "Books")
                .then()
                .log().body()
                .extract().as(BooksData.class);

        assertEquals("Richard E. Silverman", booksData.getBooks().get(0).getAuthor());
        assertEquals("A Working Introduction", booksData.getBooks().get(0).getSubTitle());
        assertEquals("9781449331818", booksData.getBooks().get(1).getIsbn());
    }

    @Test
    void getBookByIdWithModelBody() {
        BooksData booksData = Specs.requestSpecification
                .when()
                .get(EndPoints.CONTEXT_PATH_BOOK + "Book?ISBN=9781449325862")
                .then()
                .log().body()
                .extract().as(BooksData.class);

       assertEquals("9781449325862", booksData.getIsbn());
       assertEquals("Git Pocket Guide", booksData.getTitle());
       assertEquals("Richard E. Silverman", booksData.getAuthor());
    }
}
