package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_019_TestNG_Parameters {

    @Parameters("browser")
    @Test
    public void test_Parameters(String value){
        System.out.println("Started execution");
        System.out.println("You are using this browser");

        if(value.equalsIgnoreCase("Chrome"))
        {
            System.out.println("Starting browser "+value);
        }

        else if(value.equalsIgnoreCase("Firefox"))
        {
            System.out.println("Start browser "+value);
        }
    }
}
