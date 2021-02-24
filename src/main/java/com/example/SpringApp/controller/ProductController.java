package com.example.SpringApp.controller;

import com.example.SpringApp.ProductService;
import com.example.SpringApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
/*@RequestMapping("/api/product")*/
public class ProductController {

    private List<Product> products;
    Iterable<Product> lista;

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/product")
    public String getProduct(Model model){

        lista = productService.get();

        Iterator<Product> iterator = lista.iterator();

        products = new ArrayList<>();

        products.clear();

        iterator.forEachRemaining((element)->{ products.add(element); });

        model.addAttribute("products", products);
        model.addAttribute("newProduct", new Product());

        return "index";
    }
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product){


        //products.add(product);

        productService.save(product);

        return "redirect:/product";

    }

}
