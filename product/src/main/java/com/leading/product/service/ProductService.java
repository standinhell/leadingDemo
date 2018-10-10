package com.leading.product.service;

import com.codingapi.tx.annotation.TxTransaction;
import com.leading.product.bean.Product;
import com.leading.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.PrimitiveIterator;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product getProductById(Integer id){
        return productMapper.getProductById(id);
    }

    public Product insertProduct(Product product){
        productMapper.insertProduct(product);
        return  product;
    }

    @TxTransaction
    @Transactional
    public int updateProduct(Product product){
        return productMapper.updateProductById(product);
    }

}
