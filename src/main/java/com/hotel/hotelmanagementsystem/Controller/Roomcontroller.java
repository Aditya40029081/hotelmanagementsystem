package com.hotel.hotelmanagementsystem.Controller;


import com.hotel.hotelmanagementsystem.Dto.Roomrequestdto;
import com.hotel.hotelmanagementsystem.Entity.Room;
import com.hotel.hotelmanagementsystem.Service.Roomservice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Valid
@RequestMapping("/api/rooms")

public class Roomcontroller {
    private final Roomservice roomservice;

    public Roomcontroller(Roomservice roomservice) {
        this.roomservice = roomservice;
    }
    @PostMapping
    public Room addroom(@Valid @RequestBody Roomrequestdto roomrequestdto){
        return roomservice.addRoom(roomrequestdto);
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
    public Room updateroom(@PathVariable Long id,@Valid @RequestBody Roomrequestdto roomrequestdto){
        return roomservice.updateroom(id,roomrequestdto);
    }
    @GetMapping("/available")
    public List<Room> getavailablerooms(){
        return roomservice.getavailablerooms();
    }
}
