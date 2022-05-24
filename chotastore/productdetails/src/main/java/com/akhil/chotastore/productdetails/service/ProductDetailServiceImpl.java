package com.akhil.chotastore.productdetails.service;

import com.akhil.chotastore.productdetails.dao.ProductDetailRepository;
import com.akhil.chotastore.productdetails.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public Product getSingleProduct(int id) {
        Optional<Product> products =productDetailRepository.findById(id);
        Product product = null;
        if (products.isPresent()){
            product = products.get();
        }
        return product;
    }
}
