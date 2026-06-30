package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Entity.Booking;
import com.hotel.hotelmanagementsystem.Entity.Room;
import com.hotel.hotelmanagementsystem.Exception.BookingNotFoundException;
import com.hotel.hotelmanagementsystem.Repository.Bookingrepository;
import com.hotel.hotelmanagementsystem.Repository.Roomrepository;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookingserviceimpl implements Bookingservice{

    private final Bookingrepository bookingrepository;
    private final Roomrepository roomrepository;

    public Bookingserviceimpl(Bookingrepository bookingrepository, Roomrepository roomrepository) {
        this.bookingrepository = bookingrepository;
        this.roomrepository = roomrepository;

    }


    @Override
    public Booking addbooking(Booking booking) {
        Room room=roomrepository.findById(booking.getRoom().getId()).orElseThrow(()-> new RuntimeException("room not found"));

        if(!room.isAvailable()){
            throw new RuntimeException("room is already booked");
        }
        room.setAvailable(false);
        roomrepository.save(room);

        long days=ChronoUnit.DAYS.between(booking.getCheckindate(),booking.getCheckoutdate());
        double total=days*room.getPricepernight();
        booking.setTotalamount(total);

        return bookingrepository.save(booking);
    }

    @Override
    public List<Booking> getallbookings() {
        return bookingrepository.findAll();
    }

    @Override
    public Booking getbookingbyid(Long id) {
        return bookingrepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found"));
    }

    @Override
    public void deletebooking(Long id) {
        Booking booking=bookingrepository.findById(id).orElseThrow(()->new RuntimeException("booking not found"));
        Room room=booking.getRoom();
        room.setAvailable(true);
        roomrepository.save(room);
        bookingrepository.delete(booking);

    }

}
