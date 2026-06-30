package com.hotel.hotelmanagementsystem.Repository;

import com.hotel.hotelmanagementsystem.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Roomrepository extends JpaRepository<Room,Long> {
    List<Room> findByAvailableTrue();
}
