package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting_021_TestNG_AlwaysRun {

    @Test(alwaysRun = true)
    public void test_register()
    {
        System.out.println("Registration working");
    }

    @Test(alwaysRun = false)
    public void test_login_positive()
    {
        System.out.println("Login works with valid data");
    }

    @Test(alwaysRun = true, enabled = false)
    public void test_login_negative()
    {
        System.out.println("Login should not work with Invalid data");
    }
}
