package com.deviget.steps.base;

import com.deviget.config.RequestSpecificationConfig;
import com.deviget.config.TestConfig;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;


public class Perform extends TestConfig {
    @Step("Request {0} to Endpoint {1}")
    public void requestWithApiKey(Method method, String url) {
        executeRequest(RequestSpecificationConfig
                .withJsonContentType()
                .headers("x-api-key", apiKey), method, url);
        RequestSpecificationConfig.reset();
    }

    @Step("Request {0} to Endpoint {1}")
    public void requestWithoutApiKey(Method method, String url) {
        executeRequest(RequestSpecificationConfig
                .withJsonContentType(), method, url);
        RequestSpecificationConfig.reset();
    }

    public void executeRequest(RequestSpecification specs, Method method, String url) {
        switch (method) {
            case GET:
                response = specs.get(url);
                break;
            case POST:
                response = specs.post(url);
                break;
            case PUT:
                response = specs.put(url);
                break;
            case DELETE:
                response = specs.delete(url);
                break;
            case PATCH:
                response = specs.patch(url);
                break;
            default:
                response = null;
        }
    }
}
