package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class APITesting_017_TestNG_Groups {

    @Test(groups = {"reg","sanity"})
    public void test_RegressionRun(){
        System.out.println("Regression");
        System.out.println("Sanity");
    }

    @Test(groups = {"sanity"})
    public void test_SanityRun(){
        System.out.println("Sanity");
    }

    @Test(groups = {"smoke","reg"})
    public void test_SmokeRun(){
        System.out.println("Smoke");
        System.out.println("Regression");
    }


}
