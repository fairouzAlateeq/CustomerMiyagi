package com.ps.CustomerMiyagi.Controllers;

import com.ps.CustomerMiyagi.data.CustomerDao;
import com.ps.CustomerMiyagi.models.Customer;
import com.ps.CustomerMiyagi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {

    private CustomerDao dao;

    @Autowired
    public CustomerController(CustomerDao dao){
        this.dao = dao;
    }
//    } this is how we make an active line between controller and service to access methods
//    private CustomerService customerService;
//
//    @Autowired
//    public CustomerController(CustomerService customerService){
//        this.customerService = customerService;
//    }

    // to listen to get requests
    @GetMapping ("/api/customers")  //this is an end point to retrieve from customers db
    public List<Customer> getAllCustomers(){

       return dao.findAll();

    }

}



