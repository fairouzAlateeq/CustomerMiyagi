package com.ps.CustomerMiyagi.data;

import com.ps.CustomerMiyagi.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProducts(String name, String sort, String order);
    Product findOneProduct(int id);
    Product createProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteAProduct(@PathVariable int id);
}
