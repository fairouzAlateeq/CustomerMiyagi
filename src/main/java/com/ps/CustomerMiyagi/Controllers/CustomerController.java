package com.ps.CustomerMiyagi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    // to listen to get requests
    @GetMapping ("/api/customers")  //this is an end point to retrieve from customers db
    public String getAllCustomers(){
        return "Hello world";

    }

}



