package com.alexlis.client;

import com.alexlis.helper.EndPoints;
import com.alexlis.models.lombok.user.request.CreateUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

import static com.alexlis.specs.Specs.*;
import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class UserClient {

    private final RequestSpecification requestSpecification;

    @Step("Add a new user")
    public ValidatableResponse addUser(final CreateUserRequest userRequest) {
        return given()
                .spec(requestSpecification)
                .body(userRequest)
                .log().uri()
                .log().body()
                .when()
                .post(EndPoints.CONTEXT_PATH_USER)
                .then()
                .spec(responseUser);
    }
}
