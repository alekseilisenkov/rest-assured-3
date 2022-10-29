package com.alexlis.tests;

import com.alexlis.filters.CustomLogFilter;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Feature("API")
@Story("Tests on DemoQA")
public class SimpleTest extends TestBase {

    @Test
    @Tag("books")
    void getBooksTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("BookStore/v1/Books")
                .then()
                .statusCode(200)
                .body("books", hasSize(greaterThan(0)));
    }

    @Test
    @Tag("books")
    void getBooksWithAllLogsTest() {
        given()
                .log().all()
                .get("BookStore/v1/Books")
                .then()
                .log().all()
                .body("books", hasSize(greaterThan(0)));
    }

    @Test
    @Tag("books")
    void getBooksWithSelectedLogsTest() {
        given()
                .log().uri()
                .log().body()
                .get("BookStore/v1/Books")
                .then()
                .log().body()
                .body("books", hasSize(greaterThan(0)));
    }

    @Test
    @Tag("demoqa")
    void generateTokenWithAllureTest() {
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .body(getDataBody())
                .contentType(ContentType.JSON)
                .when()
                .log().uri()
                .log().body()
                .post("Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }

    @Test
    @Tag("demoqa")
    void generateTokenWithCustomFiltersTest() {
        given()
                .filter(CustomLogFilter.customLogFilter().withCustomTemplates())
                .log().all()
                .body(getDataBody())
                .contentType(ContentType.JSON)
                .when()
                .log().uri()
                .log().body()
                .post("Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."));
    }

    @Test
    @Tag("demoqa")
    void generateTokenWithSchemaAssertTest() {
        given()
                .filter(CustomLogFilter.customLogFilter().withCustomTemplates())
                .log().all()
                .body(getDataBody())
                .contentType(ContentType.JSON)
                .when()
                .log().uri()
                .log().body()
                .post("Account/v1/GenerateToken")
                .then()
                .log().body()
                .body("status", is("Success"))
                .body(matchesJsonSchemaInClasspath("schemas/GenerateTokenSchema.json"))
                .body("result", is("User authorized successfully."));
    }
}
