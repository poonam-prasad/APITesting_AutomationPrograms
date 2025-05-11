package com.testingproject.ex_06_RestAssuredAssertions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class APITesting_025_RestAssuredAssertion {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String requestPayload = "{\n" +
            "    \"firstname\" : \"Poonam\",\n" +
            "    \"lastname\" : \"QA\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    @Owner("Poonam Prasad")
    @Severity(SeverityLevel.CRITICAL)
@Description("Verify if POST API for Create Booking working fine & Booking id is not Null ")

    @Test
    public void testRestAssuredAssertion() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(requestPayload).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body(" booking.firstname", Matchers.equalTo("Poonam"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("QA"));
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));

    }
}
