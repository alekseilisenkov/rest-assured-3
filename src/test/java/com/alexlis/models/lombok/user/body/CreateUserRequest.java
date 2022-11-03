package com.alexlis.models.lombok.user.body;

import com.alexlis.helper.FakerHelper;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(buildMethodName = "please", setterPrefix = "with")
public class CreateUserRequest {

    @Builder.Default
    private final String userName = FakerHelper.getRandomName();

    @Builder.Default
    private final  String password = FakerHelper.getRandomPassword();
}
