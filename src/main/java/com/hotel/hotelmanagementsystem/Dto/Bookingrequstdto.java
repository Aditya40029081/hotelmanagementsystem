package com.hotel.hotelmanagementsystem.Dto;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookingrequstdto {
    @NotNull(message = "Check-in date is required")
    @FutureOrPresent(message = "Check-in date cannot be in the past")
    private LocalDate checkindate;

    @NotNull(message = "Check-out date is required")
    @FutureOrPresent(message = "Check-out date cannot be in the past")
    private LocalDate checkoutdate;

    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be greater than zero")
    private Double totalamount;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Room ID is required")
    private Long roomId;
}
