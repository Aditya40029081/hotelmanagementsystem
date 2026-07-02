package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Dto.Roomrequestdto;
import com.hotel.hotelmanagementsystem.Entity.Room;
import com.hotel.hotelmanagementsystem.Exception.Globalexceptionhandler;
import com.hotel.hotelmanagementsystem.Repository.Roomrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.hotelmanagementsystem.Exception.RoomNotFoundException;
import java.util.List;

@Service
public class Roomserviceimpl implements Roomservice {

    private final Roomrepository roomrepository;

    public Roomserviceimpl(Roomrepository roomrepository) {
        this.roomrepository = roomrepository;
    }

    @Override
    public Room addRoom(Roomrequestdto roomrequestdto) {
        Room room=new Room();
        room.setRoomnumber(roomrequestdto.getRoomnumber());
        room.setRoomtype(roomrequestdto.getRoomtype());
        room.setPricepernight(roomrequestdto.getPricepernight());
        room.setAvailable(roomrequestdto.getAvailable());
        return roomrepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomrepository.findAll();
    }

    @Override
    public Room getRoombyid(Long id) {
        return roomrepository.findById(id).orElseThrow(()->new RoomNotFoundException("room not found"));
    }

    @Override
    public void deleteroom(Long id) {
        roomrepository.deleteById(id);
    }
    @Override
    public Room updateroom(Long id, Roomrequestdto roomrequestdto) {
        Room existingroom = roomrepository.findById(id).orElseThrow(() -> new RuntimeException("room not found"));
        existingroom.setRoomnumber(roomrequestdto.getRoomnumber());
        existingroom.setRoomtype(roomrequestdto.getRoomtype());
        existingroom.setPricepernight(roomrequestdto.getPricepernight());
        existingroom.setAvailable(roomrequestdto.getAvailable());

        return roomrepository.save(existingroom);
    }

    @Override
    public List<Room> getavailablerooms() {
        return roomrepository.findByAvailableTrue();
    }
}
