package com.testingproject.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class APITesting_009_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String pinCode;

    @Test
    public void test_PositiveGetRequest()
    {
        pinCode="567893";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pinCode);

        response=r.when().log().all().get();
        System.out.println(response.toString());

        vr=response.then().log().all();
        vr.statusCode(404);
    }
@Test
    public void test_NegativeGetRequest()
    {   pinCode="@";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pinCode);

        response=r.when().log().all().get();
        System.out.println(response.toString());

        vr=response.then().log().all();
        vr.statusCode(404);
    }
}
