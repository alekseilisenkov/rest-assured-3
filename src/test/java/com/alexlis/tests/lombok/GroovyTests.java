package com.alexlis.tests.lombok;

import com.alexlis.helper.EndPoints;
import com.alexlis.specs.Specs;
import com.alexlis.tests.TestBase;
import org.junit.jupiter.api.Test;

import static com.alexlis.specs.Specs.reqresRequest;
import static org.hamcrest.Matchers.hasItem;

import static io.restassured.RestAssured.given;
public class GroovyTests extends TestBase {

    @Test
    void getAllBooksWithRequestSpec() {
        Specs.requestSpecification
                .when()
                .get(EndPoints.CONTEXT_PATH_BOOK + "Books")
                .then()
                .log().body()
                .body("data.findAll{it.website =~/.*?@http://speakingjs.com/}.email.flatten()", hasItem(""));
    }

    @Test
    public void checkEmailUsingGroovy() {
        // @formatter:off
        given()
                .spec(reqresRequest)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
        // @formatter:on
    }
}
