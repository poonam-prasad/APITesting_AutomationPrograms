package com.testingproject.ex_07_PayloadManagement.Classes.Manual.ResponsePayload;

import com.testingproject.ex_07_PayloadManagement.Classes.Manual.RequestPayload.Booking;

public class BookingResponse {
    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    private Integer bookingid;
    private Booking booking;
}
