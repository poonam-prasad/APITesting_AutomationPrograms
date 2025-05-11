package com.testingproject.ex_06_RestAssuredAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_026_TestNGAssertion {

    @Test(enabled = false)
    public void hardAssertion()
    {
        System.out.println("Start of program");
        Assert.assertEquals("poonam","Poonam");
        System.out.println("End of Program");
    }

    @Test
    public void test_softAssertion()
    {
        System.out.println("Start of program");

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("poonam","Poonam");
        System.out.println("End of Program");
        softAssert.assertAll();
    }
}
