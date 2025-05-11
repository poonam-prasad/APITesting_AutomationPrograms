package com.testingproject.ex_07_PayloadManagement.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_029_Payload_HashMap {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    String bookingId;

    @Test
    public void test_hashMapPayload(){
        Map<String,Object> jsonBodyUsingMap=new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Poonam");
        jsonBodyUsingMap.put("lastname","QA");
        jsonBodyUsingMap.put("totalprice",111);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String,Object> bookingDates=new LinkedHashMap<>();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDates);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonBodyUsingMap).log().all();

        response=r.when().post();

        vr=response.then().statusCode(200);
        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("Poonam"));

    }

}
