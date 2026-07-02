package com.hotel.hotelmanagementsystem.Controller;


import com.hotel.hotelmanagementsystem.Dto.Bookingrequstdto;
import com.hotel.hotelmanagementsystem.Entity.Booking;
import com.hotel.hotelmanagementsystem.Service.Bookingservice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RequestMapping("/api/bookings")
@RestController

public class Bookingcontroller {
    private final Bookingservice bookingservice;

    public Bookingcontroller(Bookingservice bookingservice) {
        this.bookingservice = bookingservice;
    }

    @PostMapping
    public Booking addbooking(@Valid  @RequestBody Bookingrequstdto bookingrequestdto){
        return bookingservice.addbooking(bookingrequestdto);
    }

    @GetMapping
    public List<Booking> getallbookings(){
        return bookingservice.getallbookings();
    }

    @GetMapping("/{id}")
    public Booking getbookingbyid(@PathVariable Long id){
        return bookingservice.getbookingbyid(id);
    }

    @DeleteMapping("{id}")
    public void deletebooking(@PathVariable Long id){
        bookingservice.deletebooking(id);
        
    }

    @PutMapping("/{id}")
    public Booking updatebooking(@PathVariable Long id,@Valid @RequestBody Bookingrequstdto bookingrequstdto){ return bookingservice.updatebooking(id,bookingrequstdto);
    }
}
