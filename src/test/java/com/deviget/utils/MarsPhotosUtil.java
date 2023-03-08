package com.deviget.utils;

import com.deviget.config.TestConfig;
import com.deviget.consts.ConstantValues;
import com.deviget.consts.JsonSchema;
import com.deviget.consts.endpoints.MarsRoverService;
import com.deviget.models.mars.Mars;
import com.deviget.models.mars.Photo;
import com.deviget.tests.base.TestBase;
import io.restassured.http.Method;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static io.restassured.RestAssured.given;

public  class MarsPhotosUtil  {

//    public static String getTodayDate() {
//        LocalDate dateObject = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return dateObject.format(formatter);
//    }
//    public static List<Photo> getCuriosityPhotosForToday(String date) {
//        Mars marsObject = given()
//                .header("x-api-key", TestConfig.apiKey)
//                .queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE)
//                .queryParam(ConstantValues.EARTH_DATE, date)
//                .get(MarsRoverService.MARS_ROVER_PHOTOS)
//                .then().statusCode(200)
//                .extract().as(Mars.class);
////        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
////        set.queryParam(ConstantValues.EARTH_DATE, date);
////        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
////        validate.statusCodeIs(200);
////        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
////        validate.jsonArrayIsNotEmpty();
//      //  Mars marsObject = response.as(Mars.class);
//        return marsObject.getPhotos();
//    }
//
//    public static List<Photo> getCuriosityPhotosWithSol() {
//        Mars marsObject = given()
//                .header("x-api-key", TestConfig.apiKey)
//                .queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE)
//                .get(MarsRoverService.MARS_ROVER_PHOTOS)
//                .then().statusCode(200)
//                .extract().as(Mars.class);
////        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
////        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
////        validate.statusCodeIs(200);
////        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
////        validate.jsonArrayIsNotEmpty();
////        Mars marsObject = response.as(Mars.class);
//        return marsObject.getPhotos();
//
//    }
}
