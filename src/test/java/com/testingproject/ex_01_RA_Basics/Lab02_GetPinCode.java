package com.testingproject.ex_01_RA_Basics;
import io.restassured.RestAssured;

import java.util.Scanner;

public class Lab02_GetPinCode {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter pin code");
        String pincode=scn.next();

        RestAssured.given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("pincode/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);

    }
}
