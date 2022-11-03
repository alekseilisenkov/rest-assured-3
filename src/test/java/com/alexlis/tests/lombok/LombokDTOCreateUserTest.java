package com.alexlis.tests.lombok;

import com.alexlis.helper.BodyGenerator;
import com.alexlis.models.lombok.user.UserClient;
import com.alexlis.models.lombok.user.body.CreateUserRequest;
import com.alexlis.models.lombok.user.body.CreateUserResponse;
import com.alexlis.tests.TestBase;
import io.qameta.allure.Epic;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Add a new user")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LombokDTOCreateUserTest extends TestBase {

    private UserClient userClient;
    private CreateUserResponse createUserResponse;

    @Test
    void createUser() {
        RequestSpecification createUser = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

        userClient = new UserClient(createUser);

        CreateUserRequest createUserRequest = BodyGenerator.createUser()
                .please();

        createUserResponse = userClient.addUser(createUserRequest)
                .extract().as(CreateUserResponse.class);

        assertThat(createUserResponse.getUserName()).isEqualTo(createUserRequest.getUserName());
        assertThat(createUserResponse.getUserName()).isEqualTo(createUserRequest.getUserName());
        assertThat(createUserResponse.getUserId()).isNotNull();
    }
}
