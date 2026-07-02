package com.hotel.hotelmanagementsystem.Service;

import com.hotel.hotelmanagementsystem.Dto.Customerrequestdto;
import com.hotel.hotelmanagementsystem.Entity.Customer;

import java.util.List;

public interface Customerservice {
    Customer addcustomer(Customerrequestdto customerrequestdto);

    List<Customer> getallcustomer();

    Customer getcustomerbyid(Long id);

    Customer updatecustomer(Long id,Customerrequestdto customerrequestdto);

    void deletecustomer(Long id);
}
