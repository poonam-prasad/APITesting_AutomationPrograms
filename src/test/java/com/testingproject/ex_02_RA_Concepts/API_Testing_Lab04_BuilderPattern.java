package com.testingproject.ex_02_RA_Concepts;

public class API_Testing_Lab04_BuilderPattern {

    public API_Testing_Lab04_BuilderPattern step1(){
        System.out.println("Step 1");
        return this;
    }

    public API_Testing_Lab04_BuilderPattern step2(){
        System.out.println("Step 2");
        return this;
    }

    public API_Testing_Lab04_BuilderPattern step3(String buildingNo){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        API_Testing_Lab04_BuilderPattern bp=new API_Testing_Lab04_BuilderPattern();
        bp.step1().step2().step3("buildingComplete");
    }


}
