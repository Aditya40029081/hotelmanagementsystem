package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Dto.Bookingrequstdto;
import com.hotel.hotelmanagementsystem.Entity.Booking;

import java.util.List;

public interface Bookingservice {
    Booking addbooking(Bookingrequstdto bookingrequstdto);

    List<Booking> getallbookings();

    Booking getbookingbyid(Long id);

    void deletebooking(Long id);

    Booking updatebooking(Long id,Bookingrequstdto bookingrequstdto);
}
