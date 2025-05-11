package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.*;

import javax.crypto.spec.PSource;

public class APITesting_023_TestNG_Annotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void test(){
        System.out.println("I am test case");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }



}
