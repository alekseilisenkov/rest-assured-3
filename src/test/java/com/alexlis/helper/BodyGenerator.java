package com.alexlis.helper;

import com.alexlis.models.lombok.user.body.CreateUserRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BodyGenerator {

    public static CreateUserRequest.CreateUserRequestBuilder createUser() {
        return CreateUserRequest.builder();
    }


}
