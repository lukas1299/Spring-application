package com.example.SpringApp.repository;

import com.example.SpringApp.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
