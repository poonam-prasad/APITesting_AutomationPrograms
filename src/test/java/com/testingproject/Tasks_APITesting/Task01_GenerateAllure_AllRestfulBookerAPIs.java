package com.testingproject.Tasks_APITesting;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.build.Plugin;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task01_GenerateAllure_AllRestfulBookerAPIs {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC01_Verify GET request for HealthCheck API")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Poonam")
    @Test(priority = 1)
    public void getHealthCheckAPI(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/ping");

        response=requestSpecification.when().log().all().get();

        validatableResponse=response.then().log().all().statusCode(201);


    }

    @Description("TC02_Verify if POST request for Create Token API providing the token")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Poonam")
    @Test(priority = 2)
    public void postCreateToken(){

        String requestPayload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.body(requestPayload);
        requestSpecification.contentType(ContentType.JSON);

        response=requestSpecification.when().log().all().post();
        validatableResponse=response.then().log().all().statusCode(200);
        //Assert.assertEquals(validatableResponse.statusCode(200),200);

    }

    @Description("TC03_Verify if POST request for Create Booking is working and booking gets created")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Poonam")
    @Test(priority = 3)
    public void postCreateTokenLatest(){

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
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(requestPayload).log().all();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        response=requestSpecification.when().log().all().post();
        validatableResponse=response.then().log().all().statusCode(200);

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Poonam"));

    }

    @Description("TC04_Verify if GET request for GetBooking API is working")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Poonam")
    @Test(priority = 4)
    public void getBookingDetails(){
        String bookingID="108";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.accept(ContentType.JSON);

        response=requestSpecification.when().log().all().get();
        validatableResponse=response.then().log().all().statusCode(200);
    }

    @Description("TC05_Verify if GET request for GetBookingIds API is working")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Poonam")
    @Test(priority = 5)
    public void getBookingIds(){

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/");
        requestSpecification.accept(ContentType.JSON);

        response=requestSpecification.when().log().all().get();
        validatableResponse=response.then().log().all().statusCode(200);
    }

    @Description("TC06_Verify if PUT request for UpdateBooking API is working")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Poonam")
    @Test(priority = 6)
    public void putUpdateBooking(){

        String bookingID="108";
        String token="3a6bb3f606eef27";
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
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        response=requestSpecification.when().log().all().put();
        validatableResponse=response.then().log().all().statusCode(200);

    }

    @Description("TC07_Verify if Patch request for PartialUpdateBooking API is working")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Poonam")
    @Test(priority = 7)
    public void PatchUpdateBooking(){

        String bookingID="108";
        String token="3a6bb3f606eef27";
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
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        response=requestSpecification.when().log().all().patch();
        validatableResponse=response.then().log().all().statusCode(200);

    }
    @Description("TC08_Verify if Delete request for DeleteBooking API is deleting record")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Poonam")
    @Test(priority = 8)
    public void testDeleteBooking(){

        String bookingID="103";
        String token="3a6bb3f606eef27";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        response=requestSpecification.when().log().all().delete();
        validatableResponse=response.then().log().all().statusCode(201);

    }

}
