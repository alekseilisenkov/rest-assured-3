package com.alexlis.tests;

import com.alexlis.config.MainConfig;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    private String dataBody = "{" +
            "\"userName\": \"test\"," +
            "\"password\": \"1234Qwerty!\"" + "}";

    public String getDataBody() {
        return dataBody;
    }

    @BeforeAll
    public static void setting() {
        MainConfig config = ConfigFactory.create(MainConfig.class, System.getProperties());
        RestAssured.baseURI = config.getApiUri();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browser = config.getBrowserName();
    }
}
