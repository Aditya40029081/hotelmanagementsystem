package com.hotel.hotelmanagementsystem.Controller;


import com.hotel.hotelmanagementsystem.Entity.Customer;
import com.hotel.hotelmanagementsystem.Service.Customerservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class Customercontroller {
    private final Customerservice customerservice;


    public Customercontroller(Customerservice customerservice) {
        this.customerservice = customerservice;
    }

    @PostMapping
    public Customer addcustomer(@RequestBody Customer customer){
        return customerservice.addcustomer(customer);
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
    public Customer updatecustomer(@PathVariable Long id,@RequestBody Customer customer){
        return customerservice.updatecustomer(id,customer);
    }

    @DeleteMapping("/{id}")
    public void  deletecustomer(@PathVariable Long id) {
        customerservice.deletecustomer(id);

    }
}
