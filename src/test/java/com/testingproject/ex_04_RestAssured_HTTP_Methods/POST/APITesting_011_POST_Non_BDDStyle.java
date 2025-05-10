package com.testingproject.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_011_POST_Non_BDDStyle {

RequestSpecification r;
Response response;
ValidatableResponse vr;
    String requestPayload="{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";


    @Test
public void test_POST_NonBDDStyle(){
    r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/auth");
            r.contentType(ContentType.JSON);
            r.body(requestPayload);


    response=r.when().log().all().post();

    vr=response.then().log().all().statusCode(200);


}

}
