package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_016_BeforeTest_AfterTest {

    @BeforeTest
    public void getBookingId(){
        System.out.println("Get BookingId");
    }

    @BeforeTest
    public void getToken(){
        System.out.println("Get Token details");
    }

    @Test
    public void putRequest(){
        System.out.println("PUT Request");
    }

    @AfterTest
    public void closeAll(){
        System.out.println("Close everything");
    }
}
