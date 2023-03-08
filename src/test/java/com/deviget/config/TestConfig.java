package com.deviget.config;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public abstract class TestConfig extends Runner {

    public static String jsonSchemasPath = "src/test/resources/jsonSchemas/";
    public static String apiKey;
    protected static Response response;

    @BeforeClass
    public static void setUp() throws IOException {
        RestAssured.baseURI = getProperties().getProperty("baseUrl");
        apiKey = getProperties().getProperty("apiKey");
    }

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        FileReader file = new FileReader("src/test/resources/properties/test.properties");
        properties.load(file);
        return properties;
    }
}
