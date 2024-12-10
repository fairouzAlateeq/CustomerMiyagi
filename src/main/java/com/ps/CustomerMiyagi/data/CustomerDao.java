package com.ps.CustomerMiyagi.data;

import com.ps.CustomerMiyagi.models.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findAll();
    public Customer findOneCustomer(int id);
}
