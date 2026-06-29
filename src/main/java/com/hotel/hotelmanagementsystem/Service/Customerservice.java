package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Entity.Customer;

import java.util.List;

public interface Customerservice {
    Customer addcustomer(Customer customer);

    List<Customer> getallcustomer();

    Customer getcustomerbyid(Long id);

    Customer updatecustomer(Long id,Customer customer);

    void deletecustomer(Long id);
}
