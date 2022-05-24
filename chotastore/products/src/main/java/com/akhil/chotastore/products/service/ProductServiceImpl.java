package com.akhil.chotastore.products.service;

import com.akhil.chotastore.products.dao.ProductRepository;
import com.akhil.chotastore.products.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Products> getAllProducts() {
        List<Products> productsList=productRepository.findAll();
        return productsList;
    }
}
