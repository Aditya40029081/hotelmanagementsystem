package com.hotel.hotelmanagementsystem.Controller;


import com.hotel.hotelmanagementsystem.Dto.Customerrequestdto;
import com.hotel.hotelmanagementsystem.Entity.Customer;
import com.hotel.hotelmanagementsystem.Service.Customerservice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Valid
@RestController
@RequestMapping("/api/customers")
public class Customercontroller {
    private final Customerservice customerservice;


    public Customercontroller(Customerservice customerservice) {
        this.customerservice = customerservice;
    }

    @PostMapping
    public Customer addcustomer(@Valid @RequestBody Customerrequestdto customerrequestdto){
        return customerservice.addcustomer(customerrequestdto);
    }

    @GetMapping
    public List<Customer> getallcustomer(){
        return customerservice.getallcustomer();
    }

    @GetMapping("/{id}")
    public Customer getcustomerbyid(@PathVariable Long id){
        return customerservice.getcustomerbyid(id);
    }

    @PutMapping("/{id}")
    public Customer updatecustomer(@PathVariable Long id, @Valid @RequestBody Customerrequestdto customerrequestdto){
        return customerservice.updatecustomer(id,customerrequestdto);
    }

    @DeleteMapping("/{id}")
    public void  deletecustomer(@PathVariable Long id) {
        customerservice.deletecustomer(id);

    }
}
