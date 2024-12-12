package com.ps.CustomerMiyagi.Controllers;

import com.ps.CustomerMiyagi.data.CustomerDao;
import com.ps.CustomerMiyagi.data.ProductDao;
import com.ps.CustomerMiyagi.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private ProductDao dao;
    // get one
    @GetMapping("{id}")
    public Product findOneProduct(int id) {

        return dao.findOneProduct(id);
    }

    // get all
    @GetMapping
    public List<Product> findAllProducts(
            // recieving a query String (url that include /?name=greg which are methods to pass data in a request
            @RequestParam(required = false) String name,
            //sort by price
            @RequestParam(required = false) String sort, //price sort, name and order are keys
            // order desc or asc
            @RequestParam(required = false) String order
            ){
        System.out.println("Get All Products was triggered " +  name + " " + sort + " " + order);

        return dao.findAllProducts(sort);
    }

    //create
    @PostMapping("{id}")
    public Product createProduct(Product product){
        return dao.createProduct(product);
    }


    // update
    @PutMapping("{id}")
    public void updateProduct(int id, Product product){
          dao.updateProduct(id, product);
    }

    //delete
    @DeleteMapping("{id}")
    public void deleteAProduct(@PathVariable int id) {
        dao.deleteAProduct(id);
    }
}
