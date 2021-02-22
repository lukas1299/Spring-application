package com.example.SpringApp.controller;

import com.example.SpringApp.ProductService;
import com.example.SpringApp.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/show")
    public String getProductsToIndex(Model model){

        List<Product> produkty = new ArrayList<Product>();

        Iterable<Product> lista = productService.get();

        Iterator<Product> iterator = lista.iterator();

        iterator.forEachRemaining((element)->{ produkty.add(element); });

        model.addAttribute("produkty", produkty);
        return "product";
    }
}
