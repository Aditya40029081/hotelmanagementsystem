package com.hotel.hotelmanagementsystem.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roomrequestdto {
    @NotBlank(message = "room number is required")
    private String roomnumber;
    @NotBlank(message = "roomtype is required")
    private String roomtype;
    @NotNull(message = "price per night is required")
    @Positive(message = "price per night must be greater than zero")
    private Double pricepernight;
    @NotNull(message = "availability is required")
    private Boolean available;
}
