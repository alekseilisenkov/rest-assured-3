package com.alexlis.specs;

import com.alexlis.filters.CustomLogFilter;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestSpecification = with()
            .filter(CustomLogFilter.customLogFilter().withCustomTemplates())
            .log().uri()
            .log().body()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseUser = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.BODY)
            .build();
}
