package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Entity.Room;

import java.util.List;

public interface Roomservice {
    Room addRoom(Room room);

    List<Room> getAllRooms();

    Room getRoombyid(Long id);

    void deleteroom(Long id);

    Room updateroom(Long id,Room room);

    List<Room> getavailablerooms();
}
