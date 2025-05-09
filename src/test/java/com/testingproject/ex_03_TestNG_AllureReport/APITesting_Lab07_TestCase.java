package com.testingproject.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab07_TestCase {
    String pinCode;
    @Test
    public void test01Positive() {
         pinCode = "560001";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().get()
                .then().log().all().statusCode(200);

    }

    @Test
    public void test02Negative() {
        pinCode="@";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test03Negative() {
        pinCode=" ";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().get()
                .then().log().all().statusCode(200);
    }
}