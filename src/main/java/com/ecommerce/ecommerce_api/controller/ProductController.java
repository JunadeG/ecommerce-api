package com.ecommerce.ecommerce_api.controller;

import com.ecommerce.ecommerce_api.model.Product;
import com.ecommerce.ecommerce_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this class is the entry point of the api, it acts as the receptionist sorting out order and instructions.
@RestController // this annotation makes this class a spring controller, so it is automatically scanned for request mapping.
// it also enables @ResponseBody behaviour which converts the Java objects we return into JSON format for the web response.

@RequestMapping("api/products") // this maps all the HTTP requests that start with what is in the brackets.
//e.g., a GET request to "/api/products" will be handled here.

public class ProductController {

    @Autowired // this annotation performs a Dependency Injection. "An instance of ProductService" is needed to do my job.
    // it connects the controller layer to the service layer.

    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

        // this methods purpose is to get all the products from the service and give back what it is present.
    }



    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createdProduct = productService.createProduct(product);
       return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    // this methods purpose is to create a product to the service layer. The service saves the final object and presents it.
        // a HTTP response it created, showing us that a product had been created, and a 201 code is displayed.
    }
}
