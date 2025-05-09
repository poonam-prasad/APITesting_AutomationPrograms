package com.testingproject.ex_02_RA_Concepts;

 class Lab03_NoPattern {
    public static void main(String[] args) {
        Lab03_NoPattern building = new Lab03_NoPattern();
        building.step1();
        building.step2();
        building.step3("building Completed");
    }

    public void step1() {
        System.out.println("Step 1");
    }

    public void step2() {
        System.out.println("Step 2");
    }

    public void step3(String buildingFloor) {
        System.out.println("Step3");
    }
}







