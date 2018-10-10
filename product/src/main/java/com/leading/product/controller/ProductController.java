package com.leading.product.controller;

import com.leading.product.bean.Product;
import com.leading.product.mapper.ProductMapper;
import com.leading.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/dept/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/dept")
    public Product insertProduct(Product product){
        productService.insertProduct(product);
        return  product;
    }

    @PutMapping("/dept/{id}")
    public int updateProduct(Product product){
        return productService.updateProduct(product);
    }
}
