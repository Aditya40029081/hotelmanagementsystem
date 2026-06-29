package com.hotel.hotelmanagementsystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="Bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkindate;

    private LocalDate checkoutdate;

    private Double totalamount;

    @ManyToOne
    @JoinColumn(name="customer-id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="room-id")
    private Room room;


}
