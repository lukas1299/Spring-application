package com.example.SpringApp;

import com.example.SpringApp.model.Product;
import com.example.SpringApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product){

        return productRepository.save(product);
    }

    public Iterable<Product> get(){

        return productRepository.findAll();

    }

    /*@EventListener(ApplicationReadyEvent.class)
    public void addToDB(){

        save(new Product(1L,"Pomidor",1.99));
        save(new Product(2L, "Czekolada",2.99));

    }*/


}
