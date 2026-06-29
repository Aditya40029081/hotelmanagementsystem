package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Entity.Booking;
import com.hotel.hotelmanagementsystem.Repository.Bookingrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookingserviceimpl implements Bookingservice{

    private final Bookingrepository bookingrepository;

    public Bookingserviceimpl(Bookingrepository bookingrepository) {
        this.bookingrepository = bookingrepository;
    }

    @Override
    public Booking addbooking(Booking booking) {
        return bookingrepository.save(booking);
    }

    @Override
    public List<Booking> getallbookings() {
        return bookingrepository.findAll();
    }

    @Override
    public Booking getbookingbyid(Long id) {
        return bookingrepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public void deletebooking(Long id) {
        bookingrepository.deleteById(id);
    }
}
