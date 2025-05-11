package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting_020_TestNG_Enabled {

    @Test(enabled=true)
    public void test_register()
    {
        System.out.println("Registration working");
    }

    @Test(enabled=true)
    public void test_login_positive()
    {
        System.out.println("Login works with valid data");
    }

    @Test(enabled=false)
    public void test_login_negative()
    {
        System.out.println("Login should not work with Invalid data");
    }

}
