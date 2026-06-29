package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Entity.Booking;

import java.util.List;

public interface Bookingservice {
    Booking addbooking(Booking booking);

    List<Booking> getallbookings();

    Booking getbookingbyid(Long id);

    void deletebooking(Long id);
}
