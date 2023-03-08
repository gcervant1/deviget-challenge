package com.deviget.steps.base;

import com.deviget.config.TestConfig;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.io.File;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public abstract class Validate extends TestConfig {


    @Step("Status Code is {0}")
    public void statusCodeIs(int expectedStatusCode) {
        response.then().log().ifValidationFails().assertThat().statusCode(expectedStatusCode);
    }

    @Step("Json Schema file {0} is correct")
    public void againstJsonSchema(String jsonSchema) {
        response.then().body(matchesJsonSchema(new File(jsonSchemasPath + jsonSchema + ".json")));
    }

    @Step("Validate json node {0} contains non empty array")
    public void jsonNodeContainsNonEmptyArray(String jsonNode) {
        response.then().body(jsonNode, not(empty()));
    }

    @Step("Validate array {0} has count {1}")
    public <T> void arraySizeIs(List<T> array, int count) {
        Assert.assertEquals(array.size(), count);
    }

    @Step("Validate array {0} has count {1}")
    public <T> void arrayIsNotGreaterThan(List<T> array, int count) {
        Assert.assertTrue("Validate size is not greater", array.size() < count);
    }

    @Step("Validate json array is not empty")
    public void jsonArrayIsNotEmpty() {
        response.then().body("size()", greaterThan(0));
    }


    @Step("Validate value: {0} is not equal to value {1}")
    public void valuesAreNotMatching(Object expected, Object actual) {
        Assert.assertNotEquals(expected, actual);
    }

}
