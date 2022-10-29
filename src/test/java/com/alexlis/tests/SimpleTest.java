package com.alexlis.tests;

import com.alexlis.filters.CustomLogFilter;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Feature("API")
@Story("Tests on DemoQA")
@Epic("Simple tests")
public class SimpleTest extends TestBase {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
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
    @Severity(SeverityLevel.BLOCKER)
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
    @Severity(SeverityLevel.BLOCKER)
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
    @Severity(SeverityLevel.CRITICAL)
    @Tag("demoqa")
    void checkAuthorizedOfUserWithAllureTest() {
        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .log().body()
                .body(getDataBody())
                .contentType(ContentType.JSON)
                .when()
                .post("Account/v1/Authorized")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("demoqa")
    void checkExistingOfUserWithCustomFiltersTest() {
        given()
                .filter(CustomLogFilter.customLogFilter().withCustomTemplates())
                .log().uri()
                .log().body()
                .body(getDataBody())
                .contentType(ContentType.JSON)
                .when()
                .post("Account/v1/User")
                .then()
                .log().body()
                .body("message", is("User exists!"))
                .body("code", is("1204"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
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
                .body(matchesJsonSchemaInClasspath("schemas/GenerateTokenSchema.json"));
    }
}
