package com.testingproject.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class APITesting_012_Put_NonBDD {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String bookingID="1";
    String token="d2d839bca4595ab";

    String requestPayload="{\n" +
            "    \"firstname\" : \"Poonam\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Test
    public void test_PutRequest(){
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingID);
        r.contentType(ContentType.JSON);

        r.cookie("token",token);
        r.body(requestPayload);

        response=r.when().log().all().put();

        vr=response.then().log().all().statusCode(200);

    }

}
