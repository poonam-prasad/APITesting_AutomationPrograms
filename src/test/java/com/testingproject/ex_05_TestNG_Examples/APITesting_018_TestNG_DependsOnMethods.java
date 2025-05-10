package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting_018_TestNG_DependsOnMethods {

    @Test
    public void test_ServerStarted(){
        System.out.println("Server started OK");
    }

    @Test(dependsOnMethods = "test_ServerStarted")
    public void test_Test1(){
        System.out.println("Test1");
    }

    @Test(dependsOnMethods = "test_ServerStarted")
    public void test_Test2(){
        System.out.println("Test2");
    }

}
