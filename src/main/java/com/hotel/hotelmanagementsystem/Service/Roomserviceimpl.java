package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Entity.Room;
import com.hotel.hotelmanagementsystem.Repository.Roomrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Roomserviceimpl implements Roomservice {

    private final Roomrepository roomrepository;

    public Roomserviceimpl(Roomrepository roomrepository) {
        this.roomrepository = roomrepository;
    }

    @Override
    public Room addRoom(Room room) {
        return roomrepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomrepository.findAll();
    }

    @Override
    public Room getRoombyid(Long id) {
        return roomrepository.findById(id).orElse(null);
    }

    @Override
    public void deleteroom(Long id) {
        roomrepository.deleteById(id);
    }
    @Override
    public Room updateroom(Long id,Room room) {
        Room existingroom = roomrepository.findById(id).orElseThrow(() -> new RuntimeException("room not found"));
        existingroom.setRoomnumber(room.getRoomnumber());
        existingroom.setRoomtype(room.getRoomtype());
        existingroom.setPricepernight(room.getPricepernight());
        existingroom.setAvailable(room.isAvailable());

        return roomrepository.save(existingroom);
    }
}
