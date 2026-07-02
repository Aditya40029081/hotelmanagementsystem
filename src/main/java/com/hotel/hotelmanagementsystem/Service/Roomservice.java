package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Dto.Roomrequestdto;
import com.hotel.hotelmanagementsystem.Entity.Room;

import java.util.List;

public interface Roomservice {
    Room addRoom(Roomrequestdto roomrequestdto);

    List<Room> getAllRooms();

    Room getRoombyid(Long id);

    void deleteroom(Long id);

    Room updateroom(Long id, Roomrequestdto roomrequestdto);

    List<Room> getavailablerooms();
}
