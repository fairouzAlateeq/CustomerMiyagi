package com.ps.CustomerMiyagi.Controllers;

import com.ps.CustomerMiyagi.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // get one
    @GetMapping("{id}")
    public Product findOneProduct(int id) {

        return null;
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

        return null;
    }

    //create
    @PostMapping("{id}")
    public Product createProduct(Product product){
        return null;
    }


    // update
    @PutMapping("{id}")
    public void updateProduct(int id, Product product){

    }

    //delete
    @DeleteMapping("{id}")
    public void deleteAProduct(@PathVariable int id) {

    }
}
