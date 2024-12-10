package com.ps.CustomerMiyagi.data;

import com.ps.CustomerMiyagi.models.Customer;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductDao {
    List<Customer> findAllProducts();
    Customer findOneProduct(int id);
    Customer createProduct(Customer customer);
    void updateProduct(int id, Customer customer);
    void deleteAProduct(@PathVariable int id);
}
