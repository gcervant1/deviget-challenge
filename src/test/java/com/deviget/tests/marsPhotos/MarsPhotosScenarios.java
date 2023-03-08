package com.deviget.tests.marsPhotos;

import com.deviget.consts.ConstantValues;
import com.deviget.consts.JsonSchema;
import com.deviget.consts.endpoints.MarsRoverService;
import com.deviget.models.mars.Mars;
import com.deviget.models.mars.Photo;
import com.deviget.tests.base.TestBase;
import io.restassured.http.Method;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MarsPhotosScenarios extends TestBase {

    @Test
    @Title("GET - Validate Mars Rover for sol 1000 and get first 10 photos")
    public void validateMarsRoverForSol1000() {
        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
        set.queryParam(ConstantValues.EARTH_DATE, ConstantValues.EARTH_DATE_VALUE);
        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
        validate.statusCodeIs(200);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonArrayIsNotEmpty();
        Mars marsPhotos = response.as(Mars.class);
        List<Photo> photosWithSolOnly = marsPhotos.getPhotos().subList(0, 10);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonNodeContainsNonEmptyArray(ConstantValues.PHOTOS_NODE);
        validate.arraySizeIs(photosWithSolOnly, 10);
    }

    @Test
    @Title("GET - Validate Mars Rover for sol 1000 and Earth date as today and get first 10 photos")
    public void validateMarsRoverForSol1000AndEarthDate() {
        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
        set.queryParam(ConstantValues.EARTH_DATE, ConstantValues.EARTH_DATE_VALUE);
        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
        validate.statusCodeIs(200);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonArrayIsNotEmpty();
        Mars marsPhotos = response.as(Mars.class);
        List<Photo> photosWithSEarthDate = marsPhotos.getPhotos().subList(0, 10);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonNodeContainsNonEmptyArray(ConstantValues.PHOTOS_NODE);
        validate.arraySizeIs(photosWithSEarthDate, 10);
    }

    @Test
    @Title("GET - Validate data from Sol Only and Earth Date is not matching")
    public void validateDataFromSolOnlyAndEarthDateNotMatching() {
        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
        set.queryParam(ConstantValues.EARTH_DATE, ConstantValues.EARTH_DATE_VALUE);
        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
        validate.statusCodeIs(200);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonArrayIsNotEmpty();
        Mars marsPhotosWithEarthDate = response.as(Mars.class);
        List<Photo> photosWithSEarthDate = marsPhotosWithEarthDate.getPhotos().subList(0, 10);

        // Get photos passing only Sol = 1000
        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
        validate.statusCodeIs(200);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonArrayIsNotEmpty();
        Mars marsPhotosWithSolOnly = response.as(Mars.class);
        List<Photo> photosWithSolOnly = marsPhotosWithSolOnly.getPhotos().subList(0, 10);

        validate.valuesAreNotMatching(photosWithSEarthDate, photosWithSolOnly);
    }

    @Test
    @Title("GET - Validate Mars Rover for sol 1000 and get first 10 photos")
    public void validateAmountOfPicturesIsNotGreaterThan10() {
        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
        set.queryParam(ConstantValues.EARTH_DATE, ConstantValues.EARTH_DATE_VALUE);
        perform.requestWithApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
        validate.statusCodeIs(200);
        validate.againstJsonSchema(JsonSchema.MARS_ROVER_PHOTOS);
        validate.jsonArrayIsNotEmpty();
        Mars marsPhotos = response.as(Mars.class);

        for (ConstantValues.CAMERAS camera : ConstantValues.CAMERAS.values()) {
            List<Photo> actualPhotos = marsPhotos.getPhotos().stream()
                    .filter(photos -> photos.getCamera().getName().equals(camera)
                            && photos.getEarth_date().equals(ConstantValues.EARTH_DATE_VALUE))
                    .collect(Collectors.toList());
            validate.arrayIsNotGreaterThan(actualPhotos, 10);
        }
    }

    @Test
    @Title("GET - Validate 403 Error is retrieved when API is not set")
    public void validateErrorWhenApiKeyIsNotSet() {
        set.queryParam(ConstantValues.SOL, ConstantValues.SOL_VALUE);
        set.queryParam(ConstantValues.EARTH_DATE, ConstantValues.EARTH_DATE_VALUE);
        perform.requestWithoutApiKey(Method.GET, MarsRoverService.MARS_ROVER_PHOTOS);
        validate.statusCodeIs(403);
    }

}
