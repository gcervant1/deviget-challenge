package com.deviget.config;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;

public class RequestSpecificationConfig {

    private static RequestSpecification reqSpec;

    private static void checkForInstance() {
        if (reqSpec == null) {
            RestAssured.config = RestAssuredConfig.config()
                    .httpClient(HttpClientConfig.httpClientConfig()
                            .setParam("http.socket.timeout", 20000)
                            .setParam("http.connection.timeout", 20000));

            reqSpec = given().log().everything(true);
        }
    }

    public static RequestSpecification withJsonContentType() {
        checkForInstance();
        return reqSpec
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification withQueryParam(String queryParamName, Object queryParamValue) {
        checkForInstance();
        return reqSpec.queryParam(queryParamName, queryParamValue);
    }

    public static void reset() {
        reqSpec = null;
    }

    public static RequestSpecification get() {
        return reqSpec;
    }
}