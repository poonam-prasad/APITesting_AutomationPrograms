package com.testingproject.ex_07_PayloadManagement.Classes.Manual.RequestPayload;

public class Booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    private Boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingdates;

    public String getfirstname(){
        return firstname;
    }

    public void setfirstname(String firstname)
    {
        this.firstname=firstname;
    }

    public String getlastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public Integer gettotalprice(){
        return totalprice;
    }

    public void settotalprice(Integer totalprice){
        this.totalprice=totalprice;
    }


}
