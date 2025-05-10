package com.testingproject.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab008_GET_BDD_Style {

    @Test
    public void testPinCode(){
        String pinCode="388620";

        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/" + pinCode)
                .when().log().all().get()
                .then().log().all().statusCode(200);


    }

}
