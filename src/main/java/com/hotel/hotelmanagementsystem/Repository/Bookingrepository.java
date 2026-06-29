package com.hotel.hotelmanagementsystem.Repository;

import com.hotel.hotelmanagementsystem.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface Bookingrepository extends JpaRepository<Booking,Long> {

}
