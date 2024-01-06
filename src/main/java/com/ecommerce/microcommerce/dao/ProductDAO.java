package com.ecommerce.microcommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.microcommerce.model.Product;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findByPriceGreaterThan(int priceLimit);
}
