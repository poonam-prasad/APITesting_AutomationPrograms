package com.testingproject.ex_06_RestAssuredAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting_027_TestNG_AssertJ_Assertions_Extraction {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String requestPayload="{\n" +
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

    @Test
    public void extractionsTestNG(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(requestPayload).log().all();

        response=requestSpecification.when().post();

        validatableResponse=response.then().log().all().statusCode(200);

        //RestAssured assertion
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Poonam"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));

        //TestNG Assertions using Extractions
        int bookingId=response.then().extract().path("bookingid");
        String firstName=response.then().extract().path("booking.firstname");
        String lastName=response.then().extract().path("booking.lastname");

        Assert.assertEquals(firstName,"Poonam");
        Assert.assertEquals(lastName,"QA");
        Assert.assertNotNull(bookingId);

        //AsserJ Assertions using Extraction

        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstName).isEqualTo("Poonam").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();

    }

}
