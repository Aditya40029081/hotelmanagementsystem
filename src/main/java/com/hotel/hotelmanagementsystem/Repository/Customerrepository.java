package com.hotel.hotelmanagementsystem.Repository;

import com.hotel.hotelmanagementsystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customerrepository extends JpaRepository<Customer,Long> {

}
