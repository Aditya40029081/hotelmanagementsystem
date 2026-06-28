package com.hotel.hotelmanagementsystem.Repository;

import com.hotel.hotelmanagementsystem.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Roomrepository extends JpaRepository<Room,Long> {
    
}
