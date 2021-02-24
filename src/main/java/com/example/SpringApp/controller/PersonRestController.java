package com.example.SpringApp.controller;


import com.example.SpringApp.ProductService;
import com.example.SpringApp.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/product")
public class PersonRestController {

    final ProductService productService;

    public PersonRestController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/get-product")
    public Iterable<Product> getAllProduct(){

        return productService.get();
    }







}
