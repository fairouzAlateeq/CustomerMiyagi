package com.ps.CustomerMiyagi.Controllers;

import com.ps.CustomerMiyagi.data.CustomerDao;
import com.ps.CustomerMiyagi.models.Customer;
import com.ps.CustomerMiyagi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
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

    @GetMapping("{id}")
    public Customer getOneCustomer(@PathVariable int id){
        return dao.findOneCustomer(id);
    }
    // to listen to get requests
    @GetMapping  //this is an end point to retrieve from customers db
    public List<Customer> getAllCustomers(){
       return dao.findAll();
    }
    // new listener for create
    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer){
        return dao.createCustomer(customer);
    }

    @PutMapping("{id}")
    public void putCustomer(@PathVariable int id, @RequestBody Customer customer){
        dao.updateCustomer(id, customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id, @RequestBody Customer customer) {

    }
}



