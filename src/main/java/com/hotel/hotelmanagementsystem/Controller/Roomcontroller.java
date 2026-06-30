package com.hotel.hotelmanagementsystem.Controller;


import com.hotel.hotelmanagementsystem.Entity.Room;
import com.hotel.hotelmanagementsystem.Service.Roomservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")

public class Roomcontroller {
    private final Roomservice roomservice;

    public Roomcontroller(Roomservice roomservice) {
        this.roomservice = roomservice;
    }
    @PostMapping
    public Room addroom(@RequestBody Room room){
        return roomservice.addRoom(room);
    }
    @GetMapping
    public List<Room> getallrooms(){
        return roomservice.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getroombyid(@PathVariable Long id){
        return roomservice.getRoombyid(id);
    }
    @DeleteMapping("/{id}")
    public void deleteroom(@PathVariable Long id){
        roomservice.deleteroom(id);
    }

    @PutMapping("/{id}")
    public Room updateroom(@PathVariable Long id,@RequestBody Room room){
        return roomservice.updateroom(id,room);
    }
    @GetMapping("/available")
    public List<Room> getavailablerooms(){
        return roomservice.getavailablerooms();
    }
}
