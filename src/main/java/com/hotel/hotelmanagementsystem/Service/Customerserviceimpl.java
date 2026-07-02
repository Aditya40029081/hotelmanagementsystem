package com.hotel.hotelmanagementsystem.Service;


import com.hotel.hotelmanagementsystem.Dto.Customerrequestdto;
import com.hotel.hotelmanagementsystem.Entity.Customer;
import com.hotel.hotelmanagementsystem.Exception.CustomerNotFoundException;
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
    public Customer addcustomer(Customerrequestdto customerrequestdto) {

        Customer customer = new Customer();

        customer.setName(customerrequestdto.getName());
        customer.setEmail(customerrequestdto.getEmail());
        customer.setPhone(customerrequestdto.getPhone());
        customer.setAddress(customerrequestdto.getAddress());

        return customerrepository.save(customer);
    }

    @Override
    public List<Customer> getallcustomer() {
        return customerrepository.findAll();
    }

    @Override
    public Customer getcustomerbyid(Long id) {
        return customerrepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found"));
    }

    @Override
    public Customer updatecustomer(Long id,Customerrequestdto customerrequestdto) {
        Customer existingcustomer=customerrepository.findById(id).orElseThrow(() -> new RuntimeException("customer not found"));
        existingcustomer.setName(customerrequestdto.getName());
        existingcustomer.setEmail(customerrequestdto.getEmail());
        existingcustomer.setPhone(customerrequestdto.getPhone());
        existingcustomer.setAddress(customerrequestdto.getAddress());

        return customerrepository.save(existingcustomer);

    }

    @Override
    public void deletecustomer(Long id) {

    customerrepository.deleteById(id);
    }
}
