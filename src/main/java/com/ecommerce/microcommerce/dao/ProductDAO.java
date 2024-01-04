package com.ecommerce.microcommerce.dao;

import org.springframework.stereotype.Repository;
import com.ecommerce.microcommerce.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
}
