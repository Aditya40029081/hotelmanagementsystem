package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Dto.Bookingrequstdto;
import com.hotel.hotelmanagementsystem.Entity.Booking;
import com.hotel.hotelmanagementsystem.Entity.Customer;
import com.hotel.hotelmanagementsystem.Entity.Room;
import com.hotel.hotelmanagementsystem.Exception.BookingNotFoundException;
import com.hotel.hotelmanagementsystem.Exception.CustomerNotFoundException;
import com.hotel.hotelmanagementsystem.Exception.RoomNotFoundException;
import com.hotel.hotelmanagementsystem.Repository.Bookingrepository;
import com.hotel.hotelmanagementsystem.Repository.Customerrepository;
import com.hotel.hotelmanagementsystem.Repository.Roomrepository;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookingserviceimpl implements Bookingservice {

    private final Bookingrepository bookingrepository;
    private final Roomrepository roomrepository;
    private final Customerrepository customerrepository;

    public Bookingserviceimpl(Bookingrepository bookingrepository, Roomrepository roomrepository,
                              Customerrepository customerrepository) {
        this.bookingrepository = bookingrepository;
        this.roomrepository = roomrepository;

        this.customerrepository = customerrepository;
    }


    @Override
    public Booking addbooking(Bookingrequstdto bookingrequestdto) {
        Room room = roomrepository.findById(bookingrequestdto.getRoomId()).orElseThrow(() -> new RoomNotFoundException("room not found with id:" + bookingrequestdto.getRoomId()));

        Customer customer = customerrepository.findById(bookingrequestdto.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with id : "
                                + bookingrequestdto.getCustomerId()));
        if (!room.getAvailable()) {
            throw new RuntimeException("room is already booked");
        }
        room.setAvailable(false);
        roomrepository.save(room);

        long days = ChronoUnit.DAYS.between(bookingrequestdto.getCheckindate(), bookingrequestdto.getCheckoutdate());
        double total = days * room.getPricepernight();

        Booking booking = new Booking();

        booking.setCheckindate(bookingrequestdto.getCheckindate());
        booking.setCheckoutdate(bookingrequestdto.getCheckoutdate());
        booking.setTotalamount(total);
        booking.setCustomer(customer);
        booking.setRoom(room);

        room.setAvailable(false);
        roomrepository.save(room);

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
    @Override
    public Booking updatebooking(Long id, Bookingrequstdto bookingrequstdto) {

        Booking booking = bookingrepository.findById(id)
                .orElseThrow(() ->
                        new BookingNotFoundException("Booking not found with id : " + id));

        Customer customer = customerrepository.findById(bookingrequstdto.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found with id : " + bookingrequstdto.getCustomerId()));

        Room room = roomrepository.findById(bookingrequstdto.getRoomId())
                .orElseThrow(() ->
                        new RoomNotFoundException(
                                "Room not found with id : " + bookingrequstdto.getRoomId()));

        if (!bookingrequstdto.getCheckoutdate()
                .isAfter(bookingrequstdto.getCheckindate())) {

            throw new RuntimeException("Check-out date must be after check-in date");
        }

        long days = ChronoUnit.DAYS.between(
                bookingrequstdto.getCheckindate(),
                bookingrequstdto.getCheckoutdate());

        double total = days * room.getPricepernight();

        booking.setCheckindate(bookingrequstdto.getCheckindate());
        booking.setCheckoutdate(bookingrequstdto.getCheckoutdate());
        booking.setTotalamount(total);
        booking.setCustomer(customer);
        booking.setRoom(room);

        return bookingrepository.save(booking);
    }
}
