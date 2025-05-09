package com.testingproject.ex_02_RA_Concepts;

import io.restassured.RestAssured;

public class API_Testing_Lab05_Multiple_APITests {
    public static void main(String[] args) {

        String pinCode="560001";
        RestAssured.given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("pincode/"+pinCode)
                .when().get()
                .then().log().all().statusCode(200);

         pinCode="12345";
        RestAssured.given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("pincode/"+pinCode)
                .when().get()
                .then().log().all().statusCode(200);

         pinCode=" ";
        RestAssured.given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("pincode/"+pinCode)
                .when().get()
                .then().log().all().statusCode(200);
    }
}
