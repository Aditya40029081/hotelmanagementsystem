package com.hotel.hotelmanagementsystem.Service;


import com.hotel.hotelmanagementsystem.Entity.Customer;
import com.hotel.hotelmanagementsystem.Repository.Customerrepository;
import org.springframework.stereotype.Service;

import javax.smartcardio.CardTerminal;
import java.util.List;

@Service
public class Customerserviceimpl implements Customerservice{
    private final Customerrepository customerrepository;

    public Customerserviceimpl(Customerrepository customerrepository) {
        this.customerrepository = customerrepository;
    }


    @Override
    public Customer addcustomer(Customer customer) {
        return customerrepository.save(customer);
    }

    @Override
    public List<Customer> getallcustomer() {
        return customerrepository.findAll();
    }

    @Override
    public Customer getcustomerbyid(Long id) {
        return customerrepository.findById(id).orElse(null);
    }

    @Override
    public Customer updatecustomer(Long id,Customer customer) {
        Customer existingcustomer=customerrepository.findById(id).orElseThrow(() -> new RuntimeException("customer not found"));
        existingcustomer.setName(customer.getName());
        existingcustomer.setEmail(customer.getEmail());
        existingcustomer.setPhone(customer.getPhone());
        existingcustomer.setAddress(customer.getAddress());

        return customerrepository.save(existingcustomer);

    }

    @Override
    public void deletecustomer(Long id) {

    customerrepository.deleteById(id);
    }
}
