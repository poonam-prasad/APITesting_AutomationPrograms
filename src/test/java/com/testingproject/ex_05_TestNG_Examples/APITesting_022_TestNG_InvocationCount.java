package com.testingproject.ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting_022_TestNG_InvocationCount {

    @Test(invocationCount = 3)
    public void testHello(){
        System.out.println("Hello");
    }

    @Test(invocationCount = 2)
    public void testBye(){
        System.out.println("Bye");
    }

    @Test
    public void testMorning(){
        System.out.println("Good Morning");
    }
}
