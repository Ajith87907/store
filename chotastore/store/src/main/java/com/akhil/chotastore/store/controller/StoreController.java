package com.akhil.chotastore.store.controller;

import com.akhil.chotastore.productdetails.entity.Product;
import com.akhil.chotastore.productdetails.service.ProductDetailService;
import com.akhil.chotastore.products.entity.Products;
import com.akhil.chotastore.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> showAllProducts(){
        List<Products> products = productService.getAllProducts();
        if (products.size() > 0) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> showSingleProduct(@PathVariable String id){
        int productId = Integer.valueOf(id);
        Product product = productDetailService.getSingleProduct(productId);
        if (product !=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
