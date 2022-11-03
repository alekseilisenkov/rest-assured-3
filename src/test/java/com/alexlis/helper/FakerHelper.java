package com.alexlis.helper;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FakerHelper {

    private final static Faker FAKER = new Faker();

    public static String getRandomName() {
        return FAKER.regexify("[A-Z]{6}");
    }

    public static String getRandomPassword() {
        return FAKER.regexify("\\d{3}%[A-Z]{1}[a-z]{2}[A-Z]{3}[0-9]{3}[a-z]{3}");
    }
}
