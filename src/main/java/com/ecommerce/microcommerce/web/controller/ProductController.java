package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDAO;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.exceptions.ProductNotFoundException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Api("API for CRUD operations on products.")

@RestController
public class ProductController {

    private final ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @RequestMapping(value = "/Products", method = RequestMethod.GET)
    public MappingJacksonValue listOfProducts() {

        Iterable<Product> products = productDAO.findAll();

        SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("purchasePrice");

        FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("myDynamicFilter", myFilter);

        MappingJacksonValue productFilters = new MappingJacksonValue(products);

        productFilters.setFilters(listOfOurFilters);

        return productFilters;
    }


    @ApiOperation(value = "Retrieves a product using it's ID provided that it is in stock!")
    @GetMapping(value = "/Products/{id}")
    public Product displayAProduct(@PathVariable int id) {

        Product product = productDAO.findById(id);

        if(product==null) throw new ProductNotFoundException("The product with the id " + id + " does not exist. Blue screen if I could.");

        return product;
    }

    @GetMapping(value = "test/products/{priceLimit}")
    public List<Product> queryTest(@PathVariable int priceLimit)
    {
        return productDAO.findByPriceGreaterThan(400);
    }

    @PostMapping(value = "/Products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product productAdded = productDAO.save(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (value = "/Products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productDAO.deleteById(id);
    }

    @PutMapping (value = "/Products")
    public void updateProduct(@RequestBody Product product)
    {
        productDAO.save(product);
    }
}
