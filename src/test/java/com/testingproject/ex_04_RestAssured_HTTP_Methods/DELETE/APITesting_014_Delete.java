package com.testingproject.ex_04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_014_Delete {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String bookingId="1008";
    String token="359697ee76c64cd";

    @Test
    public void test_Delete()
    {
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.cookie("token",token);

        response=r.when().delete();

        vr=response.then().log().all();

    }

}
