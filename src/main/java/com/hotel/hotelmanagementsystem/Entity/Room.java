package com.hotel.hotelmanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomnumber;

    private String roomtype;

    private Double pricepernight;

    private boolean available;

}
