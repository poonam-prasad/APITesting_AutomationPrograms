package com.testingproject.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_013_Patch {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String token="114daa77cc5be88";
    String bookingID="1";
    String requestPayload="{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";

    @Test
    public void test_PatchRequest(){
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/:"+bookingID);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(requestPayload);

        response=r.when().patch();

        vr=response.then().log().all().statusCode(200);


    }
}
