package com.testingproject.ex_01_RA_Basics;

import io.restassured.RestAssured;

public class Lab01_RestfulBookerPing {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().log().all().statusCode(201);
    }
}
